
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';

import {EquipmentRoutingModule} from './equipment-routing.module';
import {EquipmentComponent} from './equipment.component';
import {NewEquipmentComponent} from './new-equipment.component';
import {EquipmentListComponent} from './equipment-list.component';
import {EquipmentService} from './equipment.service';

@NgModule({
    imports: [
        CommonModule, FormsModule, HttpModule, EquipmentRoutingModule
    ],
    declarations: [
        EquipmentComponent, NewEquipmentComponent, EquipmentListComponent
    ],
    providers: [EquipmentService]
})
export class EquipmentModule {}
