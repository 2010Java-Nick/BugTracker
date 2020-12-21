import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { TicketDto } from 'src/app/model/ticket';
import { TicketDisplay } from 'src/app/model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service';

@Component({
  selector: 'app-opened',
  templateUrl: './opened.component.html',
  styleUrls: ['./opened.component.css']
})
export class OpenedComponent implements OnInit {

  allTickets!: TicketDisplay[];

  ticketDisplay!: TicketDisplay;

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
