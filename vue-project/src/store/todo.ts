import type { Task } from "@/types/common";
import { defineStore } from "pinia";

export const useTodoStore = defineStore("todo", {
  state: () => ({}),
  actions: {
    //montar requisicoes

    async createTasks(task: Task) {
      try {
        const response = await fetch("http://localhost:8080/task", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(task),
        });

        if (!response.ok) {
          throw new Error("erro ao criar tarefa");
        }

        const newTask = await response.json();
      } catch (error) {}
    },
  },
});
