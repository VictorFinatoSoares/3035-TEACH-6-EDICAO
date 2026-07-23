import { useContext } from 'react'; // Importa useContext para obter o contexto
import { TaskContext } from './TaskContext'; // Importa o contexto de TaskContext
import { TaskRow } from './TaskRow'; // Importa TaskRow para renderizar as linhas

// Função que renderiza linha por linha da tarefa
export function TaskTable() {
    // Tenta acessar o contexto de tarefas e retorna um erro se não conseguir (igual no TaskInput.tsx)
    const context = useContext(TaskContext);
    if (!context) throw new Error('TaskTable não consegue acessar o contexto de tarefas');

    // Referencia a lista de tarefas vinda do contexto
    const { tasksList } = context;

    // Renderiza a tabela
    return (
        <table>
            {/*Cabeçalho com cada informação já pré definida*/}
            <thead>
                <tr>
                    <th>Tarefa</th>
                    <th className = 'centralColumn'>Concluída</th>
                    <th className = 'centralColumn'>Excluir</th>
                </tr>
            </thead>
            {/*Corpo da tabela que, com base na lista de tarefas, para cada tarefa vai usar o taskrow (passando como parâmetro a própria tarefa) pra criar as linhas com as informações e botões*/}
            <tbody>
                {tasksList.map((task) => ( // Map percorre o array
                    <TaskRow key={task.id} task={task} /> // Pra cada tarefa o map acaba renderizando uma linha (o retorno de TaskRow)
                ))}
            </tbody>
        </table>
    );
}
