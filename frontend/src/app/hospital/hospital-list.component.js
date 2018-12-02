"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var hospital_service_1 = require("./hospital.service");
var core_1 = require("@angular/core");
var HospitalListComponent = /** @class */ (function () {
    function HospitalListComponent(hospitalService) {
        this.hospitalService = hospitalService;
        this.errorMessage = '';
    }
    HospitalListComponent.prototype.ngOnInit = function () {
        this.getHospitals();
    };
    HospitalListComponent.prototype.getHospitals = function () {
        var _this = this;
        this.hospitalService.getHospital()
            .subscribe(function (hospitals) {
            _this.hospitals = hospitals;
            if (_this.hospitals.length === 0) {
                _this.errorMessage = 'Pusto';
            }
        }, function (error) {
            console.error('Brak gabinetów: ', error);
        });
    };
    HospitalListComponent = __decorate([
        core_1.Component({
            templateUrl: './hospital-list.component.html'
        }),
        __metadata("design:paramtypes", [hospital_service_1.HospitalService])
    ], HospitalListComponent);
    return HospitalListComponent;
}());
exports.HospitalListComponent = HospitalListComponent;
//# sourceMappingURL=hospital-list.component.js.map