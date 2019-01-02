import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {EquipmentComponent} from './equipment.component';
import {NewEquipmentComponent} from './new-equipment.component';
import {EquipmentListComponent} from './equipment-list.component';


const equipmentRoutes: Routes = [
    {
        path: 'equipment',
        component: EquipmentComponent,
        children: [
            {
                path: '',
                component: EquipmentListComponent,
            }
            ,
            {
                path: 'new',
                component: NewEquipmentComponent,
            }
        ],
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(equipmentRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class EquipmentRoutingModule {
}
