import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../../services/user.service";
import {ActivatedRoute} from "@angular/router";
import {UserModel} from "../../../../shared/models/userModel";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit{
  id = this.activatedRoute.snapshot.params['uid'];
  loadedUser: UserModel;

  constructor(private userService: UserService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.userService.getSingleUser(this.id).subscribe(user=>{
      this.loadedUser = user;
    })
  }

  onUpdate(form: NgForm){
    this.loadedUser = form.value;
    this.loadedUser.id = this.id;
    this.userService.updateUser(this.loadedUser).subscribe(responseData => {
      window.location.reload();
    })
  }

}
