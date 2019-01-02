import {Component, OnInit} from '@angular/core';


@Component({
    template: `<div style="float:left">
    <ul class="list-group">
      <li class="list-group-item"><a routerLink="/equipment" routerLinkActive="active">Urządzenia</a></li>
      <li class="list-group-item"><a routerLink="/equipment/new" routerLinkActive="active">Dodaj nowe</a></li>
    </ul>
  </div>
  <div style="margin-left: 160px">
    <router-outlet></router-outlet>
  </div>
  `,
})
export class EquipmentComponent implements OnInit {
    ngOnInit(): void {
    }
}
