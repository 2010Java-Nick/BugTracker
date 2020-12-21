import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Status } from 'src/app/model/status';
import { TicketDto } from 'src/app/model/ticket';
import { TicketDisplay } from 'src/app/model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service';

@Component({
  selector: 'app-opened',
  templateUrl: './opened.component.html',
  styleUrls: ['./opened.component.css']
})
export class OpenedComponent implements OnInit {

  priority = ['Low', 'Medium', 'High'];
  values = ['1', '2', '3'];

  allTickets!: TicketDisplay[];
  hideme = [] as any;

  ticketDisplay!: TicketDisplay;

  statuses: Status[] = [{statusId: 1, statusName: 'Opened'}, {statusId: 2, statusName: 'Resolved-Fixed'},
{statusId: 3, statusName: "Resolved-Won't-Fix"}, {statusId: 4, statusName: "Resolved-Postponed"},
{statusId: 5, statusName: "Resolved-Not-Reproducible"}, {statusId: 6, statusName: 'Resolved-Duplicate'},
{statusId: 7, statusName: 'Resolved-By-Design'}, {statusId: 8, statusName: 'Closed'}];
  
  submitted = true;



  

  constructor(private ticketService: TicketServiceService) { 
  }

  ngOnInit(): void {
      this.ticketService.getOpenerTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
  }

  updateTicket(ticketDisplay: TicketDisplay): void {
    this.ticketService.updateTicket(ticketDisplay).subscribe(data => {this.ticketDisplay = data, console.log(this.ticketDisplay)});
  }

}
