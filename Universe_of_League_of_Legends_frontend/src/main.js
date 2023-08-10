import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import { axios1, post, get } from './request/request';

const app = createApp(App)
app.use(store)
app.use(router)

// app.config.globalProperties['$get'] = get;
// app.config.globalProperties['$post'] = post;
// app.config.globalProperties['$axios'] = axios1;

app.mount("#app")


// createApp(App).use(store).use(router).mount('#app')
