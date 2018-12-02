"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var hospital_list_component_1 = require("./hospital-list.component");
var hospital_service_1 = require("./hospital.service");
var testing_1 = require("@angular/core/testing");
var http_1 = require("@angular/http");
var router_1 = require("@angular/router");
var router_stubs_1 = require("../testing/router-stubs");
describe('HospitalListComponent', function () {
    var comp;
    var fixture;
    beforeEach(testing_1.async(function () {
        testing_1.TestBed.configureTestingModule({
            imports: [http_1.HttpModule],
            declarations: [hospital_list_component_1.HospitalListComponent],
            providers: [
                { provide: hospital_service_1.HospitalService, useValue: {} },
                { provide: router_1.Router, useClass: router_stubs_1.RouterStub },
                { provide: router_1.ActivatedRoute, useValue: router_stubs_1.ActivatedRouteStub },
            ],
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = testing_1.TestBed.createComponent(hospital_list_component_1.HospitalListComponent);
        comp = fixture.componentInstance;
    });
    it('should tell ROUTER to navigate when speciality is clicked', testing_1.inject([router_1.Router], function (router) {
        var spy = spyOn(router, 'navigateByUrl');
        comp.getHospitals();
        var navArgs = spy.calls.first().args[0];
        expect(navArgs).toBe('/hospital');
    }));
});
//# sourceMappingURL=hospital-list.component.spec.js.map