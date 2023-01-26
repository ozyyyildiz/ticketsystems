import { Injectable } from '@angular/core';
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {VehicleModel} from "../shared/models/vehicleModel";

@Injectable({
  providedIn: 'root'
})
export class VehiclesService {

  baseUrl = 'http://localhost:8080/vehicles'

  constructor(private http: HttpClient) { }

  getAllVehicles(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((vehicleData: VehicleModel) => {
        const vehicleList: VehicleModel[] = [];
        for(const key in vehicleData){
          const vehicle = vehicleData[key];
          if(vehicleData[key].routeDto != null){
            vehicle.routeDto = vehicleData[key].routeDto.fromCity.toString() + " - " + vehicleData[key].routeDto.toCity.toString();
          }else{
            vehicle.routeDto = "Rota Bulunamadı";
          }
          vehicleList.push(vehicle);
        }
        return vehicleList;
      }));
  }

  getSingleVehicle(id: string){
    return this.http.get(this.baseUrl + '/vehicle' + id)
  }

  saveVehicle(vehicle: VehicleModel){
    return this.http.post(this.baseUrl + '/createVehicle', vehicle)
  }

  updateVehicle(vehicle: VehicleModel){
    return this.http.post(this.baseUrl + '/updateVehicle', vehicle)
  }

  deleteVehicle(id: string){
    return this.http.post(this.baseUrl + '/deleteVehicle' + id, '');
  }
}
