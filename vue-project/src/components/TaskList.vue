<template>
  <div>
    <v-card class="card">
      <v-list class="card-list">
        <v-list-subheader>Task</v-list-subheader>

        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          :value="item"
          color="primary"
          rounded="xl"
        >
          <template v-slot:prepend>
            <v-checkbox class="checkbox" v-model="value" value="value">
            </v-checkbox>
          </template>

          <v-list-item-title v-text="item.text"></v-list-item-title>
        </v-list-item>
      </v-list>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "TaskList",
  data: () => ({
    items: [
      { text: "Comprar ração pro gato" },
      { text: "Comprar ração pro gato" },
      { text: "Comprar ração pro gato" },
      { text: "Comprar ração pro gato" },
    ],
  }),
};
</script>

<style lang="scss" scoped>
.card {
  border-radius: 24px;
  width: 27rem;
  height: 20rem;
}

.checkbox {
  display: flex;
  align-items: center;
}
</style>
