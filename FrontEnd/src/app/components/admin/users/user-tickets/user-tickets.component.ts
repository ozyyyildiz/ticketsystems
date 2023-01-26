import {Component, OnInit} from '@angular/core';
import {TicketModel} from "../../../../models/ticketModel";
import {TicketService} from "../../../../services/ticket.service";

@Component({
  selector: 'app-user-tickets',
  templateUrl: './user-tickets.component.html',
  styleUrls: ['./user-tickets.component.css']
})
export class UserTicketsComponent implements OnInit {

  loadedTickets: TicketModel[] = [];
  filterData: string;

  constructor(private ticketService: TicketService,) {
  }

  ngOnInit(){
    this.ticketService.getAllTickets().subscribe(responseData => {
      this.loadedTickets = responseData;
    })
  }

}
