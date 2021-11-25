import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteOrdenesComponent } from './reporteOrdenes.component';

describe('ReportesComponent', () => {
  let component: ReporteOrdenesComponent;
  let fixture: ComponentFixture<ReporteOrdenesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReporteOrdenesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteOrdenesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
