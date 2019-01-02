"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var common_1 = require("@angular/common");
var core_1 = require("@angular/core");
var equipment_routing_module_1 = require("./equipment-routing.module");
var equipment_component_1 = require("./equipment.component");
var new_equipment_component_1 = require("./new-equipment.component");
var equipment_list_component_1 = require("./equipment-list.component");
var equipment_service_1 = require("./equipment.service");
var EquipmentModule = /** @class */ (function () {
    function EquipmentModule() {
    }
    EquipmentModule = __decorate([
        core_1.NgModule({
            imports: [
                common_1.CommonModule, forms_1.FormsModule, http_1.HttpModule, equipment_routing_module_1.EquipmentRoutingModule
            ],
            declarations: [
                equipment_component_1.EquipmentComponent, new_equipment_component_1.NewEquipmentComponent, equipment_list_component_1.EquipmentListComponent
            ],
            providers: [equipment_service_1.EquipmentService]
        })
    ], EquipmentModule);
    return EquipmentModule;
}());
exports.EquipmentModule = EquipmentModule;
//# sourceMappingURL=equipment.module.js.map