// Script que retorna os dados do usuário, definindo seus respectivos tipos, e definindo as mensagens que serão exibidas quando receber os dados de
// Data.tsx e renderizar em Container.tsx

type Address = {
    country: string;
    state: string;
    city: string;
    street: string;
    number: number;
}

type Props = {
    name: string;
    age: number;
    email: string;
    address: Address;
};

export function User({name, age, email, address}: Props) {
    return (
        <>
            <h2>Informações do Usuário:</h2>  
            <p>Nome: {name}</p>
            <p>Idade: {age}</p>
            <p>E-mail: {email}</p>
            <p>País: {address.country}</p>
            <p>Estado: {address.state}</p>
            <p>Cidade: {address.city}</p>
            <p>Rua: {address.street}</p>
            <p>Número: {address.number}</p>
        </>
    );
}
