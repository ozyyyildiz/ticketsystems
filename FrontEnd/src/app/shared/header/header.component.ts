import {Component} from "@angular/core";
import {StorageService} from "../../services/storage.service";
import {Router} from "@angular/router";
import {JwtHelperService} from "@auth0/angular-jwt";


@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ['header.component.css']
})
export class HeaderComponent{
  user: boolean;
  admin: boolean = false;

  username:string;

  constructor(private storageService: StorageService, private router: Router, private jwtHelper: JwtHelperService) {
  }

  ngOnInit() {
    this.storage();
    this.storageService.watchStorage().subscribe((data:string) => {
      this.storage();
    })
  }

  logOut(){
    this.storageService.logOut();
    this.admin = false;
    this.router.navigate(['/login']);
  }

  private storage(){
    let authToken = localStorage.getItem("token")
    if(authToken){
      this.user = true;
      let decodedToken = this.jwtHelper.decodeToken(authToken);
      decodedToken.roles=="Admin" ? this.admin = true : this.admin=false;
      this.username = decodedToken.sub;
    }else{
      this.user = false
    }
  }
}
