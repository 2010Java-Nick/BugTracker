import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../../model/post';
import { Injectable } from '@angular/core';
import { Observable, of } from'rxjs';
import { tap } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class PostService {

  baseURL: string = "http://localhost:9090/post";
  
  constructor(private http: HttpClient) { }

  getAllPost(id: number): Observable<Post[]>{
    const url = `${this.baseURL}/${id}`;
    return this.http.get<Post[]>(url);
  }

  addPost(post: Post): Observable<any> {
    return this.http.post(this.baseURL, post);
  }
}
