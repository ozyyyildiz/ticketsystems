import {Component, OnInit} from '@angular/core';
import {VehicleModel} from "../../../../models/vehicleModel";
import {VehiclesService} from "../../../../services/vehicles.service";

@Component({
  selector: 'app-admin-vehicles-list',
  templateUrl: './admin-vehicles-list.component.html',
  styleUrls: ['./admin-vehicles-list.component.css']
})
export class AdminVehiclesListComponent implements OnInit{

  loadedVehicles: VehicleModel[] = [];
  filterData: string;

  constructor(private vehicleService: VehiclesService) {
  }

  ngOnInit() {
    this.vehicleService.getAllVehicles().subscribe((allVehicles:VehicleModel[]) => {
      this.loadedVehicles = allVehicles;
    })
  }

  onDeleteVehicle(id){
    this.vehicleService.deleteVehicle(id).subscribe(response => {
      window.location.reload();
    })
  }


}
