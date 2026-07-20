"use strict";
// type CalculateTaxParams = {
//     price: number;
//     minTaxValue: number;
//     maxTaxValue: number;
// };
Object.defineProperty(exports, "__esModule", { value: true });
const userAdmin = {
    name: 'admin1234',
    email: 'admin1234@gmail.com',
    address: {
        street: 'Avenida Luiz',
        zipCode: 'BLABLA',
        number: 6452,
        reference: 'Perto da Artta'
    },
    occupation: 'ADMIN'
};
console.log(userAdmin.address?.number);
//# sourceMappingURL=index.js.map