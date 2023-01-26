import {SeatStatusModel} from "./seatStatusModel";

export class SeatModel{

  constructor(public id: string,
              public seatNumber: string,
              public status: SeatStatusModel) {

  }

}
