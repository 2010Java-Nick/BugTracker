import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../../model/post';
import { PostService } from '../post.service';
import { CurrentUser } from 'src/app/model/currentUserDto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent  implements OnInit{

  @Input() ticketIds !: number;

  currentUser = JSON.parse(localStorage.getItem('currentUser')!) as CurrentUser;

  empId = this.currentUser.id;
  
  model = new Post(this.ticketIds, this.empId, "", "");
  
  submitted = false;
  

  constructor(private http: HttpClient, 
              private postService: PostService,
              private router: Router) { }
  
  ngOnInit(): void {
    this.model = new Post(this.ticketIds, this.empId, "", "");
  }

  onSubmit() {

    this.postService.addPost(this.model).subscribe(resp => console.log('Passed'));
    this.reloadComponent();
    
  }

  newPost() {
    this.model = new Post(this.ticketIds, this.empId, "", "");
  }

  onConfirm(){
    this.submitted = true;
  }

  reloadComponent(){
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/same-route']);
  }

}
