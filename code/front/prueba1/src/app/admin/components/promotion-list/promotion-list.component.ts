import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {PromotionService} from '../../../core/services/promotion/promotion.service';
import {Promotion} from '../../../core/entity/promotion.model';
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-promotion-list',
  templateUrl: './promotion-list.component.html',
  styleUrls: ['./promotion-list.component.scss']
})
export class PromotionListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nombre', 'detalle', 'tipo','estado', 'porcentaje','actions'];
  promotions: Promotion[];
  promotionsMock: Promotion[] =[
    {
      id:1,
			nombre:"ejemplo",
			detalle:"ejemplo",
			tipo:"ejemplo",
			estado:true,
			porcentaje:70
    } 
  ];
  programacion: any;
  version: string;

  constructor(private promotionService: PromotionService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    //this.promotions = this.promotionsMock; 
    //console.log(this.promotions);
    this.fetchPromotions();
  }

  fetchPromotions(): any{
    this.promotionService.getAllPromotion("").subscribe(promotions =>
    {
      console.log("ok")
      console.log(this.promotions);
      this.promotions = promotions;
      this.changeDetectorRefs.detectChanges();
    });
  }


}
