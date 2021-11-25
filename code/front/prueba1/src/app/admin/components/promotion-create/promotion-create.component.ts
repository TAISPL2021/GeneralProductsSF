import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {PromotionService} from './../../../core/services/promotion/promotion.service';
import {Promotion} from '../../../core/entity/promotion.model';
import {MyValidator} from './../../../utils/validators';

@Component({
  selector: 'app-promotion-create',
  templateUrl: './promotion-create.component.html',
  styleUrls: ['./promotion-create.component.scss']
})
export class PromotionCreateComponent implements OnInit {

  form: FormGroup;
  promotion: Promotion;
  
  ArrPromotion: Promotion[];

  id: number = 0;
  nombre: string ="";
  
  constructor(private formBuilder: FormBuilder, private promotionService: PromotionService, private router: Router, private activateRoute: ActivatedRoute) {
    
  }

  get porcentajeField(){
    return this.form.get('porcentaje');
  }
  ngOnInit(): void {
    
    this.form = this.formBuilder.group(
      {
        id : ['', [Validators.required]],
        nombre : ['', [Validators.required]],
        detalle : [''],
        tipo :['', [Validators.required]],
        estado : ['', [Validators.required]],
        porcentaje : ['', [Validators.required]],
      }
    );
    this.id = Number(this.activateRoute.snapshot.paramMap.get('id'));
    console.log(this.id);
    if(this.id != 0){
      this.form.controls['id'].setValue(this.id);
      this.form.controls['id'].disable();
      this.form.controls['nombre'].disable();
      this.form.controls['tipo'].disable();
      this.nombre="Editar Promocion";
      this.getPromotion(this.id);
    }
    else
    {
      this.form.controls['id'].enable();
      this.nombre="Agregar Promocion";
    }
  }

  SavePromotion( event: Event): any{

    event.preventDefault();
    if (this.form.valid){
      const promotion = this.form.value;
      console.log(this.promotion);

      //if(this.id != null ){
      //if(this.nombre="Editar Promocion"){  
      if(this.id != 0 ){
        console.log('put');
        promotion.id = this.id;
        this.promotionService.updatePromotion(promotion).subscribe( (newpromotion) => {
          console.log(newpromotion);
          this.router.navigate(['./admin/promotion']);
        });
      }else{
          console.log('post');
          this.promotionService.createPromotion(promotion).subscribe( (newpromotion) => {
          console.log(newpromotion);
          this.router.navigate(['./admin/promotion']);
        });
      }

    }
    else{
      alert('datos invalidos');
    } 
  }

  getPromotion(id: number): any{
    
    this.promotionService.getAllPromotion("").subscribe(promotions =>
    {

      this.ArrPromotion = promotions;
      this.promotion=this.ArrPromotion.find(element => element.id === id);
      console.log("dato")
      this.form.controls['nombre'].setValue(this.promotion.nombre);
      this.form.controls['detalle'].setValue(this.promotion.detalle);
      this.form.controls['tipo'].setValue(this.promotion.tipo);
      this.form.controls['estado'].setValue(String(this.promotion.estado));
      console.log(this.promotion.estado);
      this.form.controls['porcentaje'].setValue(this.promotion.porcentaje);
      
    });


    
  }
}
