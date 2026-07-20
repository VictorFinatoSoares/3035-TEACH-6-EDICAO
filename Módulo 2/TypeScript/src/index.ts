// type CalculateTaxParams = {
//     price: number;
//     minTaxValue: number;
//     maxTaxValue: number;
// };

// function calculateTax({price, minTaxValue, maxTaxValue}: CalculateTaxParams): number {
//     if (price <= 1) {
//         return price * minTaxValue;
//     } else {
//         return price * maxTaxValue;
//     }
// }

// console.log(calculateTax({ price: 1, minTaxValue: 1.2, maxTaxValue: 1.4 }));

type Address = {
    street: string;
    zipCode: string;
    number: number;
    reference: string;
}

type User = {
    name: string;
    email: string;
    address?: Address; // ? Faz com que o dado não seja obrigátorio na hora de criar uma instância com esses tipos, entretanto ainda são declaraveis
};

interface Admin extends User {
    occupation: string;
}

const userAdmin: Admin = {
    name: 'admin1234',
    email: 'admin1234@gmail.com',
    address: {
        street: 'Avenida Luiz',
        zipCode: 'BLABLA',
        number: 6452,
        reference: 'Perto da Artta'
    },
    occupation: 'ADMIN'
}
