import {Component, OnInit} from '@angular/core';
import {SeatService} from "../../../services/seat.service";
import {SeatResponseModel} from "../../../models/seatResponseModel";

@Component({
  selector: 'app-seat-list',
  templateUrl: './seat-list.component.html',
  styleUrls: ['./seat-list.component.css']
})
export class AdminSeatListComponent implements OnInit{

  loadedSeats: SeatResponseModel[] = []

  filterData: string;

  constructor(private seatService: SeatService) {
  }

  ngOnInit(): void {
    this.seatService.getAllEmptySeats().subscribe(responseData => {
      this.loadedSeats = responseData;
    })
  }

}
