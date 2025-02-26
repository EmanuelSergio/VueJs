<template>
  <div class="container">
    <v-card v-for="(task, index) in tasks" :key="index" class="card">
      <v-checkbox class="checkbox" v-model="value" value="value"> </v-checkbox>
      <v-card-title primary-title>{{ task.text }}</v-card-title>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "DailyTask",
  data: () => ({
    tasks: [
      { text: "Comprar ração para o gato" },
      { text: "Comprar ração para o gato" },
    ],
  }),
};
</script>

<style lang="scss" scoped>
.card {
  display: flex;
  flex-direction: row;
  align-items: center;
  border-radius: 24px;
  width: 27rem;
}

.container {
  display: flex;
  flex-direction: column;
}

.checkbox {
  display: flex;
  align-items: center;
}
</style>
