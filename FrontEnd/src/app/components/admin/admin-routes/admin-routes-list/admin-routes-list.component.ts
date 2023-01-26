import {Component, Input} from '@angular/core';
import {RouteModel} from "../../../../models/routeModel";

@Component({
  selector: 'app-admin-routes-list',
  templateUrl: './admin-routes-list.component.html',
  styleUrls: ['./admin-routes-list.component.css']
})
export class AdminRoutesListComponent{
  @Input() route: RouteModel;

}
