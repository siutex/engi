import {Component, OnInit} from '@angular/core';

@Component({
  template: `<div style="float:left">
    <ul class="list-group">
      <li class="list-group-item"><a routerLink="/rx" routerLinkActive="active">Wizyty</a></li>
      <li class="list-group-item"><a routerLink="/rx/new" routerLinkActive="active">Nowa Wizyta</a></li>
    </ul>
  </div>
  <div style="margin-left: 160px">
    <router-outlet></router-outlet>
  </div>
  `,
})
export class RxComponent implements OnInit {
  ngOnInit(): void {
  }
}
