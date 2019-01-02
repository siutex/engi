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
var equipment_component_1 = require("./equipment.component");
var new_equipment_component_1 = require("./new-equipment.component");
var equipment_list_component_1 = require("./equipment-list.component");
var equipmentRoutes = [
    {
        path: 'equipment',
        component: equipment_component_1.EquipmentComponent,
        children: [
            {
                path: '',
                component: equipment_list_component_1.EquipmentListComponent,
            },
            {
                path: 'new',
                component: new_equipment_component_1.NewEquipmentComponent,
            }
        ],
    }
];
var EquipmentRoutingModule = /** @class */ (function () {
    function EquipmentRoutingModule() {
    }
    EquipmentRoutingModule = __decorate([
        core_1.NgModule({
            imports: [
                router_1.RouterModule.forChild(equipmentRoutes)
            ],
            exports: [
                router_1.RouterModule
            ]
        })
    ], EquipmentRoutingModule);
    return EquipmentRoutingModule;
}());
exports.EquipmentRoutingModule = EquipmentRoutingModule;
//# sourceMappingURL=equipment-routing.module.js.map