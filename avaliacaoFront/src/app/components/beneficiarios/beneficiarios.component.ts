import { Component, OnInit } from '@angular/core';
import { BeneficiarioService } from 'src/app/services/beneficiario.service'
import { Beneficiario } from 'src/app/models/beneficiario.model';

@Component({
  selector: 'app-beneficiarios',
  templateUrl: './beneficiarios.component.html',
  styleUrls: ['./beneficiarios.component.css']
})
export class BeneficiariosComponent implements OnInit {
  beneficiarios: Beneficiario[] = [];
  beneficiarioDialog: Beneficiario;
  displayDialog: boolean;

  constructor(private beneficiarioService: BeneficiarioService) {
    this.beneficiarioDialog = new Beneficiario();
    this.displayDialog = false;
  }

  ngOnInit() {
    this.loadBeneficiarios();
  }

  loadBeneficiarios() {
    this.beneficiarioService.getBeneficiarios().subscribe(data => {
      this.beneficiarios = data;
    });
  }

  showDialogToAdd() {
    this.beneficiarioDialog = new Beneficiario();
    this.displayDialog = true;
  }

  showDialogToUpdate(beneficiario: Beneficiario) {
    this.beneficiarioDialog = { ...beneficiario };
    this.displayDialog = true;
  }

  saveBeneficiario() {
    if (this.beneficiarioDialog.Id) {
      // Atualizar beneficiário existente
      this.beneficiarioService.updateBeneficiario(this.beneficiarioDialog).subscribe(() => {
        this.loadBeneficiarios();
        this.cancel();
      });
    } else {
      // Adicionar novo beneficiário
      this.beneficiarioService.addBeneficiario(this.beneficiarioDialog).subscribe(() => {
        this.loadBeneficiarios();
        this.cancel();
      });
    }
  }

  deleteBeneficiario(beneficiario: Beneficiario) {
    this.beneficiarioService.deleteBeneficiario(beneficiario.Id).subscribe(() => {
      this.loadBeneficiarios();
    });
  }

  cancel() {
    this.beneficiarioDialog = new Beneficiario();
    this.displayDialog = false;
  }
}

