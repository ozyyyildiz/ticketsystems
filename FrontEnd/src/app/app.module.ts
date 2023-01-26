import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from "./components/shared/header/header.component";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import { ReactiveFormsModule } from "@angular/forms";
import { SignupComponent } from './components/auth/signup/signup.component';
import { LoginComponent } from './components/auth/login/login.component';
import {AuthInterceptorService} from "./services/auth-interceptor.service";
import {JWT_OPTIONS, JwtHelperService} from "@auth0/angular-jwt";
import { AdminModule } from "./components/admin/admin.module";
import { TicketsModule } from "./components/tickets/tickets.module";
import { RoutesModule } from "./components/routes/routes.module";
import { SharedModule } from "./shared.module";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SignupComponent,
    LoginComponent
  ],
  imports: [
    ReactiveFormsModule,
    AdminModule,
    TicketsModule,
    RoutesModule,
    SharedModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
