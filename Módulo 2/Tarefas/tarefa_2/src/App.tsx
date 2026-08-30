import React, { useState } from "react";
import list from "./data/filmes.json";
import "./App.css";

function App() {
  const [filmeBuscado, setFilmeBuscado] = useState("");

  const filmesFiltrados = list.filter((filme) =>
    filme.nome.toLowerCase().includes(filmeBuscado.toLowerCase()),
  );

  return (
    <div>
      <input
        placeholder="Buscar filmes"
        value={filmeBuscado}
        onChange={(f) => setFilmeBuscado(f.target.value)}
      ></input>

      {filmesFiltrados.length === 0 ? ( // Serve pra saber se a lista de filmes filtrados encontrou um filme
        <h1>Nenhum filme encontrado!</h1> // Caso não encontrou
      ) : (
        // Caso encontrou ao menos um filme
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Gênero</th>
              <th>Capa</th>
            </tr>
          </thead>
          <tbody>
            {/*Cria uma linha pra cada filme encontrado, passando as informações (nome, id etc em td)*/}
            {filmesFiltrados.map((filme) => (
              <tr key={filme.id}>
                <td>{filme.id}</td>
                <td>{filme.nome}</td>
                <td>{filme.genero}</td>
                <td>
                  {/* Passa o link da imagem no parâmetro src da tag img pra exibir a imagem */}
                  <img
                    className="capas"
                    src={filme.imagem}
                    alt={filme.nome}
                  ></img>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
export default App;
