<template>
    <div>
        <Header/>
        <PostComponent/>
    </div>
</template>


<script>
import Header from '../HeaderComponent/HeaderComponent.vue'; // Adjust the import path based on your project structure
import PostComponent from '../PostComponent/PostComponent.vue'

export default {
  components: {
    Header,
    PostComponent,
    
  },
};
</script>

<style scoped>

</style>