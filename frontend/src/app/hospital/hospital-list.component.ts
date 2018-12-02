import {HospitalService} from './hospital.service';
import {Hospital} from './hospital';
import {Component, OnInit} from '@angular/core';



@Component({
    templateUrl: './hospital-list.component.html'
})
export class HospitalListComponent implements OnInit {

    hospitals: Hospital[];
    errorMessage: string;

    constructor(private hospitalService: HospitalService) {
        this.errorMessage = '';
    }

    ngOnInit() {
        this.getHospitals();
    }

    getHospitals() {
        this.hospitalService.getHospital()
            .subscribe(hospitals => {
                    this.hospitals = hospitals;
                    if (this.hospitals.length === 0) {
                        this.errorMessage = 'Pusto';
                    }
                },
                error => {
                    console.error('Brak gabinetów: ', error);
                });
    }
}