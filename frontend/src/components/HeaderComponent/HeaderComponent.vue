<template>
    <header>
        <nav class="navbar">
            <div class="logo">QUEST APP</div>

            <ul class="nav-list">
                <li v-for="page in pages" :key="page.id" class="nav-item">
                    <a :href="page.url">{{ page.title }}</a>
                </li>
                <ButtonComponent>Login</ButtonComponent>
            </ul>
        </nav>
    </header>
</template>

<script>

import ButtonComponent from '../ButtonComponent/ButtonComponent.vue';

export default {
    name: 'Header',
    components:{
        ButtonComponent,
    },
    data() {
        return {
            pages: [
                { id: 1, title: 'Home', url: '/' },
                { id: 2, title: 'About', url: '/about' },
            ],
            isLoading: false,
        };
    },
    methods: {
        
    },
};
</script>
  
<style scoped>

.navbar {
    display: flex;
    align-items: center;
    width: 70%;
    margin: auto;
    justify-content: space-between;
    padding: 10px 20px;
    background-color: #3F4E4F;
    border-radius: 0 0 20px 20px;
    border-width: 1px 4px 4px 4px;
    border-color: #DCD7C9;
    border-style: solid;
}

.logo {
    color: #DCD7C9;
    padding: 10px;
    font-weight: bold;
}

.nav-list {
    display: flex;
    list-style: none;
    margin: 0;
    padding: 0;
    gap: 14px;
}

.nav-item {
    padding: 10px;
}

p {
    margin-top: 10px;
}


</style>
  