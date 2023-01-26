import {Component, OnInit} from '@angular/core';
import {UserModel} from "../../../../models/userModel";
import {UserService} from "../../../../services/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit{

  loadedUsers: UserModel[] = [];
  filterData: string;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(users=>{
      this.loadedUsers = users;
    })
  }

  onDeleteUser(id: string){
    this.userService.deleteUser(id).subscribe(responseData=> {
      window.location.reload();
    })
  }
}
