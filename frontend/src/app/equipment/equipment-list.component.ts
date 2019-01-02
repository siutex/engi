import {EquipmentService} from './equipment.service';
import {Equipment} from './equipment';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  templateUrl: './equipment-list.component.html'
})
export class EquipmentListComponent  implements OnInit {

  equiplist: Equipment[];
  errorMessage: string;

  constructor(private equipmentService: EquipmentService, private router: Router) {
    this.errorMessage = '';
  }

  ngOnInit(): void {
    this.getEquip();
  }

    getEquip() {
    this.equipmentService.getEquip()
      .subscribe(equiplist => {
          this.equiplist = equiplist;
          if (this.equiplist.length === 0) {
            this.errorMessage = 'brak sprzętu !';
          }
        },
        error =>  {
          this.router.navigateByUrl('/auth/login');
          console.error('błąd, powtórne logowanie: ', error);
        });
  }
}
