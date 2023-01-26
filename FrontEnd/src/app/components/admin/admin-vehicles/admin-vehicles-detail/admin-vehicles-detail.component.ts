import {Component, OnInit} from '@angular/core';
import {VehiclesService} from "../../../../services/vehicles.service";
import {ActivatedRoute} from "@angular/router";
import {VehicleModel} from "../../../../shared/models/vehicleModel";
import {NgForm} from "@angular/forms";
import {RoutesService} from "../../../../services/routes.service";
import {RouteModel} from "../../../../shared/models/routeModel";

@Component({
  selector: 'app-admin-vehicles-detail',
  templateUrl: './admin-vehicles-detail.component.html',
  styleUrls: ['./admin-vehicles-detail.component.css']
})
export class AdminVehiclesDetailComponent implements OnInit{
  id = this.activatedRoute.snapshot.params['vid'];
  loadedVehicle: VehicleModel;

  routeList: RouteModel[] = [];

  date = new Date()
  year = this.date.getFullYear();
  month = this.date.getMonth()<10? ""+this.date.getMonth()+1 : this.date.getMonth();
  day = this.date.getDate();
  minDate = this.year+"-"+this.month+"-"+this.day+"T00:00";

  constructor(private vehicleService: VehiclesService,
              private activatedRoute: ActivatedRoute,
              private routeService: RoutesService) {
  }

  ngOnInit(): void {
    this.vehicleService.getSingleVehicle(this.id).subscribe((vehicle: VehicleModel)=>{
      this.loadedVehicle = vehicle
    });
    this.routeService.getAllRoutes().subscribe(routeList => {
      this.routeList = routeList;
    })
  }

  onUpdate(form: NgForm){
    this.loadedVehicle = form.value;
    this.loadedVehicle.id = this.id;
    this.vehicleService.updateVehicle(this.loadedVehicle).subscribe(responseData => {
      window.location.reload();
    })
  }

}
