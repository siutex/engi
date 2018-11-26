import { Component } from '@angular/core';

@Component({
  template:  `
    <div style="float:left">
      <ul class="list-group">
        <li class="list-group-item">Moje wizyty</li>
      </ul>
    </div>
    <div style="margin-left: 160px">
      <router-outlet></router-outlet>
    </div>
  `
})
export class UserComponent { }
