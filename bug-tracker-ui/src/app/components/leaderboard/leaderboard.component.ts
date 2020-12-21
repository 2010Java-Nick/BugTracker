import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/employee';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
 
   employees!: Employee[];

  constructor(private userService: UserService) { 
  
    this.userService = userService;
  }

  ngOnInit(): void {
     this.userService.viewLeaderBoard().subscribe(response => this.employees = response);
  }



}
