import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from "./shared/header/header.component";
import { HttpClientModule } from "@angular/common/http";
import { RoutesComponent } from './components/routes/routes.component';
import { RoutesDetailComponent } from './components/routes/routes-detail/routes-detail.component';
import { RoutesListComponent } from './components/routes/routes-list/routes-list.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { TicketDetailComponent } from './components/tickets/ticket-detail/ticket-detail.component';
import { UsersComponent } from './components/admin/users/users.component';
import { UserDetailComponent } from './components/admin/users/user-detail/user-detail.component';
import { UserListComponent } from './components/admin/users/user-list/user-list.component';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { VehicleDetailComponent } from './components/vehicles/vehicle-detail/vehicle-detail.component';
import { VehicleListComponent } from './components/vehicles/vehicle-list/vehicle-list.component';
import { SeatsComponent } from './components/vehicles/seats/seats.component';
import { SeatDetailComponent } from './components/vehicles/seats/seat-detail/seat-detail.component';
import { SeatListComponent } from './components/vehicles/seats/seat-list/seat-list.component';
import { AppRoutingModule } from "./app-routing.module";
import { RoutesStartComponent } from './components/routes/routes-start/routes-start.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { TicketBuyComponent } from './components/tickets/ticket-buy/ticket-buy.component';
import { AdminComponent } from './components/admin/admin.component';
import { TableFilterPipe } from './shared/pipes/table-filter.pipe';
import { UserCreateComponent } from './components/admin/users/user-create/user-create.component';
import { ResponseModalComponent } from './shared/response-modal/response-modal.component';
import { AdminRoutesComponent } from "./components/admin/admin-routes/admin-routes.component";
import { AdminRoutesListComponent } from './components/admin/admin-routes/admin-routes-list/admin-routes-list.component';
import { AdminRoutesCreateComponent } from './components/admin/admin-routes/admin-routes-create/admin-routes-create.component';
import { AdminRoutesDetailComponent } from './components/admin/admin-routes/admin-routes-detail/admin-routes-detail.component';
import { AdminVehiclesComponent } from './components/admin/admin-vehicles/admin-vehicles.component';
import { AdminVehiclesCreateComponent } from './components/admin/admin-vehicles/admin-vehicles-create/admin-vehicles-create.component';
import { AdminVehiclesListComponent } from './components/admin/admin-vehicles/admin-vehicles-list/admin-vehicles-list.component';
import { AdminVehiclesDetailComponent } from './components/admin/admin-vehicles/admin-vehicles-detail/admin-vehicles-detail.component';
import { NgbDatepicker } from "@ng-bootstrap/ng-bootstrap";
import { UserTicketsComponent } from './components/admin/users/user-tickets/user-tickets.component';
import { TicketListComponent } from './components/tickets/ticket-list/ticket-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RoutesComponent,
    RoutesDetailComponent,
    RoutesListComponent,
    RoutesStartComponent,
    TicketsComponent,
    TicketDetailComponent,
    TicketBuyComponent,
    UsersComponent,
    UserDetailComponent,
    UserListComponent,
    UserCreateComponent,
    VehiclesComponent,
    VehicleDetailComponent,
    VehicleListComponent,
    SeatsComponent,
    SeatDetailComponent,
    SeatListComponent,
    AdminComponent,
    TableFilterPipe,
    ResponseModalComponent,
    AdminRoutesComponent,
    AdminRoutesListComponent,
    AdminRoutesCreateComponent,
    AdminRoutesDetailComponent,
    AdminVehiclesComponent,
    AdminVehiclesCreateComponent,
    AdminVehiclesListComponent,
    AdminVehiclesDetailComponent,
    UserTicketsComponent,
    TicketListComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        NgbDatepicker
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }