import { PlanoBusca } from './plano/PlanoBusca';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { PlanoService } from './plano.service';

fdescribe('PlanoService', () => {
  let service: PlanoService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlanoService],
      imports: [HttpClientTestingModule]
    });
    service = TestBed.get(PlanoService)
  });

  it('should return a list of clients', () => {
      const dummyResponse = {
        ServicoPrestadoBusca: [{
          id: 1,
          description: 'Camila',
          value: '100,00',
          date: '03/03/2021'
        }, {
          id: 2,
          description: 'Fulano',
          value: '200,00',
          date: '030332021'
        }]
      };
     })
});
