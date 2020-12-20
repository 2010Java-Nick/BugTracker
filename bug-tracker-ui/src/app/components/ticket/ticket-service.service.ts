import { HttpClient } from '@angular/common/http';
import { TicketDto } from '../../model/ticket';
import { Injectable } from '@angular/core';
import { Observable } from'rxjs';
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
    return this.http.post(this.baseURL, ticket)
  }
}
