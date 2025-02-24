<template>
  <v-navigation-drawer
    width="200"
    :model-value="drawer"
    @update:model-value="$emit('update:drawer', $event)"
    app
    temporary
  >
    <v-list-item>
      <v-avatar>
        <v-img src="https://randomuser.me/api/portraits/men/78.jpg"></v-img>
      </v-avatar>

      <v-list-item-title>Usuário</v-list-item-title>
    </v-list-item>

    <v-divider></v-divider>

    <v-list dense>
      <v-list-item v-for="item in items" :key="item.title" :to="item.to" link>
        <v-icon>{{ item.icon }}</v-icon>

        <v-list-item-title>{{ item.title }}</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: "AppSidebar",
  props: ["drawer"],
  data() {
    return {
      items: [
        { title: "Home", icon: "mdi-home", to: "/" },
        { title: "About", icon: "mdi-help", to: "/about" },
      ],
    };
  },
};
</script>

<style scoped></style>
