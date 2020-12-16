import { Component, OnInit } from '@angular/core';
import { Status } from '../../model/status';
import { Priority } from '../../model/priority';
import { UserRole } from '../../model/user-role';

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

  priorities: Priority[] =
    [
      { priorityId: 1, priorityName: 'Low' }, { priorityId: 2, priorityName: 'Medium' },
      { priorityId: 3, priorityName: 'High' }
    ];

  userRoles: UserRole[] =
    [
      { roleId: 1, roleName: 'Basic', power: 1 }, { roleId: 2, roleName: 'Developer', power: 2 },
      { roleId: 3, roleName: 'Manager', power: 3 }
    ]

  submit(form: any) {
    console.log(form.value);
  }

  constructor() { }


  ngOnInit(): void {
  }

}
