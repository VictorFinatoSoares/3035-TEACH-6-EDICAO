import React from 'react';
import './App.css';
import { useState } from 'react';

function App() {
  const [count, setCount] = useState(0); // Define uma constante com valor inicial 0

  function add() { // Função que incrementa 1 no contador
    setCount((prevCount) => prevCount + 1);
  }
  
// Renderiza
  return ( 
    <div className='count-container'>
      <h1>Contador: {count}</h1>
      <button onClick={add}>Adicionar</button>
    </div>
  );
}

export default App;
