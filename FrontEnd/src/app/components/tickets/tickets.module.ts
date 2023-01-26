import {NgModule} from "@angular/core";
import {TicketsComponent} from "./tickets.component";
import {TicketBuyComponent} from "./ticket-buy/ticket-buy.component";
import {TicketListComponent} from "./ticket-list/ticket-list.component";
import {SharedModule} from "../../shared.module";

@NgModule({
  declarations: [
    TicketsComponent,
    TicketBuyComponent,
    TicketListComponent
  ],
  imports: [
    SharedModule
  ],
  exports: [
    TicketsComponent,
    TicketBuyComponent,
    TicketListComponent
  ]
})
export class TicketsModule{

}
