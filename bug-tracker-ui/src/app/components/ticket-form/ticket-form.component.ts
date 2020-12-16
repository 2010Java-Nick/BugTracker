import { Component, OnInit } from '@angular/core';
import { Status } from '../../model/status';

@Component({
  selector: 'app-ticket-form',
  templateUrl: './ticket-form.component.html',
  styleUrls: ['./ticket-form.component.css']
})
export class TicketFormComponent implements OnInit {

  statuses: Status[] =
    [{ statusId: 1, statusName: 'Opened' }, { statusId: 2, statusName: 'Resolved-Fixed' },
    { statusId: 3, statusName: 'Resolved-Wont-Fix' }, { statusId: 4, statusName: 'Resolved-Postponed' },
    { statusId: 5, statusName: 'Resolved-Not-Reproducible' }, { statusId: 6, statusName: 'Resolved-Duplicate' },
    { statusId: 7, statusName: 'Resolved-By-Design' }, { statusId: 8, statusName: 'Closed' }

    ];

  constructor() { }

  ngOnInit(): void {
  }

}
