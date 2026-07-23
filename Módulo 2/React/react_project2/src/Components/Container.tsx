import { useState, useEffect, useRef } from "react";

export function Container() {
    const [count, setCount] = useState(0);
    const [number, setNumber] = useState(0);

    const numberRef = useRef(0);

    useEffect(() => {
        
        numberRef.current = Math.random();
        // setNumber((prevNumber) => prevNumber + 10);   
    })


    return (
        <div>
            <p>Contador: {count}</p>
            <button onClick= {() => setCount((prevCount) => prevCount + 1)}>Adiciona</button>
      
            <p>Contador Number: {number}</p>
       
            <p>Contador NumberRef: {numberRef.current}</p>
       </div>
    );
}