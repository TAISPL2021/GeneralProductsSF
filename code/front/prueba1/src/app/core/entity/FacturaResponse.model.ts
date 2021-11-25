export interface FacturaProductRensponse{
    productoCode : number;
    productoNombre : string;
    productoDetalle : string;
    productoPrecio : number;
    productoCantidad : number;
    total : number;
}

export interface FacturaResponse{
    id : number;
    facturaCodigo : number;
    facturaFecha : string;
    facturaNombreCliente : string;
    facturaCorreoCliente : string;
    facturaDireccionCliente : string;
    facturaTotal : number;
    productos: FacturaProductRensponse[]
}
