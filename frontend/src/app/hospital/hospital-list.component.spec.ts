import { HospitalListComponent } from './hospital-list.component';
import { HospitalService } from './hospital.service';

import {async, ComponentFixture, TestBed, inject} from '@angular/core/testing';

import { HttpModule } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {ActivatedRouteStub, RouterStub} from '../testing/router-stubs';

describe('HospitalListComponent', function () {
    let comp: HospitalListComponent;
    let fixture: ComponentFixture<HospitalListComponent>;

    beforeEach(async(() => {

        TestBed.configureTestingModule({
            imports: [ HttpModule ],
            declarations: [ HospitalListComponent ],
            providers:    [
                { provide: HospitalService, useValue: {} },
                { provide: Router, useClass: RouterStub },
                { provide: ActivatedRoute, useValue: ActivatedRouteStub },
            ],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(HospitalListComponent);
        comp = fixture.componentInstance;
    });


    it('should tell ROUTER to navigate when speciality is clicked',
        inject([Router], (router: Router) => {

            const spy = spyOn(router, 'navigateByUrl');
            comp.getHospitals()
            let navArgs = spy.calls.first().args[0];
            expect(navArgs).toBe('/hospital');
        }));

});
