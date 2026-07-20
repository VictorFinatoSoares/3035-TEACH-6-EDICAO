import React, {useState} from 'react';
import './App.css';

function App() {
  const [name, setName] = useState('Victor');
  const [count, setCount] = useState(1);


  function increment() {  
    setCount((prevCount) => prevCount + 1);
    setCount((prevCount) => prevCount + 1);
  }


  return (
    <div>
      <h1>Olá, meu nome é {name}</h1>
      <input value = {name} onChange = {e => setName(e.target.value)}/>

      <h1>Contador: {count}</h1>
      <button onClick = {increment}>Adicionar</button>
    
    </div>
  );
}


export default App;
