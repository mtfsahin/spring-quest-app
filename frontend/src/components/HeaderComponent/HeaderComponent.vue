<template>
    <header>
        <nav class="navbar">
            <div class="logo">LOGO</div>

            <ul class="nav-list">
                <li v-for="page in pages" :key="page.id" class="nav-item">
                    <a :href="page.url">{{ page.title }}</a>
                </li>
                <a class="login-button">Login</a>
            </ul>
        </nav>
    </header>
</template>

<script>
export default {
    name: 'Header',
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
    border-width: 0 4px 4px 4px;
    border-color: #DCD7C9;
    border-style: solid;
}

.logo {
    color: #DCD7C9;
    padding: 10px;
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

.login-button {
    background-color: #A27B5C;
    padding: 10px;
    border-radius: 5px;
    border-style: dashed;
    cursor: pointer;
}

.login-button:hover {
    background-color: #DCD7C9;
    transition: 0.4s;
    padding-left: 10px;
    color: #3F4E4F;
    padding-right: 10px;
    border-radius: 5px;
    border-style: dashed;
}


p {
    margin-top: 10px;
}


</style>
  