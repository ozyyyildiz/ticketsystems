import {Injectable} from "@angular/core";
import {HttpBackend, HttpClient, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Router} from "@angular/router";
import {UserModel} from "../shared/models/userModel";
import {LoginModel} from "../shared/models/loginModel";

import { JwtHelperService } from '@auth0/angular-jwt';
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseUrl = "http://localhost:8080/authentication";

  private httpClient: HttpClient;

  constructor( handler: HttpBackend) {
    this.httpClient = new HttpClient(handler);
  }

  saveUserDetails(userDetail : UserModel) : Observable<any> {
    return this.httpClient.post(this.baseUrl + "/register", userDetail, httpOptions);
  }

  login(userDetail : LoginModel) : Observable<any> {
    return this.httpClient.post(this.baseUrl + "/login", userDetail, httpOptions);
  }

  isLoggedIn() {
    let jwtHelper = new JwtHelperService();
    let token = localStorage.getItem('token');
    if(!token) {return false;}
    let expirationDate = jwtHelper.getTokenExpirationDate(token);
    let isExpired = jwtHelper.isTokenExpired(token);
    return !isExpired;
  }
}
