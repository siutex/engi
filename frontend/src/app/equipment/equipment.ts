export class Equipment {
    public id: string;
    public equipmentName: string;
    public quantity: string;
    public producer: string;
    public isMaintenance: string;
    public isControled: string;
    public serviceNumber: string;
    public lastUpdated: string;
    constructor() {}
}

export class EquipStatus {
    public code = '';
    public message = '';
    constructor() {}
}


