"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var EquipmentComponent = /** @class */ (function () {
    function EquipmentComponent() {
    }
    EquipmentComponent.prototype.ngOnInit = function () {
    };
    EquipmentComponent = __decorate([
        core_1.Component({
            template: "<div style=\"float:left\">\n    <ul class=\"list-group\">\n      <li class=\"list-group-item\"><a routerLink=\"/equipment\" routerLinkActive=\"active\">Urz\u0105dzenia</a></li>\n      <li class=\"list-group-item\"><a routerLink=\"/equipment/new\" routerLinkActive=\"active\">Dodaj nowe</a></li>\n    </ul>\n  </div>\n  <div style=\"margin-left: 160px\">\n    <router-outlet></router-outlet>\n  </div>\n  ",
        })
    ], EquipmentComponent);
    return EquipmentComponent;
}());
exports.EquipmentComponent = EquipmentComponent;
//# sourceMappingURL=equipment.component.js.map