import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RouteModel} from "../shared/models/routeModel";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RoutesService {

  baseUrl = 'http://localhost:8080/routes'

  constructor(private http: HttpClient) { }

  getAllRoutes(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((routeData: RouteModel) => {
        const routeList: RouteModel[] = [];
        for(const key in routeData){
          routeList.push({ ...routeData[key]});
        }
        return routeList;
      }));
  }

  getSingleRoute(id: string){
    return this.http.get(this.baseUrl + '/route' + id)
  }

  saveRoute(route: RouteModel){
    return this.http.post(this.baseUrl + '/createRoute', route)
  }

  updateRoute(route: RouteModel){
    return this.http.post(this.baseUrl + '/updateRoute', route)
  }

  deleteRoute(id: string){
    return this.http.post(this.baseUrl + '/deleteRoute' + id, '');
  }

}
