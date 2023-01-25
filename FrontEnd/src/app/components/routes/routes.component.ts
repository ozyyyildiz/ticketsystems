import {Component, OnInit} from '@angular/core';
import {RouteModel} from "../../shared/models/routeModel";
import {RoutesService} from "../../services/routes.service";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit{

  loadedRoutes: RouteModel[] = [];

  constructor(private routesService: RoutesService) {
  }

  ngOnInit(): void {
    this.routesService.getAllRoutes().subscribe(routeList => {
      this.loadedRoutes = routeList;
    });
  }
}
