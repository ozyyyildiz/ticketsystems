import {Component, OnInit} from '@angular/core';
import {LoginModel} from "../../../shared/models/loginModel";
import {UserModel} from "../../../shared/models/userModel";
import {Router} from "@angular/router";
import {AdminService} from "../../../services/admin.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  private userDetail = {} as UserModel;

  constructor(private adminService : AdminService, private router : Router) { }

  ngOnInit() {
  }

  // create the form object.
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

      this.adminService.saveUserDetails(this.userDetail).subscribe(response => {
        let result = response.json();
          if(result > 0) {
            console.log(response);
            console.log(result);
            this.router.navigate(['/']);
          } else {
            console.log("Alert")
            alert("error occur while registring User. please try after sometime.")
          }
      })
    }
  }
}
