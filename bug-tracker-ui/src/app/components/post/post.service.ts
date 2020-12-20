import { HttpClient } from '@angular/common/http';
import { PostDto } from '../../model/post';
import { Injectable } from '@angular/core';
import { Observable } from'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PostService {

  baseURL: string = "http://localhost:9090/post";
  
  constructor(private http: HttpClient) { }

  getPost(): Observable<PostDto[]>{
    return this.http.get<PostDto[]>(this.baseURL);
  }

  addPost(post: PostDto): Observable<any> {
    return this.http.post(this.baseURL, post);
  }
}
