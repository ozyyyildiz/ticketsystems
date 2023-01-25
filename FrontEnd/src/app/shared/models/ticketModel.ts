import {UserModel} from "./userModel";
import {VehicleModel} from "./vehicleModel";
import {SeatModel} from "./seatModel";
import {TicketStatusModel} from "./ticketStatusModel";

export class TicketModel {

  constructor(public name: string,
              public surname: string,
              public vehicle: string,
              public seat: string,
              public user?: string,
              public id?: string,
              public ticketStatus?: string) {
  }

  // constructor(public id: string,
  //             public name: string,
  //             public surname: string) {
  // }

}
