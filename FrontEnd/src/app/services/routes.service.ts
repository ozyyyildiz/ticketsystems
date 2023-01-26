import { Injectable } from '@angular/core';
import {HttpBackend, HttpClient} from "@angular/common/http";
import {RouteModel} from "../shared/models/routeModel";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RoutesService {

  baseUrl = 'http://localhost:8080/routes'

  private httpClient: HttpClient;

  constructor(private http: HttpClient, handler: HttpBackend) {
    this.httpClient = new HttpClient(handler);
  }

  getAllRoutes(){
    return this.httpClient.get(this.baseUrl + '/')
      .pipe(map((routeData: RouteModel) => {
        const routeList: RouteModel[] = [];
        for(const key in routeData){
          routeList.push({ ...routeData[key]});
        }
        return routeList;
      }));
  }

  getSingleRoute(id: string){
    return this.httpClient.get(this.baseUrl + '/route/' + id)
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
