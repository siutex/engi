
import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Equipment, EquipStatus} from './equipment';
import {EquipmentService} from './equipment.service';

@Component({
    templateUrl: './new-equipment.component.html'
})
export class NewEquipmentComponent {
    equip: Equipment;
    equipStatus: EquipStatus;
    alertStyle: string;

    constructor(private equipService: EquipmentService, private router: Router) {
        this.equip = new Equipment();
        this.equipStatus = new EquipStatus();
        this.alertStyle = '';
    }

    onSubmit() {
        this.equipService.createEquip(this.equip)
            .subscribe((equip: Equipment) => {
                    this.equipStatus.code = 'SUCCESS';
                    this.equipStatus.message = 'Urządzenie dodane';
                    this.alertStyle = 'alert alert-success';
                },
                error =>  {
                    if (error === 'invalid_token') {
                        this.router.navigateByUrl('/auth/login');
                        this.equipStatus.code = 'FAILURE';
                        this.equipStatus.message = 'sprzęt niedodany błąd sesji';
                        this.alertStyle = 'alert alert-danger';
                    }
                    this.equipStatus.code = 'FAILURE';
                    this.equipStatus.message = 'błąd';
                    this.alertStyle = 'alert alert-danger';
                });
    }
}
