import About from "@/views/Tasks.vue";
import Home from "@/views/Home.vue";
import { createRouter, createWebHistory } from "vue-router";
import Tasks from "@/views/Tasks.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/tasks",
      name: "Tasks",
      component: Tasks,
    },
  ],
});

export default router;
