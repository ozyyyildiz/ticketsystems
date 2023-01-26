import {Component, OnInit} from '@angular/core';
import {TicketModel} from "../../../shared/models/ticketModel";
import {TicketService} from "../../../services/ticket.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit{

  id = this.activatedRoute.snapshot.params['uid'];

  loadedTickets: TicketModel[] = [];
  filterData: string;

  constructor(private ticketService: TicketService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.ticketService.getUserTickets(this.id).subscribe((userTickets:TicketModel[]) => {
      this.loadedTickets = userTickets;
    })
  }

  onTicketCancel(id){
    let ticket = this.loadedTickets.find(ticket => ticket.id === id);
    this.ticketService.onUpdateTicket(ticket, "CANCELED").subscribe(responseData => {
    })
  }

  onTicketBuy(id){
    let ticket = this.loadedTickets.find(ticket => ticket.id === id);
    this.ticketService.onUpdateTicket(ticket, "PURCHASED").subscribe(responseData => {
    })
  }

  onTicketPostPone(id){
    let ticket = this.loadedTickets.find(ticket => ticket.id === id);
    this.ticketService.onUpdateTicket(ticket, "POSTPONED").subscribe(responseData => {
    })
  }

}
