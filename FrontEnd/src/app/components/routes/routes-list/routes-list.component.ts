import {Component, Input, OnInit} from '@angular/core';
import {RouteModel} from "../../../shared/models/routeModel";
import {VehicleModel} from "../../../shared/models/vehicleModel";
import {RoutesService} from "../../../services/routes.service";

@Component({
  selector: 'app-routes-list',
  templateUrl: './routes-list.component.html',
  styleUrls: ['./routes-list.component.css']
})
export class RoutesListComponent{
  @Input() route: RouteModel;

}
