import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Frontend } from '../models/frontend.model';

@Injectable({
  providedIn: 'root'
})
export class FrontendService {
  private apiUrl = 'http://localhost:8080/api/frontends';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Frontend[]> {
    return this.http.get<Frontend[]>(this.apiUrl);
  }

  create(data: Frontend): Observable<Frontend> {
    return this.http.post<Frontend>(this.apiUrl, data);
  }
}
