import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {TicketModel} from "../shared/models/ticketModel";
import {map} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl = 'http://localhost:8080/tickets';

  constructor(private http: HttpClient) { }

  getAllTickets(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((responseData:TicketModel)=>{
        const ticketsArray: TicketModel[] = [];
        for(const key in responseData){
          ticketsArray.push({ ...responseData[key] });
        }
        return ticketsArray;
      }));
  }

  getUserTickets(id){
    return this.http.get(this.baseUrl + "/userTicket/" + id)
      .pipe(map((responseData:TicketModel)=>{
      const ticketsArray: TicketModel[] = [];
      for(const key in responseData){
        ticketsArray.push({ ...responseData[key] });
      }
      return ticketsArray;
    }));
  }

  onUpdateTicket(ticketData: TicketModel, status?: string){
    if(status){
      ticketData.ticketStatus = status;
    }
    return this.http.post(this.baseUrl + "/updateTicket", ticketData);
  }

  onBuyTicket(ticketData: TicketModel){
    ticketData.ticketStatus = "PURCHASED"
    ticketData.user = "2"
    console.log(ticketData);
    return this.http.post(this.baseUrl + "/saveTicket", ticketData);
  }
  onReserveTicket(ticketData: TicketModel){
    ticketData.ticketStatus = "RESERVED"
    ticketData.user = "2"
    return this.http.post(this.baseUrl + "/saveTicket", ticketData);
  }
}
