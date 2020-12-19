import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketFormComponent } from './components/ticket-form/ticket-form.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { OpenedComponent } from './components/opened/opened.component';
import { AssignedComponent } from './components/assigned/assigned.component';

@NgModule({
  declarations: [
    AppComponent,
    TicketFormComponent,
    DashboardComponent,
    OpenedComponent,
    AssignedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
