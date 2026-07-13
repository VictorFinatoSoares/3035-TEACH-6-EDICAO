let tarefas = [];
let filtroAtual = "todas";

function adicionarTarefa(nome) {
  const novaTarefa = {
    id: Date.now(),
    nome: nome,
    dataCriacao: new Date().toLocaleDateString("pt-BR"),
    concluida: false
  };

  tarefas.push(novaTarefa);
  renderizarTarefas();
}

function marcarComoConcluida(id) {
  const tarefa = tarefas.find((t) => t.id === id);

  if (tarefa) {
    tarefa.concluida = !tarefa.concluida;
    renderizarTarefas();
  }
}

function removerTarefa(id) {
  tarefas = tarefas.filter((t) => t.id !== id);
  renderizarTarefas();
}

function listarPendentes() {
  return tarefas.filter((t) => !t.concluida);
}

function listarConcluidas() {
  return tarefas.filter((t) => t.concluida);
}

function renderizarTarefas() {
  const lista = document.getElementById("lista-tarefas");
  lista.innerHTML = "";

  let tarefasParaExibir = tarefas;
  if (filtroAtual === "pendentes") {
    tarefasParaExibir = listarPendentes();
  } else if (filtroAtual === "concluidas") {
    tarefasParaExibir = listarConcluidas();
  }

  tarefasParaExibir.forEach((tarefa) => {
    const li = document.createElement("li");
    li.className = "tarefa";

    li.innerHTML = `
      <input type="checkbox" ${tarefa.concluida ? "checked" : ""}>
      <div class="tarefa-info">
        <span class="tarefa-nome ${tarefa.concluida ? "concluida" : ""}">${tarefa.nome}</span>
        <span class="tarefa-data">Criada em ${tarefa.dataCriacao}</span>
      </div>
      <button class="btn-remover" title="Remover">&times;</button>
    `;

    li.querySelector('input[type="checkbox"]').addEventListener("click", () => {
      marcarComoConcluida(tarefa.id);
    });

    li.querySelector(".btn-remover").addEventListener("click", () => {
      removerTarefa(tarefa.id);
    });

    lista.appendChild(li);
  });

  atualizarContador();
}

function atualizarContador() {
  const contador = document.getElementById("contador");
  const pendentes = listarPendentes().length;
  const total = tarefas.length;
  contador.textContent = `${pendentes} pendente(s) de ${total} tarefa(s)`;
}


const form = document.getElementById("form-tarefa");
const input = document.getElementById("input-tarefa");

form.addEventListener("submit", (evento) => {
  evento.preventDefault();

  const nome = input.value.trim();
  if (nome === "") return;

  adicionarTarefa(nome);
  input.value = "";
  input.focus();
});

const botoesFiltro = document.querySelectorAll(".filtro-btn");

botoesFiltro.forEach((botao) => {
  botao.addEventListener("click", () => {
    botoesFiltro.forEach((b) => b.classList.remove("ativo"));
    botao.classList.add("ativo");
    filtroAtual = botao.dataset.filtro;
    renderizarTarefas();
  });
});

renderizarTarefas();