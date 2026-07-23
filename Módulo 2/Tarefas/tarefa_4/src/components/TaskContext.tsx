// Importa useState (pra iniciar a tasksList como estado), createContext (pra criar o contexto) e ReactNode pra tipar o children da função 
import { useState, createContext, ReactNode} from 'react';

{/*Propriedades para cada objeto tarefa*/}
export interface Task { id: number; name: string; done: boolean; }

{/*O que será transmitido pelo TaskProvider*/}
interface TaskContextType {
    tasksList: Task[]; // Lista de tarefas (array de objetos Task)
    addTask: (task: string) => void;  // Função que adiciona uma tarefa (recebe o nome dela)
    completeTask: (id: number) => void; // Função que completa uma tarefa (recebe o ID para realizar uma verificação)
    deleteTask: (id: number) => void; // Função que deleta uma função (também recebe só o ID para filtrar)
}

{/*Cria o contexto, que será usado para compartilhar as informações entre os componentes*/}
export const TaskContext = createContext<TaskContextType | undefined>(undefined);

// Função que fornece o contexto para os componentes filhos, permitindo que eles acessem e modifiquem a lista de tarefas
export function TaskProvider({children}: {children: ReactNode}) {
    // Estado que mantém a lista de tarefas, inicialmente vazia
    const [tasksList, setTasksList] = useState<Task[]>([]);

    {/*Função que adiciona a tarefa (recebe apenas o nome dela)*/}
    function addTask(task: string) {
        {/*Caso não tenha nada escrito, ela não faz nada, apenas retorna*/}
        if (task.trim() === '') return;
        
        {/*Cria uma nova lista (que será igual ao tasksList atual), adicionando o novo objeto Task ao final*/}
        setTasksList([...tasksList, {id: Date.now(), name: task, done: false}])
    }

    {/*Função que completa uma tarefa (recebe o ID para realizar uma verificação)*/}
    function completeTask(id: number) {
        {/*Percorre o array tarefa por tarefa, procurando o ID da tarefa que foi marcada/desmarcada 
        (se o id da tarefa for igual ao id recebido, ele cria um novo objeto com as mesmas propriedades da tarefa
        mas com o valor de done invertido, caso contrário ele apenas retorna a tarefa como está).*/}
        setTasksList(tasksList.map(task =>
            task.id === id ? {...task, done: !task.done} : task
        ))
    }

    {/*Função que deleta uma função (também recebe só o ID para filtrar)*/}
    function deleteTask(id: number) {
        {/*Realiza uma filtragem tarefa por tarefa procurando o ID da tarefa  deletada, e ignorando ela 
        para que após atualizar a lista, essa tarefa não apareça mais.*/}
        setTasksList(tasksList.filter(task =>
            task.id !== id
        ))
    }

    return (
        //Retorna o TaskContext.Provider, que fornece o contexto para os componentes filhos
        //Permitindo que eles acessem e modifiquem a lista de tarefas
        <TaskContext.Provider value ={{tasksList, addTask, completeTask, deleteTask}}>
            {children}
        </TaskContext.Provider>
    );
}
