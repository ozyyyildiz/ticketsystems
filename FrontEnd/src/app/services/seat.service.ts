import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {TicketModel} from "../shared/models/ticketModel";
import {SeatModel} from "../shared/models/seatModel";
import {UserModel} from "../shared/models/userModel";

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  private baseUrl = 'http://localhost:8080/seats';

  constructor(private http: HttpClient) { }

  getAllSeats(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((responseData:SeatModel)=>{
        const seatsArray: SeatModel[] = [];
        for(const key in responseData){
          seatsArray.push({ ...responseData[key] });
        }
        return seatsArray;
      }));
  }
}
