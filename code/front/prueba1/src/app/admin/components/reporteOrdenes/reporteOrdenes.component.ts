import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {environment} from '../../../../environments/environment';
import { ReportsService } from 'src/app/core/services/reports/report.service';
import { Pedidos } from 'src/app/core/entity/pedidos.model';


@Component({
  selector: 'app-reportes',
  templateUrl: './reporteOrdenes.component.html',
  styleUrls: ['./reporteOrdenes.component.scss']
})
export class ReporteOrdenesComponent implements OnInit {

  displayedColumns: string[] = ['id','clientName','clientEmail','state','productId','productName','quantity','subtotal'];
  expandedElement: Pedidos | null;
  pedidos: Pedidos[];
  programacion: any;
  version: string;

  constructor(private reportesService: ReportsService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    
  }

  orderReport(monthly:boolean): any{
    this.reportesService.getListOrders(monthly).subscribe(report =>
      {
        console.log(report);
        this.pedidos = report;
      });


}}