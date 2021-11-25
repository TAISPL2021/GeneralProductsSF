import { TestBed } from '@angular/core/testing';

import { PagosConsultaService } from './pagosConsulta.service';

describe('PagosConsultaService', () => {
  let service: PagosConsultaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PagosConsultaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
