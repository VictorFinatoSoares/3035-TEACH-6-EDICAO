import { useState, useEffect } from "react";
import { Card } from "./Card";

// Propriedades dos cards (tipadas)
interface ICard {
  name: string;
  url: string;
  img: string;
}

export function CardsList() {
  const [cards, setCards] = useState<ICard[]>([]);

  // Função que faz uma chamada para a pokeapi
  async function getPokemons() {
    // faz uma requisição pra api com todos os pokemons
    const res = await fetch("https://pokeapi.co/api/v2/pokemon"); // o limite pode ser aumentado com ?limit=limite
    const json = await res.json();

    // cria um array de promises
    const cardsWithImg = await Promise.all(
      // realiza varios fetch paralelos
      json.results.map(async (pokemon: { name: string; url: string }) => {
        const detailRes = await fetch(pokemon.url); // faz uma requisição pra a url do pokemon especifico
        const detailJson = await detailRes.json();

        // retorna o objeto já no formato de ICard, que vai definir o array final
        return {
          name: pokemon.name, // nome e url do pokemon (vem do primeiro fetch)
          url: pokemon.url,
          img: detailJson.sprites.front_default, // a url da imagem do pokemon (vem do segundo fetch)
        };
      }),
    );

    setCards(cardsWithImg);
  }

  // faz um pedido para api somente quando a página é renderizada pela primeira vez
  useEffect(() => {
    getPokemons();
  }, []);

  return (
    <ul className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 m-6 gap-6">
      {/*cria a lista responsiva, com 2 colunas em telas menores, e aumentando até 4 em telas maiores*/}
      {cards.map(({ name, url, img }: ICard) => (
        <li key={url}>
          <Card name={name} img={img} />
        </li>
      ))}
    </ul>
  );
}
