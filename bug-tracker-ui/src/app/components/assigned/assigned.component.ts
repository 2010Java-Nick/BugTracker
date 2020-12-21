import { Component, OnInit, Input } from '@angular/core';
import { TicketDisplay } from '../../model/ticketDtoDisplay';
import { TicketServiceService } from '../ticket/ticket-service.service';
import { PostService } from '../post/post.service';
import { ViewPostsComponent } from '../post/view-posts/view-posts.component'
import { Status } from 'src/app/model/status';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assigned',
  templateUrl: './assigned.component.html',
  styleUrls: ['./assigned.component.css']
})
export class AssignedComponent implements OnInit {

  priority = ['Low', 'Medium', 'High'];
  values = ['1', '2', '3'];

  allTickets!: TicketDisplay[];
  hideme = [] as any;
  hideedit = [] as any;
  
  ticketDisplay!: TicketDisplay;

statuses: Status[] = [{statusId: 1, statusName: 'Opened'}, {statusId: 2, statusName: 'Resolved-Fixed'},
{statusId: 3, statusName: "Resolved-Won't-Fix"}, {statusId: 4, statusName: "Resolved-Postponed"},
{statusId: 5, statusName: "Resolved-Not-Reproducible"}, {statusId: 6, statusName: 'Resolved-Duplicate'},
{statusId: 7, statusName: 'Resolved-By-Design'}, {statusId: 8, statusName: 'Closed'}];
  
  submitted = true;



  

  constructor(private ticketService: TicketServiceService, private router: Router) { 
  }

  ngOnInit(): void {
      this.ticketService.getAssignedTickets().subscribe(data => {this.allTickets = data, console.log(this.allTickets)});
  }

  updateTicket(ticketDisplay: TicketDisplay): void {
    this.ticketService.updateTicket(ticketDisplay).subscribe(data => {this.ticketDisplay = data, console.log(this.ticketDisplay)});
    this.reloadComponent();
  }

  reloadComponent(){
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/same-route']);
  }
}
