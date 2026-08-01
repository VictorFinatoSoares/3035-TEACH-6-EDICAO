/**
 * Indicador visual de carregamento utilizado durante requisições à API.
 * A animação e o formato circular são definidos por classes do Tailwind CSS.
 */
export function Spinner() {
  return (
    <div
      className="inline-block h-10 w-10 animate-spin
rounded-full border-4 border-solid border-current
border-r-transparent align-[-0.125em]
motion-reduce:animate-[spin_1.5s_linear_infinite]"
      role="status"
    >
      {/* Texto mantido acessível para leitores de tela, mas oculto visualmente. */}
      <span
        className="absolute! -m-px! h-px! w-px!
overflow-hidden! whitespace-nowrap! border-0! p-0!
[clip:rect(0,0,0,0)]!"
      >
        Loading...
      </span>
    </div>
  );
}
