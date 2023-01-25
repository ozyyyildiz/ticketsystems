import { Component } from '@angular/core';
import {AdminService} from "../../../services/admin.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginModel} from "../../../shared/models/loginModel";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginDetail = {} as LoginModel;

  constructor(private adminService : AdminService, private router : Router) { }

  ngOnInit() {
    if((this.adminService.isLoggedIn()) ) {
      this.router.navigate(['/' , localStorage.getItem('id')]);
    } else {
      this.router.navigate(['/login']);
    }
  }
  form = new FormGroup({
    username : new FormControl('' , Validators.required),
    password : new FormControl('' , Validators.required)
  });

  Login(LoginInformation) {
    this.loginDetail.username = this.form.value.username
    this.loginDetail.password = this.form.value.password

    this.adminService.login(this.loginDetail).subscribe(response => {
      console.log(response);
      if(response) {
        localStorage.setItem("token" , JSON.stringify(response.authToken));
        console.log(response);
        this.router.navigateByUrl("/routes");
      }else {
        alert("please register before login Or Invalid combination of Username and password");
      }});
  }
}
