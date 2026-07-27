// Propriedades (tipadas) que os cards (que serão renderizados) vão ter
interface ICard {
  name: string;
  img: string;
}

// recebe as propriedades para exibir depois
export function Card({ name, img }: ICard) {
  return (
    <div className="bg-gray-800 hover:bg-gray-600 hover:scale-105 p-4 rounded-2xl flex flex-col items-center duration-1000">
      <h1 className="text-2xl text-blue-300 font-semibold capitalize">
        {name}
      </h1>
      {/*exibe a imagem do pokemon com a url obtida da api*/}
      <img
        src={img}
        alt={name}
        className="size-40 hover:scale-110 duration-300"
      />
    </div>
  );
}
