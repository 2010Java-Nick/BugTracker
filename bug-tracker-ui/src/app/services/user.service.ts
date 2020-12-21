import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Employee } from '../model/employee';

@Injectable({ providedIn: 'root' })
export class UserService {

    baseURL: string = "http://localhost:9090/";

    constructor(private http: HttpClient) { }

  
    viewLeaderBoard() {
        return this.http.get<Employee[]>(this.baseURL+"leaderboard");
    }
}