
import {HospitalComponent} from './hospital.component';
import {HospitalListComponent} from './hospital-list.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {HospitalRoutingModule} from './hospital-routing.module';
import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {HospitalService} from './hospital.service';

@NgModule({
    imports: [
        CommonModule, FormsModule, HttpModule, HospitalRoutingModule
    ],
    declarations: [
        HospitalComponent, HospitalListComponent
    ],
    providers: [ HospitalService ]
})
export class HospitalModule {}
