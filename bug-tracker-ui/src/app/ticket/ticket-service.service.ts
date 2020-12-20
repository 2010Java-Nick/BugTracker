import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TicketDto } from '../../app/model/ticketDto';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {

  baseURL: string = "http://localhost:9090/ticket";

  constructor(private http: HttpClient) {
  }

  getTicket(): Observable<TicketDto[]> {
    return this.http.get<TicketDto[]>(this.baseURL)
  }

  addTicket(ticket: TicketDto): Observable<any> {
    const headers = { 'content-type': 'application/json' }
    //const body = JSON.stringify(ticket);
    return this.http.post(this.baseURL, ticket, { 'headers': headers })
  }
}
