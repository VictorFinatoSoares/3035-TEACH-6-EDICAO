/**
 * Card visual utilizado para representar uma liga na página inicial.
 * Ao ser selecionado, direciona o usuário para a classificação da liga.
 */
import { useNavigate } from "react-router-dom";

// Dados que cada card recebe da lista de ligas.
interface Props {
  id: string;
  imageSrc: string;
  title: string;
}
export function Card({ id, imageSrc, title }: Props) {
  // Função do React Router usada para trocar de rota programaticamente.
  const navigate = useNavigate();

  return (
    <div
      role="button"
      // Inclui o identificador da liga na URL da página de classificação.
      onClick={() => navigate(`/standings/${id}`)}
      className="flex flex-col gap-3 justify-center items-center p-3 rounded-sm bg-neutral-50 drop-md hover:drop-shadow-lg cursor-pointer"
    >
      {/* Exibe o logotipo e usa o título da liga como texto alternativo. */}
      <img src={imageSrc} alt={title} />
      <h3
        className="text-gray-800 font-medium text-center
      "
      >
        {title}
      </h3>
    </div>
  );
}
