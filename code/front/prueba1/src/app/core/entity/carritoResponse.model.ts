export interface CarritoProductRensponse{
    productoCantidadComprar : number;
    productoNombre : string;
    productoDetalle : string;
}

export interface CarritoRensponse{
    carrito_id : number;
    fecha : string;
    usuario : string;
    productos: CarritoProductRensponse[]
}

