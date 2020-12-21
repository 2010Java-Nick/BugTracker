import { Component, OnInit } from '@angular/core';
import { TicketDisplay } from 'src/app/model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service';

@Component({
  selector: 'app-opened',
  templateUrl: './opened.component.html',
  styleUrls: ['./opened.component.css']
})
export class OpenedComponent implements OnInit {

  allTickets!: TicketDisplay[];
  hideme = [] as any;

  constructor(private ticketService: TicketServiceService) { }

  ngOnInit(): void {
      this.ticketService.getOpenerTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
      
  }

}
