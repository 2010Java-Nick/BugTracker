import { HttpClient } from '@angular/common/http';
import { TicketDto } from '../../model/ticket';
import { TicketDisplay } from '../../model/ticketDtoDisplay';
import { Injectable } from '@angular/core';
import { Observable } from'rxjs';
import { CurrentUser } from '../../model/currentUserDto';
@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {

 
  baseURL: string = "http://20.51.254.239:9090/";

  currentUser = JSON.parse(localStorage.getItem('currentUser')!) as CurrentUser;


  constructor(private http: HttpClient) { 
  }

  getTicket(): Observable<TicketDisplay[]> {
    return this.http.get<TicketDisplay[]>(this.baseURL+"ticket")
  }

  getAllTickets(): Observable<TicketDisplay[]> {
    return this.http.get<TicketDisplay[]>(this.baseURL+"tickets")
  }

  getAssignedTickets(): Observable<TicketDisplay[]> {
    return this.http.get<TicketDisplay[]>(this.baseURL + "assigned/"+ this.currentUser.id)
  }

  getOpenerTickets(): Observable<TicketDisplay[]> {
    return this.http.get<TicketDisplay[]>(this.baseURL + "opened/"+ this.currentUser.id)
  }

  addTicket(ticket: TicketDto): Observable<any> {
    return this.http.post(this.baseURL + "ticket", ticket)
  }

  updateTicket(ticketDisplay: TicketDisplay): Observable<any> {
    return this.http.put(this.baseURL + "ticket", ticketDisplay)
  }
}
