import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from './components/ticket/ticket-service.service';
import { TicketDto } from './model/ticket';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { from, Observable } from 'rxjs';
import { Router } from '@angular/router';

import { AuthenticationService } from './services/login.service';
import { Employee } from './model/employee';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'bug-tracker-ui';
  currentUser!: Employee;

  ticks!: TicketDto[];
  ticket!: TicketDto;

  readonly ROOT_URL = 'http://localhost:9090/';

  boards!: Observable<any>
  newBoards!: Observable<any> 
  constructor(private http: HttpClient, 
    private ticketService: TicketServiceService,
    private router: Router,
    private authenticationService: AuthenticationService) {
      this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
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

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
}

}
