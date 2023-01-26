import {NgModule} from "@angular/core";
import {RoutesComponent} from "./routes.component";
import {RoutesDetailComponent} from "./routes-detail/routes-detail.component";
import {RoutesListComponent} from "./routes-list/routes-list.component";
import {RoutesStartComponent} from "./routes-start/routes-start.component";
import {SharedModule} from "../../shared.module";

@NgModule({
  declarations: [
    RoutesComponent,
    RoutesDetailComponent,
    RoutesListComponent,
    RoutesStartComponent
  ],
  imports: [
    SharedModule
  ],
  exports: [
    RoutesComponent,
    RoutesDetailComponent,
    RoutesListComponent,
    RoutesStartComponent
  ]
})
export class RoutesModule{}
