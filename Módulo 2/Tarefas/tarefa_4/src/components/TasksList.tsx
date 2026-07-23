// TasksList vai importar TaskInput e TaskTable para serem renderizadas dentro do Container
import { TaskInput } from './TaskInput';
import { TaskTable } from './TaskTable';

export function TasksList() {
    return (
        <>
            <TaskInput />
            <TaskTable />
        </>
    );
}
