import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PostDto } from '../../../model/post';
import { PostService } from '../post.service';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {

  model = new PostDto(1, 1, " ");

  submitted = false;

  constructor(private http: HttpClient, private postService: PostService) { }

  onSubmit() {
    this.submitted = true;
    this.postService.addPost(this.model).subscribe(resp => console.log('Passed'));
  }

  newPost() {
    this.model = new PostDto(1, 1, " ");
  }


}
