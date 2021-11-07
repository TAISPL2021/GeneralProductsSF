import { TestBed } from '@angular/core/testing';

import { UpdateService } from './update.service';

describe('RegisterService', () => {
  let service: UpdateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
