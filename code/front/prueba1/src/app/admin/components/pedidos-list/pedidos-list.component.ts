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
      Id : 1,
      Usuario : {
        name:"pepito",
        address:"direccion",
        email: "pepito@hotmail.com",
        lastName: "perez",
        gender: "Male",
        phone: "3666666",
        secondLastName: "perez",
        secondName: "alberto",
        role: "USER",
        userName: "pepito",
        password:""
      },
      Carrito : [
        {
          id : 1,
          producto_id : "1",
          producto_nombre : "sandwiches",
          producto_detalle : "detaller",
          producto_cantidad : 1,
        },
        {
          id : 2,
          producto_id : "2",
          producto_nombre : "sandwiches de pollo",
          producto_detalle : "detalle 2",
          producto_cantidad : 1,
        }
      ]
    } 
  ]
  displayedColumns: string[] = ['Id', 'Usuario.name','Usuario.lastName','Usuario.email', 'Usuario.phone','Enviado','Factura'];
  displayedCart: string[] = ['producto_id', 'producto_nombre','producto_cantidad'];
  programacion: any;
  version: string;

  constructor(private pedidosService: PedidosService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    this.pedidos = this.pedidosMock; 
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

  deleteProduct(variable : any): any{
    console.log(this.expandedElement);
    console.log(variable);
  }

}
