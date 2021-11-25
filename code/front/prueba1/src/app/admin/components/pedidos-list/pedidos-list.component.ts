import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {PedidosService} from './../../../core/services/pedidos/pedidos.service';
import {Pedidos} from '../../../core/entity/pedidos.model';
import {Register} from '../../../core/entity/register.model';
import {Carrito} from '../../../core/entity/carrito.model';
import {environment} from '../../../../environments/environment';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-pedidos-list',
  templateUrl: './pedidos-list.component.html',
  styleUrls: ['./pedidos-list.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class PedidosListComponent implements OnInit {

  expandedElement: Pedidos | null;
  pedidos: Pedidos[];
  pedidosMock: Pedidos[] =[
    {
      id : 1,
      estadoPedido : "abierto",
      nombreCliente : "pepito",
      correoCliente : "pepito@hotmail.com",
      telefonoCliente : "3666666",
      direccionCliente : "direccion",     
      productos : [
        {
          productoCode: 10002,
          productoNombre: "Ejemplo",
          productoDetalle: "Ejemplo",
          productoPrecio: 15000.0,
          productoCantidad: 1,
          total: 15000.0
        },
        {
          productoCode: 10003,
          productoNombre: "Ejemplo",
          productoDetalle: "Ejemplo",
          productoPrecio: 15000.0,
          productoCantidad: 1,
          total: 15000.0
        }
      ]
    } 
  ]
  displayedColumns: string[] = ['id', 'nombreCliente','direccionCliente','correoCliente', 'telefonoCliente','estadoPedido','Enviado','Factura'];
  displayedCart: string[] = ['productoCode', 'productoNombre','productoCantidad'];
  programacion: any;
  version: string;

  constructor(private pedidosService: PedidosService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    this.fetchProducts();
    //this.pedidos = this.pedidosMock; 
  }
  

  fetchProducts(): any{
    this.pedidosService.getAllPedidos("").subscribe(pedidos =>
    {
      console.log("ok")
      console.log(this.pedidos);
      this.pedidos = pedidos;
      this.changeDetectorRefs.detectChanges();
    });
  }

  updatePedido(idpedido: number): any{
    
    this.pedidosService.updateProduct(idpedido).subscribe(pedidos =>
      {
        console.log(pedidos);
        alert("Pedido eliminado correctamente");    
        this.changeDetectorRefs.detectChanges();
      });
    
  }

}
