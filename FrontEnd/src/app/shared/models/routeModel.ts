import {VehicleModel} from "./vehicleModel";

export class RouteModel {

  constructor(public id: string,
              public fromCity: string,
              public toCity: string,
              public vehicleDtoList?: VehicleModel[] ) {
  }
}
