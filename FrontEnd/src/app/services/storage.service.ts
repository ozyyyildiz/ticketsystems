import { Injectable } from '@angular/core';
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  private storageSub = new Subject<String>();
  constructor() {}

  watchStorage(): Observable<any> {
    return this.storageSub.asObservable();
  }

  public login(authToken){
    localStorage.setItem("token", authToken);
    this.storageSub.next("changed");
  }

  public logOut(){
    window.localStorage.clear();
    window.sessionStorage.clear();
    this.storageSub.next("changed");
  }
}
