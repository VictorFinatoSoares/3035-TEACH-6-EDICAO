import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { useState } from "react";
import { addTodo, deleteTodo, getTodos } from "./api/todos";
import "./App.css";

export default function App() {
  const queryClient = useQueryClient();
  const [newTodo, setNewTodo] = useState("");

  const { isLoading, data: todos = [] } = useQuery({
    queryKey: ["todos"],
    queryFn: getTodos,
  });

  const addTodoMutation = useMutation({
    mutationFn: async (todo: string) => addTodo(todo),
    onSuccess: (updatedTodos) => {
      queryClient.setQueryData(["todos"], updatedTodos);
      setNewTodo("");
    },
  });

  const deleteTodoMutation = useMutation({
    mutationFn: async (id: number) => deleteTodo(id),
    onSuccess: (updatedTodos) => {
      queryClient.setQueryData(["todos"], updatedTodos);
    },
  });

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const todo = newTodo.trim();
    if (!todo) return;

    addTodoMutation.mutate(todo);
  };

  if (isLoading) {
    return (
      <main className="app-shell">
        <div className="loading-card">Carregando tarefas...</div>
      </main>
    );
  }

  return (
    <main className="app-shell">
      <section className="todo-card">
        <header className="todo-header">
          <p className="eyebrow">React Query</p>
          <h1>Lista de tarefas</h1>
        </header>

        <form className="todo-form" onSubmit={handleSubmit}>
          <input
            type="text"
            value={newTodo}
            onChange={(event) => setNewTodo(event.target.value)}
            placeholder="Digite uma tarefa"
            disabled={addTodoMutation.isPending}
            aria-label="Nova tarefa"
          />
          <button
            type="submit"
            className="primary-button"
            disabled={addTodoMutation.isPending || !newTodo.trim()}
          >
            {addTodoMutation.isPending ? "Adicionando..." : "Adicionar"}
          </button>
        </form>

        <ul className="todo-list">
          {todos.length === 0 ? (
            <li className="empty-state">Nenhuma tarefa cadastrada.</li>
          ) : (
            todos.map((todo, index) => (
              <li key={`${todo}-${index}`} className="todo-item">
                <span>{todo}</span>
                <button
                  type="button"
                  className="secondary-button"
                  disabled={deleteTodoMutation.isPending}
                  onClick={() => deleteTodoMutation.mutate(index)}
                >
                  {deleteTodoMutation.isPending ? "Removendo..." : "Excluir"}
                </button>
              </li>
            ))
          )}
        </ul>
      </section>
    </main>
  );
}
