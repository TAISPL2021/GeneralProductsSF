import {Register} from './register.model';

export interface PedidosProductos{
    productoCode : number;
    productoNombre : string;
    productoDetalle : string;
    productoPrecio : number;
    productoCantidad : number;
    total : number;
}


export interface Pedidos{
    id : number;
    estadoPedido : string;
    nombreCliente : string;
    correoCliente : string;
    telefonoCliente : string;
    direccionCliente : string;
    productos : PedidosProductos[];
}