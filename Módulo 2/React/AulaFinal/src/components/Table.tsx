/**
 * Tabela responsável por apresentar a classificação de uma liga.
 * Cada linha combina os dados de identificação do time com suas estatísticas.
 */
// Recorte dos dados de um time utilizados visualmente pela tabela.
interface Team {
  name: string;
  displayName: string;
  logos: {
    href: string;
  }[];
}

// Valor de uma estatística já formatado pela API para exibição.
interface Stat {
  displayValue: string;
}

// Estrutura de cada participante presente no array de classificação.
export interface Standings {
  team: Team;
  stats: Stat[];
}

// A tabela recebe a classificação completa por meio de props.
interface Props {
  standings: Standings[];
}

export function Table({ standings }: Props) {
  // Percorre os times e cria uma linha para cada posição da classificação.
  const renderTableRows = () => {
    return standings.map((item, index) => (
      <tr
        key={item.team.name}
        className="border-b border-neutral-300 text-left font-light"
      >
        {/* A posição visual é calculada a partir da ordem recebida da API. */}
        <td className="px-6 py-4">{index + 1}</td>
        <td className="flex items-center gap-2 px-6 py-4">
          {item.team.logos && (
            <img
              src={item.team.logos[0].href}
              alt={item.team.name}
              className="w-7 h-7"
            />
          )}
          {item?.team.displayName}
        </td>
        {/* Exibe as estatísticas somente quando esse conjunto existe no item. */}
        {item.stats && (
          <>
            <td className="px-6 py-4 text-center">
              {item.stats[3].displayValue} {/*Pontuação*/}
            </td>
            <td className="px-6 py-4 text-center">
              {item.stats[0].displayValue} {/*Games*/}
            </td>
            <td className="px-6 py-4 text-center">
              {item.stats[7].displayValue} {/*Vitórias*/}
            </td>
            <td className="px-6 py-4 text-center">
              {item.stats[6].displayValue} {/*Empates*/}
            </td>
            <td className="px-6 py-4 text-center">
              {item.stats[1].displayValue} {/*Derrotas*/}
            </td>
            <td className="px-6 py-4 text-center">
              {item.stats[2].displayValue} {/*Saldo de gols*/}
            </td>
            <td className="px-6 py-4 text-center whitespace-nowrap">
              {item.stats[13].displayValue} {/*Desempenho no campeonato*/}
            </td>
          </>
        )}
      </tr>
    ));
  };

  return (
    <div className="flex flex-col">
      {/* Permite rolagem horizontal da tabela em telas menores. */}
      <div className="overflow-x-auto">
        <table className="min-w-full table-fixed text-left font-light">
          <thead className="border-b border-neutral-400 font-medium text-left">
            <tr>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-left"
              >
                Pos
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-left"
              >
                Team
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                Points
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                Games
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                W
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                D
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                L
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                GD
              </th>
              <th
                scope="col"
                className="max-sm:sticky px-6 whitespace-nowrap py-4 w-3 text-center"
              >
                Record
              </th>
            </tr>
          </thead>
          {/* Insere no corpo da tabela todas as linhas construídas acima. */}
          <tbody>{renderTableRows()}</tbody>
        </table>
      </div>
    </div>
  );
}
