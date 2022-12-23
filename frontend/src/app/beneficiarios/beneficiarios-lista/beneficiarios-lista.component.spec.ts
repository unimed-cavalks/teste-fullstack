import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiariosListaComponent } from './beneficiarios-lista.component';

describe('BeneficiariosListaComponent', () => {
  let component: BeneficiariosListaComponent;
  let fixture: ComponentFixture<BeneficiariosListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeneficiariosListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiariosListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
