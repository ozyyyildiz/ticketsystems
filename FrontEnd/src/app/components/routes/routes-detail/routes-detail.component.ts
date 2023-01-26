import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {RoutesService} from "../../../services/routes.service";
import {VehicleModel} from "../../../models/vehicleModel";
import {map} from "rxjs/operators";
import {RouteModel} from "../../../models/routeModel";

@Component({
  selector: 'app-routes-detail',
  templateUrl: './routes-detail.component.html',
  styleUrls: ['./routes-detail.component.css']
})
export class RoutesDetailComponent implements OnInit{

  vehicleList: VehicleModel[] = [];

  constructor(private routesService: RoutesService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.getRouteVehicles(params['id']);
    })
  }

  private getRouteVehicles(params){
    this.routesService.getSingleRoute(params).pipe(
      map((routeModel: RouteModel) => {
        const vehicleList: VehicleModel[] = [];
        for(const key in routeModel.vehicleDtoList){
          vehicleList.push({ ...routeModel.vehicleDtoList[key] });
        }
        return vehicleList;
      })
    ).subscribe(routeVehicles=> {
      this.vehicleList = routeVehicles;
    });
  }
}
