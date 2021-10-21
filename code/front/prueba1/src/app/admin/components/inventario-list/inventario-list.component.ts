import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {ProductosService} from './../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';

@Component({
  selector: 'app-inventario-list',
  templateUrl: './inventario-list.component.html',
  styleUrls: ['./inventario-list.component.scss']
})
export class InventarioListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'title', 'price', 'description', 'stock','discount','actions'];
  products: Product[];

  constructor(private productosService: ProductosService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    
  }

  ngOnInit(): void {
    this.fetchProducts();
  }

  fetchProducts(): any{
    this.productosService.getAllProduct("").subscribe(products =>
    {
      console.log("ok")
      console.log(this.products);
      this.products = products;
      this.changeDetectorRefs.detectChanges();
    });
  }

  deleteProduct(id: number): any{
    console.log(id);
    this.productosService.deleteProduct(id).subscribe(product => {
      console.log(product);
    });
    alert('producto eliminado');
    this.fetchProducts();
  }

}
