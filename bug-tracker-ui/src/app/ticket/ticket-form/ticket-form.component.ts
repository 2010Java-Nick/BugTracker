import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { TicketDto } from '../../ticket';
import { TicketServiceService } from '../ticket-service.service';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent {

  priority = ['Low', 'Medium', 'High'];
  values = ['1', '2', '3'];

  model = new TicketDto(1, " ", 1, 1, " ");

  submitted = false;

  

  constructor(private http: HttpClient, private ticketService: TicketServiceService) { }

  onSubmit() { 
    this.submitted = true; 
    this.http.post("http://localhost:9090/ticket", this.model).subscribe(resp => console.log('Passed'));
  }
  
  newTicket() {
    this.model = new TicketDto(0, '', 0, 0, '');
  }


}
