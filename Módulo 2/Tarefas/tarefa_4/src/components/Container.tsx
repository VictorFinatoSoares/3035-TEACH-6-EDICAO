import { TaskProvider } from './TaskContext'; // Importa o responsável por fornecer o contexto para os componentes filhos
import { TasksList } from './TasksList'; // Importa o componente que renderiza a lista de tarefas

export function Container() {
    return (
        <div className = 'container'> 
            {/*Envolve o componente TasksList com o TaskProvider, permitindo que ele acesse o contexto de tarefas*/}
            <TaskProvider>
                <TasksList />
            </TaskProvider>
        </div>
    );
}
