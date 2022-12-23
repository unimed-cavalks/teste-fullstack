import { TestBed } from '@angular/core/testing';

import { BeneficiariosService } from './beneficiarios.service';

describe('BeneficiariosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BeneficiariosService = TestBed.get(BeneficiariosService);
    expect(service).toBeTruthy();
  });
});
