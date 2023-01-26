import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterOutlet} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {TableFilterPipe} from "./pipes/table-filter.pipe";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  imports: [
    CommonModule,
    RouterOutlet,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  declarations: [
    TableFilterPipe
  ],
  exports: [
    CommonModule,
    RouterOutlet,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TableFilterPipe
  ]
})
export class SharedModule{}
