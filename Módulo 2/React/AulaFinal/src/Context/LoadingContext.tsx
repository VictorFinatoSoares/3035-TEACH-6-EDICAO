/**
 * Contexto global de carregamento.
 * Permite que diferentes páginas compartilhem o estado que controla o Spinner.
 */
import React, { createContext, useContext, useState } from "react";

// Contrato dos valores disponibilizados pelo contexto.
type LoadingContextType = {
  isLoading: boolean;
  setLoadingState(state: boolean): void;
};

// O provider envolve e renderiza os componentes filhos da aplicação.
interface LoadingContextProviderType {
  children: React.ReactNode;
}

// Cria o objeto de contexto consumido pelos componentes descendentes.
export const LoadingContext = createContext<LoadingContextType>(
  {} as LoadingContextType,
);

export const LoadingContextProvider = ({
  children,
}: LoadingContextProviderType) => {
  // Guarda a informação de que uma operação assíncrona está em andamento.
  const [isLoading, setIsLoading] = useState(false);
  // Expõe uma função com nome relacionado ao domínio para atualizar o estado.
  const setLoadingState = (state: boolean) => {
    setIsLoading(state);
  };

  return (
    // Compartilha o estado atual e sua função de atualização.
    <LoadingContext.Provider value={{ isLoading, setLoadingState }}>
      {children}
    </LoadingContext.Provider>
  );
};

// Hook que simplifica o acesso ao contexto de carregamento em outros componentes.
export function useLoading(): LoadingContextType {
  const context = useContext(LoadingContext);
  return context;
}
