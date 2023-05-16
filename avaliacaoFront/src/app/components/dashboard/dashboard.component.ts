import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  menuItems: any[];

  constructor() {
    this.menuItems = [
      { label: 'Login', routerLink: '/login' },
      { label: 'Beneficiários', routerLink: '/beneficiarios' },
      { label: 'Planos', routerLink: '/planos' }
    ];
  }
}
