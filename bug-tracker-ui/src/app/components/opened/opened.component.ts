import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Status } from 'src/app/model/status';
import { TicketDto } from 'src/app/model/ticket';
import { TicketDisplay } from 'src/app/model/ticketDtoDisplay';
import { PostService } from '../post/post.service';
import { TicketServiceService } from '../ticket/ticket-service.service';

@Component({
  selector: 'app-opened',
  templateUrl: './opened.component.html',
  styleUrls: ['./opened.component.css']
})
export class OpenedComponent implements OnInit {

  allTickets!: TicketDisplay[];
  hideme = [] as any;
  hideedit = [] as any;
  
  
  
  constructor(private ticketService: TicketServiceService,
              private postService: PostService) { }

    ngOnInit(): void {
      this.ticketService.getAssignedTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
  }

}
