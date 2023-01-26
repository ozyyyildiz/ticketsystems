import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {SeatResponseModel} from "../shared/models/seatResponseModel";

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  private baseUrl = 'http://localhost:8080/seats';

  constructor(private http: HttpClient) { }

  getAllEmptySeats(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((responseData:SeatResponseModel)=>{
        const seatsArray: SeatResponseModel[] = [];
        for(const key in responseData){
          seatsArray.push({ ...responseData[key] });
        }
        return seatsArray;
      }));
  }
}
