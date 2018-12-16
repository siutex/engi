
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {EquipmentRoutingModule} from './equipment-routing.module';
import {EquipmentComponent} from './equipment.component';

@NgModule({
    imports: [
        CommonModule, FormsModule, HttpModule, EquipmentRoutingModule
    ],
    declarations: [
        EquipmentComponent
    ],
    providers: [ ]
})
export class EquipmentModule {}
