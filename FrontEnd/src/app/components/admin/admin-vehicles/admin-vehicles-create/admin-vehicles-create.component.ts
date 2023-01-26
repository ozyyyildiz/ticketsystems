import {Component, OnInit} from '@angular/core';
import {VehiclesService} from "../../../../services/vehicles.service";
import {NgForm} from "@angular/forms";
import {RoutesService} from "../../../../services/routes.service";
import {RouteModel} from "../../../../models/routeModel";

@Component({
  selector: 'app-admin-vehicles-create',
  templateUrl: './admin-vehicles-create.component.html',
  styleUrls: ['./admin-vehicles-create.component.css']
})
export class AdminVehiclesCreateComponent implements OnInit{

  date = new Date()
  year = this.date.getFullYear();
  month = this.date.getMonth()<10? ""+this.date.getMonth()+1 : this.date.getMonth();
  day = this.date.getDate();
  minDate = this.year+"-"+this.month+"-"+this.day+"T00:00";

  routeList: RouteModel[] = [];

  constructor(private vehicleService: VehiclesService, private routeService: RoutesService) {
  }

  ngOnInit(){
    this.routeService.getAllRoutes().subscribe(routeList => {
      this.routeList = routeList;
    })
  }

  onSubmit(form: NgForm){
    let timeList = form.value.expTime.toString().split('T',);
    form.value.expTime = timeList[0] + " " + timeList[1]+ ":00";
    this.vehicleService.saveVehicle(form.value).subscribe(responseData => {
      window.location.reload();
    })
  }

}
