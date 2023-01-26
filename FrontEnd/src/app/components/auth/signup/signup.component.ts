import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../../shared/models/userModel";
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  private userDetail = {} as UserModel;
  error: string = null;

  constructor(private authService : AuthService, private router : Router) { }

  ngOnInit() {
  }

  form = new FormGroup({
    username : new FormControl('' , Validators.required),
    email : new FormControl('' , Validators.required),
    password : new FormControl('' , Validators.required),
    confirmPassword : new FormControl('' , Validators.required)
  });

  UserForm(UserInformation)
  {
    let pass = this.form.value.password;
    let confirmPass = this.form.value.confirmPassword;
    if(pass == confirmPass)
    {
      this.userDetail.userName = this.form.value.username;
      this.userDetail.email = this.form.value.email;
      this.userDetail.password = this.form.value.password;
      this.userDetail.userRole = "2";

      this.authService.saveUserDetails(this.userDetail).subscribe(response => {
          if(response.status) {
            this.router.navigate(['/login']);
          } else {
            this.error = response.message;
          }
      })
    }
  }
}
