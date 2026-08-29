const todos = [
  "Comer pizza",
  "Estudar TypeScript",
  "Fazer exercícios",
  "Estudar React",
];

export async function getTodos() {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  return todos;
}

export async function addTodo(todo: string) {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  todos.push(todo);
  return todos;
}

export async function deleteTodo(index: number) {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  todos.splice(index, 1);
  return todos;
}
