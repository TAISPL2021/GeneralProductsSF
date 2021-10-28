import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventarioListComponent } from './inventario-list.component';

describe('InventarioListComponent', () => {
  let component: InventarioListComponent;
  let fixture: ComponentFixture<InventarioListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventarioListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventarioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
