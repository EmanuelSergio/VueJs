<template>
  <div class="container">
    <v-card
      width="500"
      title="Bem vindo"
      subtitle="Lista de afazeres"
      text="Aqui você podera marcar todos os seus afazeres importantes"
    >
      <v-card-actions>
        <RouterLink to="/tasks">
          <v-btn>Começar</v-btn>
        </RouterLink>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import { RouterLink } from "vue-router";

export default {
  name: "Home",
};
</script>

<style>
.container {
  align-items: center;
  display: flex;
  justify-content: center;
  height: 100%;
  width: 100%;
}
</style>
