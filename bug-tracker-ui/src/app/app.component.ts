<<<<<<< HEAD

import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from './ticket/ticket-service.service';
import { TicketDto } from '../app/model/ticketDto';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { from, Observable } from 'rxjs';
import { faBug } from '@fortawesome/free-solid-svg-icons';
=======
import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from './components/ticket/ticket-service.service';
import { TicketDto } from './model/ticket';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { from, Observable } from 'rxjs';
import { Router } from '@angular/router';

import { AuthenticationService } from './services/login.service';
import { Employee } from './model/employee';
>>>>>>> Tests



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'bug-tracker-ui';
<<<<<<< HEAD

=======
  currentUser!: Employee;
>>>>>>> Tests

  ticks!: TicketDto[];
  ticket!: TicketDto;

  readonly ROOT_URL = 'http://localhost:9090/';

  boards!: Observable<any>
  newBoards!: Observable<any>
<<<<<<< HEAD
  constructor(private http: HttpClient, private ticketService: TicketServiceService) {

=======
  constructor(private http: HttpClient,
    private ticketService: TicketServiceService,
    private router: Router,
    private authenticationService: AuthenticationService) {
    this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
>>>>>>> Tests
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

<<<<<<< HEAD


  faBug = faBug;

=======
  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }

>>>>>>> Tests
}
