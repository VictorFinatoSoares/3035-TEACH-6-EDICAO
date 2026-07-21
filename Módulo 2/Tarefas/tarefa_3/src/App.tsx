import React, {useState} from 'react';
import list from './data/filmes.json';
import './App.css';

function App() {
  // Constantes com os useStates
  const [filmeBuscado, setFilmeBuscado] = useState('');
  const [filmeSelecionado, setFilmeSelecionado] = useState('Nenhum'); 

  const filmesFiltrados = list.filter(filme =>
    filme.nome.toLowerCase().includes(filmeBuscado.toLowerCase())
  );

  return (
    <div>
      <input placeholder='Buscar filmes' value={filmeBuscado} onChange={f => setFilmeBuscado(f.target.value)}></input>
      
      {/* Serve pra saber se a lista de filmes filtrados encontrou um filme*/}
      {filmesFiltrados.length === 0 ? ( 
        <h1>Nenhum filme encontrado!</h1>  // Caso não encontrou
      ): 
      /* Caso encontrou ao menos um filme */
        <div>
          <h1>Filme Selecionado: {filmeSelecionado}</h1>
          <table>
            <thead>
              <tr>
                <th>ID</th> 
                <th>Nome</th>
                <th>Gênero</th>
                <th>Capa</th>
                {/*Nova coluna com a opção de selecionar o filme que aparecer*/}
                <th>Selecionar</th> 
              </tr>
            </thead>
            <tbody> 
              {/*Cria uma linha pra cada filme encontrado, passando as informações (nome, id etc em td)*/}
              {filmesFiltrados.map((filme) => (
                <tr key = {filme.id}>
                  <td>{filme.id}</td>
                  <td>{filme.nome}</td>

                  <td>{filme.genero}</td>
                  <td>
                    {/* Passa o link da imagem no parâmetro src da tag img pra exibir a imagem */}
                    <img className = 'capas' src = {filme.imagem} alt = {filme.nome}></img>
                  </td>
                  <td>
                    {/*Adiciona o input (checkbox) que verifica se o filme selecionado atual é igual ao nome do filme do checkbox clicado, se for, ele deseleciona (pois já estava selecionado), caso contrário, ele atribui o filme escolhido*/}
                   <input type = 'checkbox' checked = {filmeSelecionado === filme.nome} onChange = {() => setFilmeSelecionado(filmeSelecionado === filme.nome? 'Nenhum': filme.nome)} className = 'checkBox'></input>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>}
      </div>
    );
  }
export default App;
