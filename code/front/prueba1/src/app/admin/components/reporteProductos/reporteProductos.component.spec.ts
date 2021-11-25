import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteProductosComponent } from './reporteProductos.component';

describe('ReportesComponent', () => {
  let component: ReporteProductosComponent;
  let fixture: ComponentFixture<ReporteProductosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReporteProductosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteProductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
