<template>
    <div class="post-container">
        <h2>PostComponent</h2>

    </div>
</template>

<script>

    import axios from 'axios';

    export default{
        data(){
            return {
                posts: []
            }
        },
        methods: {

        },
        mounted() {
            axios
                .get("http://localhost:8080/posts")
                .then(response => {
                    this.posts = response.data.posts;
                })
            console.log(this.posts)
        }
    }
</script>

<style scoped>
    .post-container {
        display: flex;
        justify-content: center;
        padding: 20px;
    }

    
</style>