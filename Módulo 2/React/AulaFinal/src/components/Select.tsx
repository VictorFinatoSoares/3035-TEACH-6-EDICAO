/**
 * Campo de seleção reutilizável.
 * Neste projeto, recebe as temporadas disponíveis para uma liga.
 */
// options preenche as opções; onChange comunica a seleção ao componente pai.
interface Props {
  options: string[];
  onChange: (event: React.ChangeEvent<HTMLSelectElement>) => void;
}

export function Select({ options, onChange }: Props) {
  return (
    <select name="season" onChange={onChange}>
      {/* Converte cada texto recebido em uma opção selecionável. */}
      {options.map((item) => (
        <option value={item} key={item}>
          {item}
        </option>
      ))}
    </select>
  );
}
