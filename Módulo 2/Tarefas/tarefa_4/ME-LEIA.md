A tarefa foi realizada usando o TypeScript 4.9.5

Sobre a tarefa: Após concluir, decidi comentar tudo que achei importante, para reforçar o entendimento, deixando bem documentado

Em resumo:

App.tsx renderiza o Container.tsx

Container.tsx é uma div que contém o TasksList (a renderização da tabela e a parte de receber input) dentro do TaskProvider (que é o componente que transmite o contexto para os componentes-filhos)

TaskContext.tsx é onde fica a parte lógica da tabela (a lista de objetos, as funções de adicionar etc) que vai ser transmitida

TaskInput.tsx recebe a função de adicionar tarefa vinda do contexto para adicionar novas tarefas à lista

TaskRow.tsx é a parte responsável por criar linha por linha da lista de tarefas, com as informações e botões de ação (excluir e concluir) que recebe as funções vindas do contexto para essas mesmas ações

TaskTable.tsx que renderiza as linhas (TaskRow no tbody) e as categorias de informação (o cabeçalho em thead) 

TasksList.tsx que é somente responsável por renderizar TaskInput.tsx e TaskTable.tsx e ser renderizada dentro do Container.tsx entre TaskProvider para obter o contexto que seus filhos vão acessar diretamente.