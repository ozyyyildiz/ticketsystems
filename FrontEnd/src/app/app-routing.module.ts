import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {RoutesComponent} from "./components/routes/routes.component";
import {VehiclesComponent} from "./components/vehicles/vehicles.component";
import {RoutesStartComponent} from "./components/routes/routes-start/routes-start.component";
import {RoutesDetailComponent} from "./components/routes/routes-detail/routes-detail.component";
import {TicketsComponent} from "./components/tickets/tickets.component";
import {TicketBuyComponent} from "./components/tickets/ticket-buy/ticket-buy.component";
import {UsersComponent} from "./components/admin/users/users.component";
import {UserDetailComponent} from "./components/admin/users/user-detail/user-detail.component";
import {AdminComponent} from "./components/admin/admin.component";
import {UserListComponent} from "./components/admin/users/user-list/user-list.component";
import {UserCreateComponent} from "./components/admin/users/user-create/user-create.component";
import {AdminRoutesComponent} from "./components/admin/admin-routes/admin-routes.component";
import {AdminRoutesListComponent} from "./components/admin/admin-routes/admin-routes-list/admin-routes-list.component";
import {
  AdminRoutesCreateComponent
} from "./components/admin/admin-routes/admin-routes-create/admin-routes-create.component";
import {
  AdminRoutesDetailComponent
} from "./components/admin/admin-routes/admin-routes-detail/admin-routes-detail.component";
import {AdminVehiclesComponent} from "./components/admin/admin-vehicles/admin-vehicles.component";
import {
  AdminVehiclesListComponent
} from "./components/admin/admin-vehicles/admin-vehicles-list/admin-vehicles-list.component";
import {
  AdminVehiclesCreateComponent
} from "./components/admin/admin-vehicles/admin-vehicles-create/admin-vehicles-create.component";
import {
  AdminVehiclesDetailComponent
} from "./components/admin/admin-vehicles/admin-vehicles-detail/admin-vehicles-detail.component";
import {UserTicketsComponent} from "./components/admin/users/user-tickets/user-tickets.component";
import {TicketListComponent} from "./components/tickets/ticket-list/ticket-list.component";
import {SignupComponent} from "./components/auth/signup/signup.component";
import {LoginComponent} from "./components/auth/login/login.component";


const appRoutes: Routes = [
  { path: '', redirectTo: '/routes', pathMatch:'full' },
  { path: 'login', component: LoginComponent},
  { path: 'signup', component : SignupComponent },
  { path: 'routes', component: RoutesComponent, children: [
      { path: '', component: RoutesStartComponent },
      { path: ':id', component: RoutesDetailComponent }
    ]},
  { path: 'vehicles', component: VehiclesComponent },
  { path: 'tickets', component: TicketsComponent, children: [
      { path: 'myTickets/:uid', component: TicketListComponent },
      { path: ':vid/:sid', component: TicketBuyComponent }
    ]},
  { path: 'admin', component: AdminComponent, children: [
      { path: 'users', component: UsersComponent, children: [
          { path: 'list', component: UserListComponent },
          { path: 'create', component: UserCreateComponent },
          { path: ':uid', component: UserDetailComponent }
        ]},
      { path: 'routes', component: AdminRoutesComponent, children: [
          { path: 'list', component: AdminRoutesListComponent },
          { path: 'create', component: AdminRoutesCreateComponent },
          { path: ':rid', component: AdminRoutesDetailComponent }
        ]},
      { path: 'vehicles', component: AdminVehiclesComponent, children: [
          { path: 'list', component: AdminVehiclesListComponent },
          { path: 'create', component: AdminVehiclesCreateComponent },
          { path: ':vid', component: AdminVehiclesDetailComponent }
        ]},
       { path: 'tickets', component: UserTicketsComponent},
    ]}
]

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule{

}
