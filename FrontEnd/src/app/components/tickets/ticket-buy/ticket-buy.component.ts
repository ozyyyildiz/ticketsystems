import {Component, OnInit} from '@angular/core';
import {TicketService} from "../../../services/ticket.service";
import {NgForm} from "@angular/forms";
import {TicketModel} from "../../../shared/models/ticketModel";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-ticket-buy',
  templateUrl: './ticket-buy.component.html',
  styleUrls: ['./ticket-buy.component.css']
})
export class TicketBuyComponent implements OnInit{

  vehicle = this.activatedRoute.snapshot.params['vid'];
  seat = this.activatedRoute.snapshot.params['sid'];
  ticket: TicketModel = {} as TicketModel;


  constructor(private ticketService: TicketService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {

  }

  onBuyTicket(form: NgForm){
    this.ticket = new TicketModel(form.value.name, form.value.surname, this.vehicle,this.seat)
    this.ticket.name = form.value.name;
    this.ticket.surname = form.value.surname;
    this.ticket.vehicle = this.vehicle;
    this.ticket.seat = this.seat;
    this.ticketService.onBuyTicket(this.ticket).subscribe(responseData=> {
      window.location.reload();
    })
  }

  onReserveTicket(form: NgForm){
    this.ticket.name = form.value.name;
    this.ticket.surname = form.value.surname;
    this.ticket.vehicle = this.vehicle;
    this.ticket.seat = this.seat;
    this.ticketService.onReserveTicket(this.ticket).subscribe(responseData=> {
      window.location.reload();
    });
  }

}
