import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {RoutesService} from "../../../../services/routes.service";
import {ActivatedRoute, Params} from "@angular/router";
import {RouteModel} from "../../../../models/routeModel";

@Component({
  selector: 'app-admin-routes-detail',
  templateUrl: './admin-routes-detail.component.html',
  styleUrls: ['./admin-routes-detail.component.css']
})
export class AdminRoutesDetailComponent implements OnInit{
  @ViewChild('form', {static: false}) routeForm: NgForm
  loadedRoute: RouteModel;

  constructor(private routesService: RoutesService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.routesService.getSingleRoute(params['rid']).subscribe((route: RouteModel) =>{
        this.loadedRoute = route;
        this.routeForm.setValue({
          fromCity: route.fromCity,
          toCity: route.toCity
        })
      })
    })
  }

  onUpdate(form: NgForm){
    this.loadedRoute.fromCity = form.value.fromCity
    this.loadedRoute.toCity = form.value.toCity
    this.routesService.updateRoute(this.loadedRoute).subscribe(responseData => {
      window.location.reload();
    })
  }

  onDelete(id: string){
    this.routesService.deleteRoute(id).subscribe(responseData => {
      window.location.reload();
    })
  }

}
