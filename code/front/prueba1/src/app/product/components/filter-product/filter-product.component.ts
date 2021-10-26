import { Component, OnInit,Input, Output, EventEmitter } from '@angular/core';
import {Product} from '../../../core/entity/product.model';

@Component({
  selector: 'app-filter-product',
  templateUrl: './filter-product.component.html',
  styleUrls: ['./filter-product.component.scss']
})
export class FilterProductComponent implements OnInit {

  @Input() products: Product[];
  @Output() productFilterClicked: EventEmitter<any> = new EventEmitter();
  buscar: string;
  
  constructor() { }

  ngOnInit(): void {
  }

  filter(newValue):any{
    this.productFilterClicked.emit(this.buscar);
  }

}
