// Importa o useContext pra acessar o contexto de TaskContext.tsx
// Também vai importar o taskContext pra acessar o contexto, e a interface Task pra tipar a task recebida
import { useContext } from 'react';
import { TaskContext, Task} from './TaskContext';

// Define uma interface pra o que vai ser recebido pra cada linha (que no caso é a tarefa com as propriedades name etc)
interface TaskRowProps {
    task: Task;
}

// Função que recebe a task de TaskRowProps como parâmetro pra retornar a linha com as informações da tarefa
export function TaskRow({ task }: TaskRowProps) {
    // Tenta acessar o contexto de tarefas e retorna um erro se não conseguir (igual no TaskInput.tsx)
    const context = useContext(TaskContext);
    if (!context) throw new Error('TaskRow não conseguiu acessar o contexto de tarefas');

    // Referencia as funções para completar e excluir tarefas, vindas do contexto
    const { completeTask, deleteTask } = context;

    // Por fim, retornará uma linha de tabela com as informações da tarefa e os botões que vão realizar as suas respectivas ações
    return (
        <tr className = {task.done ? 'completedTask' : ''}> 
            <td className = 'taskName'>{task.name}</td>
            <td className = 'centralBtn'> 
                {/*Atribui a função de completar pra esse checkbox*/}
                <input className = 'completeCheckBox' type='checkbox' checked={task.done} onChange={() => completeTask(task.id)} />
            </td>
            <td className = 'centralBtn'>
                {/*Atribui a função de excluir pra esse botão*/}
                <button className='deleteBtn' onClick={() => deleteTask(task.id)}>X</button>
            </td>
        </tr>
    );
}