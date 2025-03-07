<template>
  <div class="container">
    <TaskList />
    <div class="left">
      <DailyTask />
      <CreateTask />
    </div>
  </div>
</template>

<script>
import CreateTask from "@/components/CreateTask.vue";
import DailyTask from "@/components/DailyTask.vue";
import TaskList from "@/components/TaskList.vue";

export default {
  name: "Tasks",
  components: {
    CreateTask,
    DailyTask,
    TaskList,
  },
};
</script>

<style>
.container {
  display: flex;
  flex-direction: row;
  gap: 20px;
  justify-content: center;
}

.left {
  display: flex;
  flex-direction: column;
  gap: 20px;
  height: 20rem;
}
</style>
