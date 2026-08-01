/**
 * Ponto de entrada da aplicação React.
 * Carrega os estilos globais e monta o componente App no elemento HTML de id root.
 */
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

// Cria a raiz do React e inicia a renderização da árvore de componentes.
createRoot(document.getElementById('root')!).render(
  // Ativa verificações adicionais do React durante o desenvolvimento.
  <StrictMode>
    <App />
  </StrictMode>,
)
