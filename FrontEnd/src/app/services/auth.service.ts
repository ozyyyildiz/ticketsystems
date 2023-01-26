import {Injectable} from "@angular/core";
import {HttpBackend, HttpClient, HttpHeaders} from "@angular/common/http";
import {UserModel} from "../models/userModel";
import {LoginModel} from "../models/loginModel";

import {Observable} from "rxjs";
import {JwtHelperService} from "@auth0/angular-jwt";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = "http://localhost:8080/authentication";

  private httpClient: HttpClient;

  constructor( handler: HttpBackend, public jwtHelper: JwtHelperService) {
    this.httpClient = new HttpClient(handler);
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !this.jwtHelper.isTokenExpired(token);
  }

  public isAdmin(): boolean{
    const token = localStorage.getItem('token')
    if(token){
      let conToken = this.jwtHelper.decodeToken(token)
      if(conToken.roles == "Admin"){
        return true;
      }else {
        return false;
      }
    }
    return false;
  }

  saveUserDetails(userDetail : UserModel) : Observable<any> {
    return this.httpClient.post(this.baseUrl + "/register", userDetail, httpOptions);
  }

  login(userDetail : LoginModel) : Observable<any> {
    return this.httpClient.post(this.baseUrl + "/login", userDetail, httpOptions);
  }
}
