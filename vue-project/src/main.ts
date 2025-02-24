import "./assets/main.scss";

import { createApp } from "vue";

import router from "./router";
import App from "./App.vue";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";

const vuetify = createVuetify({
  components,
  directives,
});

const app = createApp(App).use(vuetify);

app.use(router);

app.mount("#app");
