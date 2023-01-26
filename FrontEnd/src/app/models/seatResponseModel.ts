export class SeatResponseModel{
  constructor(public id: string,
              public seatNumber: string,
              public vehicle: string,
              public route: string,
              public status: string) {
  }
}
