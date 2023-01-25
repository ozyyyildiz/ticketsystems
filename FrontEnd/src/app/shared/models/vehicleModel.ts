import {SeatModel} from "./seatModel";

export class VehicleModel{

  constructor(public id: string,
              public licensePlate: string,
              public expTime: string,
              public routeDto?: string,
              public seatDto?: SeatModel[]) {
  }
}
