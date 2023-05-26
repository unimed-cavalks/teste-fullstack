import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiariosFormComponent } from './beneficiarios-form.component';

describe('BeneficiariosFormComponent', () => {
  let component: BeneficiariosFormComponent;
  let fixture: ComponentFixture<BeneficiariosFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BeneficiariosFormComponent]
    });
    fixture = TestBed.createComponent(BeneficiariosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
