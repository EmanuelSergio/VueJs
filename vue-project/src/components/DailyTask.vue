<template>
  <div>
    <v-card class="card">
      <v-checkbox class="checkbox" v-model="value" value="value"> </v-checkbox>
      <v-card-title primary-title> Comprar ração pro gato </v-card-title>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "DailyTask",
  data: () => ({
    items: [{ text: "Comprar ração para o gato" }],
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

.checkbox {
  display: flex;
  align-items: center;
}
</style>
