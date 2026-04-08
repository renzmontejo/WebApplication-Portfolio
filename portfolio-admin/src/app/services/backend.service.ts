import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Backend } from '../models/backend.model';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private apiUrl = 'http://localhost:8080/api/backends';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Backend[]> {
    return this.http.get<Backend[]>(this.apiUrl);
  }

  create(data: Backend): Observable<Backend> {
    return this.http.post<Backend>(this.apiUrl, data);
  }
}
