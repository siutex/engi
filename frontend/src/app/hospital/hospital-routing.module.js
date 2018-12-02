"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var router_1 = require("@angular/router");
var core_1 = require("@angular/core");
var hospital_list_component_1 = require("./hospital-list.component");
var hospital_component_1 = require("./hospital.component");
var hospitalRoutes = [
    {
        path: 'hospital',
        component: hospital_component_1.HospitalComponent,
        children: [
            {
                path: '',
                component: hospital_list_component_1.HospitalListComponent,
            }
        ],
    }
];
var HospitalRoutingModule = /** @class */ (function () {
    function HospitalRoutingModule() {
    }
    HospitalRoutingModule = __decorate([
        core_1.NgModule({
            imports: [
                router_1.RouterModule.forChild(hospitalRoutes)
            ],
            exports: [
                router_1.RouterModule
            ]
        })
    ], HospitalRoutingModule);
    return HospitalRoutingModule;
}());
exports.HospitalRoutingModule = HospitalRoutingModule;
//# sourceMappingURL=hospital-routing.module.js.map