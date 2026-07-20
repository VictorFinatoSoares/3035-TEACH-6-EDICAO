import { useState, useEffect } from "react";

export function Container() {
    const [count, setCount] = useState(0);
    const [countB, setCountB] = useState(0);
    
    const [user, setUser]= useState([]);

    function getUserData() {
        fetch('https://api.github.com/users/VictorFinatoSoares')
        .then((res) => res.json())
        .then((json) => setUser((json)))
    }


    useEffect(() => {
        console.log('Executa quando renderiza')
    })

    useEffect(() => {
        console.log('Executa quando Count altera')
    }, [count])

    useEffect(() => {
        console.log(user);
    }, [user])

    useEffect(() => {
        getUserData()
        console.log(user)
    }, [])


    return (
        <div>
            <p>Contador: {count}</p>
            <button onClick= {() => setCount((prevCount) => prevCount + 1)}>Adiciona</button>
            
            <p>ContadorB: {countB }</p>
            <button onClick= {() => setCountB((prevCountB) => prevCountB + 1)}>Adiciona</button>
        </div>
    );
}