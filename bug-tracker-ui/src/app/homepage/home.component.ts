import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { Employee } from '../model/employee';
import { AuthenticationService } from '../services/login.service';
import { UserService } from '../services/user.service';

@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    loading = false;
    employees!: Employee[];

    constructor(private userService: UserService) { }

    ngOnInit() {
        this.loading = true;
        this.userService.getAll().pipe(first()).subscribe(employees => {
            this.loading = false;
            this.employees = employees;
        });
    }
}