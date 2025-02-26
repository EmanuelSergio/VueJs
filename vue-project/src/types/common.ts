export interface Task {
  id: number;
  status: boolean;
  title: string;
  description: string;
  startedDate: string; // LocalDateTime geralmente é representado como string (ISO 8601)
  finishedDate: string;
}

export interface createTask {
  title: string;
  description: string;
}
