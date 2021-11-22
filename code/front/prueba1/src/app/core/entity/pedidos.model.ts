import {Register} from './register.model';
import {Carrito} from './carrito.model';

export interface Pedidos{
    Id : number;
    Usuario : Register;
    Carrito : Carrito[];
}