import { Component, OnInit } from '@angular/core';
import { TicketDisplay } from '../../model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service'

@Component({
  selector: 'app-assigned',
  templateUrl: './assigned.component.html',
  styleUrls: ['./assigned.component.css']
})
export class AssignedComponent implements OnInit {

  allTickets!: TicketDisplay[];

  constructor(private ticketService: TicketServiceService) { }

  ngOnInit(): void {
      this.ticketService.getAssignedTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
      
  }

}
