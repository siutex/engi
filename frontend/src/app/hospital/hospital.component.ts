import {Component, OnInit} from '@angular/core';

@Component({
    template: `<div style="float:left">
        <ul class="list-group">
            <li class="list-group-item"><a routerLink="/hospital" routerLinkActive="active">Gabinety</a></li>
        </ul>
    </div>
    <div style="margin-left: 160px">
        <router-outlet></router-outlet>
    </div>
    `,
})
export class HospitalComponent implements OnInit{
    ngOnInit(): void {
    }

}
