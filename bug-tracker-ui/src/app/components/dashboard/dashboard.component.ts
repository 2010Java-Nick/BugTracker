import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from '.././ticket/ticket-service.service';
import { TicketDisplay } from '../../model/ticketDtoDisplay';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  allTickets!: TicketDisplay[];
  hideme = [] as any;

  constructor(private ticketService: TicketServiceService) { }

  ngOnInit(): void {
      this.ticketService.getAllTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
      
  }

}
