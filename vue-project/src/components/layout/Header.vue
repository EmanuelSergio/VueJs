<template>
  <v-app-bar app color="primary">
    <v-app-bar-nav-icon @click="$emit('toggle-sidebar')"></v-app-bar-nav-icon>
    <v-toolbar-title>Vue Project</v-toolbar-title>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppHeader",
  methods: {
    toggleSidebar() {
      console.log("header toggle");

      this.$emit("toggle-sidebar");
    },
  },
};
</script>

<style scoped></style>
