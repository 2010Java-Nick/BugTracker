import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { TicketServiceService } from './components/ticket/ticket-service.service';
import { TicketDto } from './model/ticket';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http'
import { from, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { faBug } from '@fortawesome/free-solid-svg-icons';
import { AuthenticationService } from './services/login.service';
import { Employee } from './model/employee';
import { LoginComponent } from './components/login/login.component';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  title = 'bug-tracker-ui';
  currentUser!: Employee;
  faBug = faBug;
  isLoggedOut = false;

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

  ngAfterViewInit() {
  
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
    this.isLoggedOut = true;

  }

}
