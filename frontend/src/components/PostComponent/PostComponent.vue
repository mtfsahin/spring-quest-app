<template>
    <div class="post-component">
        <h2 class="head-text">PostComponent</h2>
        <div class="post-list">
            <div v-if="posts.length === 0" class="post-null">
                No posts available!
            </div>
            <div v-else>
                <div v-for="post in posts" :key="post.id" class="post">
                    <div class="post-header">
                        <h3 class="post-title">{{ post.title }}</h3>
                        <div class="post-buttons">
                            <!-- Like Button -->
                            <ButtonComponent @click="likePost" type="icon">
                                <template v-if="likeStatus">
                                    <HeartIcon class="icon-heart" />
                                </template>
                                <template v-else>
                                    <HeartIcon style=" width: 20px;height: 20px;color: red;cursor: pointer;stransition: 0.4s;" />
                                </template>
                            </ButtonComponent>
                            <!-- Edit Button -->
                            <ButtonComponent @click="editContent" type="icon" v-if="permissionStatus">
                                <template v-if="editIcon">
                                    <PencilSquareIcon class="icon-pencil" />
                                </template>
                                <template v-else>
                                    <CheckIcon class="icon-check" />
                                </template>
                            </ButtonComponent>
                            <!-- Delete Button -->
                            <ButtonComponent type="icon" v-if="permissionStatus">
                                <TrashIcon class="icon-trash" />
                            </ButtonComponent>
                        </div>
                    </div>
                    <div class="post-content">
                        <div v-if="editMode" class="post-text textarea-edit">
                            <textarea rows="1" v-model="post.text" ref="textarea" @input="handleTextareaInput"></textarea>
                        </div>
                        <div v-else class="post-text textarea-container">
                            {{ post.text }}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<script>

import axios from 'axios';
import ButtonComponent from '../ButtonComponent/ButtonComponent.vue';
import { PencilSquareIcon, CheckIcon, HeartIcon, TrashIcon } from '@heroicons/vue/24/solid'


const baseUrl = "http://localhost:8080/posts";

export default {
    components: {
        ButtonComponent,
        PencilSquareIcon,
        CheckIcon,
        HeartIcon,
        TrashIcon,


    },
    data() {
        return {
            posts: [],
            editMode: false,
            permissionStatus: false,
            likeStatus: true,
            editIcon: true,
            fullText: "",
            visibleText: "",
            expanded: false,
            textareaHeight: 20,
            limit: 15,
        }
    },
    methods: {
        editContent() {
            // Switch to edit mode for the selected post
            this.editMode = !this.editMode;
            this.editIcon = !this.editIcon;
        },
        likePost() {
            this.likeStatus = !this.likeStatus;
        }
    },
    computed: {
        instruction: function () {
            return this.message == '' ?
                'limit:' + this.limit + 'characters' :
                'reamining ' + this.reaming + ' characters';
        },
        reamining: function () {
            return this.limit - this.message.length;
        }
    },
    mounted() {
        axios.get(baseUrl)
            .then(response => {
                // Handle the successful response
                this.posts = response.data;
            })
            .catch(error => {
                // Handle the error
                console.error('Error:', error);
            });
    },
}
</script>

<style scoped>
.post-component {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
}

.head-text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
    margin-bottom: 20px;
}

.post-list {
    width: 100%;
    max-width: 800px;
}

.post-null {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100px;
    font-size: 18px;
    color: #555;
}

.post {
    border: 1px solid #ddd;
    border-radius: 10px;
    margin: 10px 0;
    padding: 10px;
    background-color: #f9f9f9;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.post-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
}

.post-title {
    font-size: 20px;
    font-weight: bold;
    color: #333;
}

.post-buttons {
    display: flex;
    gap: 10px;
}

.icon-pencil,
.icon-check,
.icon-heart,
.icon-trash {
    width: 20px;
    height: 20px;
    color: #555;
    cursor: pointer;
    transition: color 0.2s ease-in-out;
}

.icon-pencil:hover,
.icon-check:hover,
.icon-heart:hover,
.icon-heart-liked:hover,
.icon-trash:hover {
    color: #333;
}

.icon-heart-liked {
    color: red;
}

.post-content {
    position: relative;
    overflow: hidden;
    height: auto;
}

.textarea-edit textarea {
    width: 100%;
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 10px;
    resize: vertical;
    font-family: inherit;
}

.textarea-container {
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 10px;
    height: 120px;
    font-family: inherit;
    white-space: pre-line;
    line-height: 1.5;
}
</style>