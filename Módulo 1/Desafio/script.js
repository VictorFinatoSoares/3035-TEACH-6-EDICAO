const cadastroForm = document.getElementById("cadastro-form");

if (cadastroForm) {
    cadastroForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const novoCliente = {
            tutorNome: document.getElementById("tutor-nome").value,
            tutorTelefone: document.getElementById("tutor-telefone").value,
            tutorEndereco: document.getElementById("tutor-endereco").value,
            tutorData: document.getElementById("tutor-data").value,
            animalNome: document.getElementById("animal-nome").value,
            animalIdade: document.getElementById("animal-idade").value,
            animalPorte: document.getElementById("animal-porte").value
        };

        const clientes = JSON.parse(localStorage.getItem("clientes")) || [];
        clientes.push(novoCliente);
        localStorage.setItem("clientes", JSON.stringify(clientes));

        document.getElementById("cadastro-message").textContent = "Cliente cadastrado com sucesso!";
        cadastroForm.reset();
    });
}

const clientesContainer = document.getElementById("clientes-container");

if (clientesContainer) {
    const clientes = JSON.parse(localStorage.getItem("clientes")) || [];

    if (clientes.length === 0) {
        clientesContainer.innerHTML = "<p id='sem-clientes'>Nenhum cliente cadastrado ainda.</p>";
    } else {
        clientes.forEach(function (cliente, index) {
            const card = document.createElement("div");
            card.className = "cliente-card";
            card.innerHTML =
                "<p class='nome-animal'>" + cliente.animalNome + "</p>" +
                "<p class='data-atendimento'>Atendimento: " + cliente.tutorData + "</p>";

            card.addEventListener("click", function () {
                abrirModal(index);
            });

            clientesContainer.appendChild(card);
        });
    }

    function abrirModal(index) {
        const cliente = clientes[index];

        document.getElementById("modal-tutor-nome").textContent = cliente.tutorNome;
        document.getElementById("modal-tutor-telefone").textContent = cliente.tutorTelefone;
        document.getElementById("modal-tutor-endereco").textContent = cliente.tutorEndereco;
        document.getElementById("modal-tutor-data").textContent = cliente.tutorData;
        document.getElementById("modal-animal-nome").textContent = cliente.animalNome;
        document.getElementById("modal-animal-idade").textContent = cliente.animalIdade;
        document.getElementById("modal-animal-porte").textContent = cliente.animalPorte;

        document.getElementById("modal-overlay").style.display = "flex";
    }

    document.getElementById("fechar-modal").addEventListener("click", function () {
        document.getElementById("modal-overlay").style.display = "none";
    });

    document.getElementById("modal-overlay").addEventListener("click", function (event) {
        if (event.target === this) {
            this.style.display = "none";
        }
    });
}

const produtosContainer = document.getElementById("produtos-container");

if (produtosContainer) {
    const produtos = [
        { nome: "Ração para Cães", valor: "R$ 89,90", imagem: "https://images.unsplash.com/photo-1684882726821-2999db517441?w=400&h=400&fit=crop&q=80" },
        { nome: "Ração para Gatos", valor: "R$ 74,90", imagem: "https://images.unsplash.com/photo-1596854331442-3cf47265cefb?w=400&h=400&fit=crop&q=80" },
        { nome: "Coleira Ajustável", valor: "R$ 29,90", imagem: "https://images.unsplash.com/photo-1546687813-3fcc1c363a07?w=400&h=400&fit=crop&q=80" },
        { nome: "Brinquedo Mordedor", valor: "R$ 19,90", imagem: "https://images.unsplash.com/photo-1535294435445-d7249524ef2e?w=400&h=400&fit=crop&q=80" },
        { nome: "Shampoo Pet", valor: "R$ 24,90", imagem: "https://images.unsplash.com/photo-1701992678972-d5a053ad0fb0?w=400&h=400&fit=crop&q=80" },
        { nome: "Cama para Pet", valor: "R$ 99,90", imagem: "https://images.unsplash.com/photo-1541188495357-ad2dc89487f4?w=400&h=400&fit=crop&q=80" }
    ];

    produtos.forEach(function (produto) {
        const card = document.createElement("div");
        card.className = "produto-card";
        card.innerHTML =
            "<img src='" + produto.imagem + "' alt='" + produto.nome + "'>" +
            "<p class='nome-produto'>" + produto.nome + "</p>" +
            "<p class='valor-produto'>" + produto.valor + "</p>";

        card.addEventListener("click", function () {
            const carrinho = JSON.parse(localStorage.getItem("carrinho")) || [];
            carrinho.push(produto);
            localStorage.setItem("carrinho", JSON.stringify(carrinho));

            document.getElementById("carrinho-message").textContent =
                produto.nome + " foi adicionado ao carrinho de compras!";
        });

        produtosContainer.appendChild(card);
    });
}
