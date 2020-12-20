import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketFormComponent } from './components/ticket/ticket-form/ticket-form.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { OpenedComponent } from './components/opened/opened.component';
import { AssignedComponent } from './components/assigned/assigned.component';

import { HomeComponent } from './homepage/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './helpers/auth.guard';

const routes: Routes = [
  { path: 'ticket-form', component: TicketFormComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'opened', component: OpenedComponent },
  { path: 'assigned', component: AssignedComponent },
  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];
export const appRoutingModule = RouterModule.forRoot(routes);
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
