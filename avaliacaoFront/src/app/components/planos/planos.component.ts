import { Component, OnInit } from '@angular/core';
import { PlanoService } from 'src/app/services/plano.service';
import { Plano } from 'src/app/models/plano.model';

@Component({
  selector: 'app-planos',
  templateUrl: './planos.component.html',
  styleUrls: ['./planos.component.css']
})


export class PlanosComponent implements OnInit {
  planos: Plano[] = [];
  planoDialog: Plano;
  displayDialog: boolean;

  constructor(private planoService: PlanoService) {
    this.planoDialog = new Plano();
    this.displayDialog = false;
  }

  ngOnInit() {
    this.loadPlanos();
  }

  loadPlanos() {
    this.planoService.getPlanos().subscribe(data => {
      this.planos = data;
    });
  }

  showDialogToAdd() {
    this.planoDialog = new Plano();
    this.displayDialog = true;
  }

  showDialogToUpdate(plano: Plano) {
    this.planoDialog = { ...plano };
    this.displayDialog = true;
  }

  savePlano() {
    if (this.planoDialog.Id) {
      // Atualizar beneficiário existente
      this.planoService.updatePlano(this.planoDialog).subscribe(() => {
        this.loadPlanos();
        this.cancel();
      });
    } else {
      // Adicionar novo beneficiário
      this.planoService.addPlano(this.planoDialog).subscribe(() => {
        this.loadPlanos();
        this.cancel();
      });
    }
  }

  deletePlano(plano: Plano) {
    this.planoService.deletePlano(plano.Id).subscribe(() => {
      this.loadPlanos();
    });
  }

  cancel() {
    this.planoDialog = new Plano();
    this.displayDialog = false;
  }
}


