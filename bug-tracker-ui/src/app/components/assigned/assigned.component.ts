import { Component, OnInit, Input } from '@angular/core';
import { TicketDisplay } from '../../model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service';
import { PostService } from '../post/post.service';
import { ViewPostsComponent } from '../post/view-posts/view-posts.component'

@Component({
  selector: 'app-assigned',
  templateUrl: './assigned.component.html',
  styleUrls: ['./assigned.component.css']
})
export class AssignedComponent implements OnInit {


  allTickets!: TicketDisplay[];
  hideme = [] as any;
  
  
  
  constructor(private ticketService: TicketServiceService,
              private postService: PostService) { }

    ngOnInit(): void {
      this.ticketService.getAssignedTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
  }

  

}
