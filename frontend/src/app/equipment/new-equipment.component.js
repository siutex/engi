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
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var equipment_1 = require("./equipment");
var equipment_service_1 = require("./equipment.service");
var NewEquipmentComponent = /** @class */ (function () {
    function NewEquipmentComponent(equipService, router) {
        this.equipService = equipService;
        this.router = router;
        this.equip = new equipment_1.Equipment();
        this.equipStatus = new equipment_1.EquipStatus();
        this.alertStyle = '';
    }
    NewEquipmentComponent.prototype.onSubmit = function () {
        var _this = this;
        this.equipService.createEquip(this.equip)
            .subscribe(function (equip) {
            _this.equipStatus.code = 'SUCCESS';
            _this.equipStatus.message = 'Urządzenie dodane';
            _this.alertStyle = 'alert alert-success';
        }, function (error) {
            if (error === 'invalid_token') {
                _this.router.navigateByUrl('/auth/login');
                _this.equipStatus.code = 'FAILURE';
                _this.equipStatus.message = 'sprzęt niedodany błąd sesji';
                _this.alertStyle = 'alert alert-danger';
            }
            _this.equipStatus.code = 'FAILURE';
            _this.equipStatus.message = 'błąd';
            _this.alertStyle = 'alert alert-danger';
        });
    };
    NewEquipmentComponent = __decorate([
        core_1.Component({
            templateUrl: './new-equipment.component.html'
        }),
        __metadata("design:paramtypes", [equipment_service_1.EquipmentService, router_1.Router])
    ], NewEquipmentComponent);
    return NewEquipmentComponent;
}());
exports.NewEquipmentComponent = NewEquipmentComponent;
//# sourceMappingURL=new-equipment.component.js.map