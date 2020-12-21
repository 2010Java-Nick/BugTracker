import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketFormComponent } from './components/ticket/ticket-form/ticket-form.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { OpenedComponent } from './components/opened/opened.component';
import { AssignedComponent } from './components/assigned/assigned.component';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { ErrorInterceptor } from './helpers/error.interceptor';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import { LoginComponent } from './components/login/login.component';
import { ViewPostsComponent } from './components/post/view-posts/view-posts.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { PostFormComponent } from './components/post/post-form/post-form.component'; 


@NgModule({
  declarations: [
    AppComponent,
    TicketFormComponent,
    DashboardComponent,
    OpenedComponent,
    AssignedComponent,
    LoginComponent,
    ViewPostsComponent,
    LeaderboardComponent,
    PostFormComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FontAwesomeModule,
    ReactiveFormsModule

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
