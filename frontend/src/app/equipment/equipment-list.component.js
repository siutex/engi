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
var equipment_service_1 = require("./equipment.service");
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var EquipmentListComponent = /** @class */ (function () {
    function EquipmentListComponent(equipmentService, router) {
        this.equipmentService = equipmentService;
        this.router = router;
        this.errorMessage = '';
    }
    EquipmentListComponent.prototype.ngOnInit = function () {
        this.getEquip();
    };
    EquipmentListComponent.prototype.getEquip = function () {
        var _this = this;
        this.equipmentService.getEquip()
            .subscribe(function (equiplist) {
            _this.equiplist = equiplist;
            if (_this.equiplist.length === 0) {
                _this.errorMessage = 'brak sprzętu !';
            }
        }, function (error) {
            _this.router.navigateByUrl('/auth/login');
            console.error('błąd, powtórne logowanie: ', error);
        });
    };
    EquipmentListComponent = __decorate([
        core_1.Component({
            templateUrl: './equipment-list.component.html'
        }),
        __metadata("design:paramtypes", [equipment_service_1.EquipmentService, router_1.Router])
    ], EquipmentListComponent);
    return EquipmentListComponent;
}());
exports.EquipmentListComponent = EquipmentListComponent;
//# sourceMappingURL=equipment-list.component.js.map