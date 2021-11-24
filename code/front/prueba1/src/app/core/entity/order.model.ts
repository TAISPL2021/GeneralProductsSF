import { Carrito } from "./carrito.model";

export interface Order{
    numeroTarjeta: string,
    NombreTarjeta: string,
    FechaExpiracion: string,
    NumeroDeVerificacion: string,
    cuotas: number,
    carrito: Carrito
}

