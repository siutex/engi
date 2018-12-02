import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HospitalListComponent} from './hospital-list.component';
import {HospitalComponent} from './hospital.component';


const hospitalRoutes: Routes = [
    {
        path: 'hospital',
        component: HospitalComponent,
        children: [
                    {
                        path: '',
                        component: HospitalListComponent,
                    }
                ],
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(hospitalRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class HospitalRoutingModule {
}
