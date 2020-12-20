
import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from './ticket/ticket-service.service';
import { TicketDto } from './ticket';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { from, Observable } from 'rxjs';
import { Component } from '@angular/core';
import { faBug } from '@fortawesome/free-solid-svg-icons';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'bug-tracker-ui';
  

  ticks!: TicketDto[];
  ticket!: TicketDto;

  readonly ROOT_URL = 'http://localhost:9090/';

  boards!: Observable<any>
  newBoards!: Observable<any> 
  constructor(private http: HttpClient, private ticketService: TicketServiceService) {

  }

  ngOnInit() {

  }

  addTicket() {
    this.ticketService.addTicket(this.ticket)
      .subscribe(ticket => this.ticks.push(ticket));
  }

  getBoards() {
    this.boards = this.http.get(this.ROOT_URL + 'leaderboard');
  }

  

  faBug = faBug;

}
