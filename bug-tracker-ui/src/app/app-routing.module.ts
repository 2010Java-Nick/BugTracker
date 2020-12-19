import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketFormComponent } from './components/ticket-form/ticket-form.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { OpenedComponent } from './components/opened/opened.component';
import { AssignedComponent } from './components/assigned/assigned.component';

const routes: Routes = [
  { path: 'ticket-form', component: TicketFormComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'opened', component: OpenedComponent },
  { path: 'assigned', component: AssignedComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
