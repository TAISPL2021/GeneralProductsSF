import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProductosService} from '../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';
import {environment} from '../../../../environments/environment';


@Component({
  selector: 'app-reportes',
  templateUrl: './reporteProductos.component.html',
  styleUrls: ['./reporteProductos.component.scss']
})
export class ReporteProductosComponent implements OnInit {

  displayedColumns: string[] = ['id', 'title', 'price', 'description','state', 'stock','discount'];
  products: Product[];
  programacion: any;
  version: string;

  constructor(private productosService: ProductosService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    
  }
}