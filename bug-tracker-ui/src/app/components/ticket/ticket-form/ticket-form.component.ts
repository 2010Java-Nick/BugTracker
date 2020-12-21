import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'src/app/model/currentUserDto';
import { TicketDto } from '../../../model/ticket';
import { TicketServiceService } from '../ticket-service.service';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent implements OnInit {

  priority = ['Low', 'Medium', 'High'];
  values = ['1', '2', '3'];

  currentUser = JSON.parse(localStorage.getItem('currentUser')!) as CurrentUser;

  empId = this.currentUser.id;

  model = new TicketDto(this.empId, "", 1, 1, "");

  submitted = false;



  constructor(private http: HttpClient, private ticketService: TicketServiceService) { }
  ngOnInit(): void {
    
  }

  onSubmit() {
    this.ticketService.addTicket(this.model).subscribe(resp => console.log('Passed'));
  }

  newTicket() {
    this.model = new TicketDto(0, '', 0, 0, '');
  }

  onConfirm(){
    this.submitted = true;
  }

}
