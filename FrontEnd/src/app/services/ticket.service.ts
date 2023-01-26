import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {TicketModel} from "../models/ticketModel";
import {map} from 'rxjs/operators'
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl = 'http://localhost:8080/tickets';

  username: string;

  constructor(private http: HttpClient, private jwtHelper: JwtHelperService) { }

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
    let token = this.jwtHelper.decodeToken(localStorage.getItem("token"))
    ticketData.user = token.sub;
    return this.http.post(this.baseUrl + "/saveTicket", ticketData);
  }
  onReserveTicket(ticketData: TicketModel){
    ticketData.ticketStatus = "RESERVED"
    let token = this.jwtHelper.decodeToken(localStorage.getItem("token"))
    ticketData.user = token.sub;
    return this.http.post(this.baseUrl + "/saveTicket", ticketData);
  }
}
