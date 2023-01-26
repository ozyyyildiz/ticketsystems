import {Component, Input, OnInit} from '@angular/core';
import {RouteModel} from "../../../models/routeModel";

@Component({
  selector: 'app-routes-list',
  templateUrl: './routes-list.component.html',
  styleUrls: ['./routes-list.component.css']
})
export class RoutesListComponent{
  @Input() route: RouteModel;

}
