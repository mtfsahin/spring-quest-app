import "./assets/main.css";

import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";
import VueGridLayout from 'vue-grid-layout';


const app = createApp(App);

export default {
    components: {
        GridLayout: VueGridLayout.GridLayout,
        GridItem: VueGridLayout.GridItem
    },
}

app.use(createPinia());
app.use(router);

app.mount("#app");
