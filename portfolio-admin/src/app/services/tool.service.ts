import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tool } from '../models/tool.model';

@Injectable({
  providedIn: 'root'
})
export class ToolService {
  private apiUrl = 'http://localhost:8080/api/tools';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Tool[]> {
    return this.http.get<Tool[]>(this.apiUrl);
  }

  create(data: Tool): Observable<Tool> {
    return this.http.post<Tool>(this.apiUrl, data);
  }
}
