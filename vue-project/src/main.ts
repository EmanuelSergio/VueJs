import "./assets/main.scss";

import { createApp } from "vue";

import router from "./router";
import App from "./App.vue";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import { aliases, mdi } from "vuetify/iconsets/mdi";
import "@mdi/font/css/materialdesignicons.css";

const vuetify = createVuetify({
  components,
  directives,
  theme: {
    defaultTheme: "lightTheme",
    themes: {
      lightTheme: {
        dark: false,
        colors: {
          primary: "#5C6BC0", // Azul índigo
          secondary: "#26A69A", // Verde teal
          accent: "#FF7043", // Laranja profundo
          error: "#EF5350", // Vermelho claro
          info: "#42A5F5", // Azul claro
          success: "#66BB6A", // Verde claro
          warning: "#FFA726", // Âmbar
          background: "#F5F5F5", // Cinza muito claro
        },
      },
    },
  },
});

const app = createApp(App).use(vuetify);

app.use(router);

app.mount("#app");
