import { Component } from '@angular/core';
import {RoutesService} from "../../../../services/routes.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-admin-routes-create',
  templateUrl: './admin-routes-create.component.html',
  styleUrls: ['./admin-routes-create.component.css']
})
export class AdminRoutesCreateComponent {

  constructor(private routesService: RoutesService) {
  }

  onSubmit(form: NgForm){
    this.routesService.saveRoute(form.value).subscribe(responseData => {
      console.log(responseData);
    })
  }

}
