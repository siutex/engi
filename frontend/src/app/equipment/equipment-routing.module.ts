import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {EquipmentComponent} from './equipment.component';


const equipmentRoutes: Routes = [
    {
        path: 'equipment',
        component: EquipmentComponent,
        children: [
            {
                path: '',
                component: EquipmentComponent,
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
