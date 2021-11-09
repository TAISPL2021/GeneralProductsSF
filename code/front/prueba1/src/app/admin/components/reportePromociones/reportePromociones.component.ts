import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProductosService} from '../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';
import {environment} from '../../../../environments/environment';


@Component({
  selector: 'app-reportes',
  templateUrl: './reportePromociones.component.html',
  styleUrls: ['./reportePromociones.component.scss']
})
export class ReportePromocionesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name','state', 'finalDate','type'];
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