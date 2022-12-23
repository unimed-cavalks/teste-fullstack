export interface Page {
    content: Array<Client>;
    totalPages: number;
    totalElements: number;
    last: boolean;
    size: number;
    number: number;
    sort?: any;
    numberOfElements: number;
    first: boolean;
};

export interface Client {
    id: number;
    name: string;
    cpf: string;
    dataRegistration: number;
};