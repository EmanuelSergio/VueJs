<template>
  <v-app>
    <AppHeader @toggle-sidebar="drawer = !drawer" />
    <div class="layout-content">
      <AppSidebar :drawer="drawer" @update:drawer="drawer = $event" />
      <v-main>
        <router-view></router-view>
      </v-main>
    </div>
    <AppFooter />
  </v-app>
</template>

<script>
import AppHeader from "./components/layout/Header.vue";
import AppFooter from "./components/layout/Footer.vue";
import AppSidebar from "./components/layout/Sidebar.vue";

export default {
  name: "App",
  components: {
    AppHeader,
    AppSidebar,
    AppFooter,
  },
  data() {
    return {
      drawer: false,
    };
  },
};
</script>

<style>
.layout-content {
  display: flex;
  flex: 1;
}

v-main {
  flex: 1;
}
</style>
