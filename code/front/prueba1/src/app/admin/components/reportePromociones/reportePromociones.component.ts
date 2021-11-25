import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {environment} from '../../../../environments/environment';
import { ReportsService } from 'src/app/core/services/reports/report.service';
import { Promotion } from 'src/app/core/entity/promotion.model';


@Component({
  selector: 'app-reportes',
  templateUrl: './reportePromociones.component.html',
  styleUrls: ['./reportePromociones.component.scss']
})
export class ReportePromocionesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name','detail','state','type','percentage'];
  promotions: Promotion[];
  programacion: any;
  version: string;

  constructor(private reportesService: ReportsService, private router: Router,private changeDetectorRefs: ChangeDetectorRef) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    
  }

  promReport(monthly:boolean): any{
    this.reportesService.getListPromFromInventario(monthly).subscribe(report =>
      {
        console.log(report);
        this.promotions = report;
      });;
}}
