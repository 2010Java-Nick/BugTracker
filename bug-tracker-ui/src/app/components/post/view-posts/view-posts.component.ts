import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Post } from '../../../model/post';
import { PostService } from '../post.service';


@Component({
  selector: 'app-view-posts',
  templateUrl: './view-posts.component.html',
  styleUrls: ['./view-posts.component.css']
})
export class ViewPostsComponent implements OnInit {
    @Input() idNumber!: number


  posts!: Post[]

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
  ) { }

  ngOnInit(): void {
    this.getAllPost();
  }



  getAllPost(): void {
  
    this.postService.getAllPost(this.idNumber).subscribe( data => this.posts = data);
  }

}
