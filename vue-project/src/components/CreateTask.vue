<template>
  <div class="task-creator-container">
    <v-card class="task-card" elevation="3" rounded="lg">
      <v-card-item>
        <v-card-title class="">Criar Nova Tarefa</v-card-title>

        <v-card-text class="card-text">
          <v-text-field
            v-model="taskName"
            class="task-input"
            name="taskName"
            placeholder="Digite sua tarefa aqui"
            :rules="nameRules"
            density="comfortable"
            hide-details="auto"
          ></v-text-field>
        </v-card-text>

        <v-card-actions>
          <v-btn color="primary" :disabled="!isFormValid" @click="createTask"
            >Adicionar Tarefa</v-btn
          >
        </v-card-actions>
      </v-card-item>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "CreateTask",
  data() {
    return {
      taskName: "",
      nameRules: [
        (v) => !!v || "Nome da tarefa é obrigatório",
        (v) => v.length <= 50 || "O nome deve ter no máximo 50 caracteres",
      ],
    };
  },
  computed: {
    isFormValid() {
      return this.taskName.length > 0 && this.taskName.length <= 50;
    },
  },
  methods: {
    createTask() {
      if (this.isFormValid) {
        const newTask = {
          name: this.taskName,
        };

        this.$emit("task-created", newTask);
        this.resetForm();
      }
    },
    resetForm() {
      this.taskName = "";
      this.taskDescription = "";
      this.priority = "Média";
    },
  },
};
</script>

<style lang="scss" scoped>
.task-input:deep(.v-field__input) {
  padding-left: 16px;
  border: none;
  background-color: transparent;
}

.task-creator-container {
  display: flex;
  justify-content: center;
  padding-top: 16px;
}

.card-text {
  margin-top: 15px;
}

.task-card {
  width: 27rem;
  background-color: #ffffff;
  border-radius: 24px;
  transition: transform 0.2s, box-shadow 0.2s;

  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
  }
}

.task-input {
  border-radius: 20px;
  border: solid 2px black;
}
</style>
