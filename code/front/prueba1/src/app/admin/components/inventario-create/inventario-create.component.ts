import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {ProductosService} from './../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';
import {MyValidator} from './../../../utils/validators';

@Component({
  selector: 'app-inventario-create',
  templateUrl: './inventario-create.component.html',
  styleUrls: ['./inventario-create.component.scss']
})
export class InventarioCreateComponent implements OnInit {

  form: FormGroup;
  product: Product;
  
  ArrProduct: Product[];

  id: string ="0";
  title: string ="";
  
  constructor(private formBuilder: FormBuilder, private productsService: ProductosService, private router: Router, private activateRoute: ActivatedRoute) {
    
  }

  get priceField(){
    return this.form.get('price');
  }
  ngOnInit(): void {
    
    this.form = this.formBuilder.group(
      {
        id: ['', [Validators.required]],
        title: ['', [Validators.required]],
        price: [0, [Validators.required]],
        image: [''],
        description: ['', [Validators.required]],
        stock: ['', [Validators.required]],
        state: ['', [Validators.required]],
        discount: ['', [Validators.required]],
      }
    );
    this.id = this.activateRoute.snapshot.paramMap.get('id');

    if(this.id != null){
      this.form.controls['id'].setValue(this.id);
      this.form.controls['id'].disable();
      this.form.controls['title'].disable();
      this.title="Editar Inventario";
      this.getProduct(this.id);
    }
    else
    {
      this.form.controls['id'].enable();
      this.title="Agregar Inventario";
    }
  }

  SaveProduct( event: Event): any{

    event.preventDefault();
    if (this.form.valid){
      const product = this.form.value;
      console.log(this.product);

      if(this.id != null ){

        product.id = this.id;
        this.productsService.updateProduct(product).subscribe( (newproduct) => {
          console.log(newproduct);
          this.router.navigate(['./admin/inventario']);
        });
      }else{
        this.productsService.createProduct(product).subscribe( (newproduct) => {
          console.log(newproduct);
          this.router.navigate(['./admin/inventario']);
        });
      }

    }
    else{
      alert('datos invalidos');
    } 
  }

  getProduct(id: string): any{
    this.productsService.getAllProduct("").subscribe(products =>
    {
      
      console.log(this.ArrProduct);
      this.ArrProduct = products;
      this.product=this.ArrProduct.find(element => element.id =id);
      console.log("dato")
      console.log(this.product);
      this.form.controls['title'].setValue(this.product.title);
      this.form.controls['price'].setValue(this.product.price);
      this.form.controls['description'].setValue(this.product.description);
      this.form.controls['discount'].setValue(this.product.discount);
      this.form.controls['stock'].setValue(this.product.stock);
      this.form.controls['state'].setValue(this.product.state);
    });
    
  }
}
