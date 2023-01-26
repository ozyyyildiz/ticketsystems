import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {UserModel} from "../shared/models/userModel";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  getAllUsers(){
    return this.http.get(this.baseUrl + '/')
      .pipe(map((responseData:UserModel)=>{
        const usersArray: UserModel[] = [];
        for(const key in responseData){
          usersArray.push({ ...responseData[key] });
        }
        return usersArray;
      }));
  }

  getSingleUser(id: string){
    return this.http.get<UserModel>(this.baseUrl + '/user/' + id);
  }

  createUser(userData: UserModel){
    return this.http.post(this.baseUrl + '/createUser', userData);
  }

  updateUser(userData: UserModel){
    return this.http.post(this.baseUrl + '/update', userData);
  }

  deleteUser(id: string){
    return this.http.post(this.baseUrl + '/delete' + id, '');
  }
}
