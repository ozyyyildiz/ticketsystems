import { Component } from '@angular/core';
import {AuthService} from "../../../services/auth.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoginModel} from "../../../models/loginModel";
import {StorageService} from "../../../services/storage.service";
import {JwtHelperService} from "@auth0/angular-jwt";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginDetail = {} as LoginModel;
  message: string = null;

  constructor(private authService : AuthService, private router : Router, private storageService: StorageService, private jwtHelper: JwtHelperService) { }

  ngOnInit() {

  }
  form = new FormGroup({
    username : new FormControl('' , Validators.required),
    password : new FormControl('' , Validators.required)
  });

  Login(LoginInformation) {
    this.loginDetail.username = this.form.value.username
    this.loginDetail.password = this.form.value.password
    this.authService.login(this.loginDetail).subscribe(response => {
      if(response) {
        this.storageService.login(response.authToken);
        this.router.navigateByUrl("/routes");
      }else {
        this.message = "Kullanıcı adı ya da şifre hatalı";
      }});
  }
}
