import {Component, OnInit} from '@angular/core';
import {RouteModel} from "../../../shared/models/routeModel";
import {RoutesService} from "../../../services/routes.service";

@Component({
  selector: 'app-admin-routes',
  templateUrl: './admin-routes.component.html',
  styleUrls: ['./admin-routes.component.css']
})
export class AdminRoutesComponent implements OnInit{

  loadedRoutes: RouteModel[] = [];

  constructor(private routesService: RoutesService) {
  }

  ngOnInit(): void {
    this.routesService.getAllRoutes().subscribe((allRoutes : RouteModel[]) => {
      this.loadedRoutes = allRoutes;
    })
  }

}
