import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../../model/post';
import { PostService } from '../post.service';
import { CurrentUser } from 'src/app/model/currentUserDto';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent  implements OnInit{

  @Input() ticketId!: number

  currentUser = JSON.parse(localStorage.getItem('currentUser')!) as CurrentUser;

  empId = this.currentUser.id;
  
  model = new Post(this.ticketId, this.empId, "", "");
  
  submitted = false;

  constructor(private http: HttpClient, private postService: PostService) { }
  
  ngOnInit(): void {
    console.log(this.ticketId)
  }

  onSubmit() {

    this.postService.addPost(this.model).subscribe(resp => console.log('Passed'));
  }

  newPost() {
    this.model = new Post(this.ticketId, this.empId, "", "");
  }

  onConfirm(){
    this.submitted = true;
  }

}
