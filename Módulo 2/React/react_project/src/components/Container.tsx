// Container: É a div principal com todo o conteúdo do site, cada componente estará dentro desta div.

import {Title} from './Title'; // Para exibir o título
import {Data} from './Data'; // Para buscar os dados do usuário 
import {User} from './User'; // Para mostrar os dados do usuário

export function Container() {
    return ( 
        <div>            
            <Title/> 
            <User
                name = {Data.name} // Passa os dados de Data.tsx para os parâmetros da função que retorna os dados no script User.tsx e renderiza junto ao título acima
                age = {Data.age}
                email = {Data.email}
                address = {Data.address}
            />
        </div>
    );
}