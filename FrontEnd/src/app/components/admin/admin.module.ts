import { NgModule } from '@angular/core';
import {AdminRoutesComponent} from "./admin-routes/admin-routes.component";
import {AdminRoutesListComponent} from "./admin-routes/admin-routes-list/admin-routes-list.component";
import {
  AdminRoutesCreateComponent
} from "./admin-routes/admin-routes-create/admin-routes-create.component";
import {
  AdminRoutesDetailComponent
} from "./admin-routes/admin-routes-detail/admin-routes-detail.component";
import {AdminVehiclesComponent} from "./admin-vehicles/admin-vehicles.component";
import {
  AdminVehiclesCreateComponent
} from "./admin-vehicles/admin-vehicles-create/admin-vehicles-create.component";
import {
  AdminVehiclesListComponent
} from "./admin-vehicles/admin-vehicles-list/admin-vehicles-list.component";
import {
  AdminVehiclesDetailComponent
} from "./admin-vehicles/admin-vehicles-detail/admin-vehicles-detail.component";
import {AdminComponent} from "./admin.component";
import {AdminSeatListComponent} from "./seat-list/seat-list.component";
import {UsersComponent} from "./users/users.component";
import {UserDetailComponent} from "./users/user-detail/user-detail.component";
import {UserListComponent} from "./users/user-list/user-list.component";
import {UserCreateComponent} from "./users/user-create/user-create.component";
import {UserTicketsComponent} from "./users/user-tickets/user-tickets.component";
import {SharedModule} from "../../shared.module";



@NgModule({
  declarations: [
    AdminComponent,
    AdminRoutesComponent,
    AdminRoutesListComponent,
    AdminRoutesCreateComponent,
    AdminRoutesDetailComponent,
    AdminVehiclesComponent,
    AdminVehiclesCreateComponent,
    AdminVehiclesListComponent,
    AdminVehiclesDetailComponent,
    AdminSeatListComponent,
    UsersComponent,
    UserDetailComponent,
    UserListComponent,
    UserCreateComponent,
    UserTicketsComponent,
  ],
  imports: [
    SharedModule
  ],
  exports: [
    AdminComponent,
    AdminRoutesComponent,
    AdminRoutesListComponent,
    AdminRoutesCreateComponent,
    AdminRoutesDetailComponent,
    AdminVehiclesComponent,
    AdminVehiclesCreateComponent,
    AdminVehiclesListComponent,
    AdminVehiclesDetailComponent,
    AdminSeatListComponent,
    UsersComponent,
    UserDetailComponent,
    UserListComponent,
    UserCreateComponent,
    UserTicketsComponent,
  ]
})
export class AdminModule { }
