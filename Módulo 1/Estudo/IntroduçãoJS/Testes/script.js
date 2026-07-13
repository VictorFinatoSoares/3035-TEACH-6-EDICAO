// PRIMEIRO EXERCÍCIO:

// Temperatura informada pelo usuário
const temperatura = 32;

// Converte a temperatura informada (°F) para °C
function fahrenheitToCelsius(fahrenheitTemp) {
    const celsiusTemp = ((fahrenheitTemp - 32) * 5) / 9;
    return `${fahrenheitTemp}°F equivale a ${celsiusTemp}°C`;
}

// Converte a temperatura informada (°C) para °F
function celsiusToFahrenheit(celsiusTemp) {
    const fahrenheitTemp = (celsiusTemp * 1.8) + 32;
    return `${celsiusTemp}°C equivale a ${fahrenheitTemp}°F`
}

// Realiza um console.log passando as funções para receber o resultado de ambas as conversões
// console.log(fahrenheitToCelsius(temperatura))
// console.log(celsiusToFahrenheit(temperatura))

// SEGUNDO EXERCÍCIO:

const listaTemperaturas = [24, 25, 19, 17, 15, 29, 30]; // Lista de temperaturas obtidas em cada dia da semana

// Obtém a menor e maior temperatura
let menorTemp = Math.min(...listaTemperaturas);
let maiorTemp = Math.max(...listaTemperaturas);

// Faz o somatório das temperaturas de cada dia e divide pela quantidade de dias para obter a média
let mediaTemp = (listaTemperaturas.reduce((total, temperatura) => total + temperatura, 0) / listaTemperaturas.length).toFixed(2);

// Filtra quais dias estiveram abaixo da média semanal
let diasMenorTemp = listaTemperaturas.filter((temp) => temp < mediaTemp).length;

// console.log(`Menor temperatura da semana: ${menorTemp}°C\nMaior temperatura da semana: ${maiorTemp}°C\nTemperatura média semanal: ${mediaTemp}°C\nQuantidade de dias em que a temperatura esteve abaixo da média semanal: ${diasMenorTemp}`);

// TERCEIRO EXERCÍCIO:

// Lista com livros atuais
let bibliotecaLivros = [
    livro1 = {
        titulo: 'Confissões de um vira-lata',
        anoLançamento: 2022,
        autor: 'Orlando Pedroso'
    },
    livro2 = {
        titulo: 'Esperança para a família',
        anoLançamento: 2013,
        autor: 'Willie e Elaine Oliver'
    },
    livro3 = {
        titulo: 'A revolução dos bichos',
        anoLançamento: 1945,
        autor: 'George Orwell'
    },
    livro4 = {
        titulo: 'Manual de desculpas esfarrapadas',
        anoLançamento: 2004,
        autor: 'Daniel Kondo'
    },
    livro5 = {
        titulo: 'Fronteiras',
        anoLançamento: 2008,
        autor: 'Marcia Kupstas'
    }
];

// Adicionar livros:
function adicionarLivro(titulo, anoLançamento, autor) {
    bibliotecaLivros.push({titulo, anoLançamento, autor});
}

// Buscar livro pelo autor:
function buscarLivro(autor) {
    return  bibliotecaLivros.filter((livro) => livro.autor === autor);
}

// Alterar ano de lançamento:
function alterarAno(livroSelecionado, novoAno) {
    let livro = bibliotecaLivros.find((l) => l.titulo === livroSelecionado.titulo)
    if (livro) livro.anoLançamento = novoAno;
}
