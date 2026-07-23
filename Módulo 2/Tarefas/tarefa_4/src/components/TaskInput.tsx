// Importa o useState (para variável tarefa) e useContext pra acessar o contexto de tarefas
import { useState, useContext } from 'react';
import { TaskContext } from './TaskContext'; // Importa o contexto de taskContext

// Função que renderiza o input e botão para adicionar tarefas
export function TaskInput() {
    // Tenta acessar o contexto de tarefas
    const context = useContext(TaskContext);
    // Se o contexto não for encontrado (estiver com o valor undefined), lança um erro
    if (!context) throw new Error('TaskInput não conseguiu acessar o contexto de tarefas');

    // Caso contrário, referencia a função addTask vinda do contexto
    const { addTask } = context;

    // Cria um estado (string inicialmente vazia), que guardará a tarefa que o usuário digitar
    const [tarefa, setTarefa] = useState('');

    // Função que gerencia a adição da tarefa com addTask do contexto e limpa o input depois de adicionar
    function manageAdd() {
        addTask(tarefa);
        setTarefa(''); 
    }

    // TaskInput.tsx vai retornar um input e um botão que vão receber a tarefa, e adicionar ela à lista depois de clicar
    return (
        <div className='inputLine'>
            <input className = 'taskInput' placeholder='Adicionar Tarefa...' value={tarefa}onChange={t => setTarefa(t.target.value)}/>
            <button className = 'addTaskButton' onClick={manageAdd}>Adicionar</button>
        </div>
    );
}