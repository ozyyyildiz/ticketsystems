import {Component, OnInit} from '@angular/core';
import {TicketModel} from "../../../shared/models/ticketModel";
import {VehicleModel} from "../../../shared/models/vehicleModel";
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
    this.ticketService.getUserTickets(this.id).subscribe((userTicketse:TicketModel[]) => {
      this.loadedTickets = userTicketse;
      console.log(userTicketse)
    })
  }

  onTicketCancel(id){
    let ticket = this.loadedTickets.find(ticket => ticket.id === id);
    this.ticketService.onUpdateTicket(ticket, "3").subscribe(responseData => {
      console.log(responseData);
    })
  }

  onTicketBuy(id){
    console.log("onTicketBuy");
  }

  onTicketPostPone(id){
    let ticket = this.loadedTickets.find(ticket => ticket.id === id);
    this.ticketService.onUpdateTicket(ticket, "4").subscribe(responseData => {
      console.log(responseData);
    })
  }

}
