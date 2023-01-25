import { Component } from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserService} from "../../../../services/user.service";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent {
  defRole = '2';

  constructor(private userService: UserService) {
  }

  onSubmit(form: NgForm){
    this.userService.createUser(form.value).subscribe(responseData => {
      console.log(responseData);
    })
  }

}
