import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { GroupedTechnologies, Technology, TechnologyRequest } from '../models/technology.model';

@Injectable({
  providedIn: 'root',
})
export class TechnologyService {
  private apiUrl = `${environment.apiBaseUrl}/api/technologies`;

  constructor(private http: HttpClient) {}

  create(request: TechnologyRequest): Observable<Technology> {
    return this.http.post<Technology>(this.apiUrl, request);
  }

  getAll(): Observable<Technology[]> {
    return this.http.get<Technology[]>(this.apiUrl);
  }

  getGrouped(): Observable<GroupedTechnologies> {
    return this.http.get<GroupedTechnologies>(`${this.apiUrl}/grouped`);
  }

  getById(id: number): Observable<Technology> {
    return this.http.get<Technology>(`${this.apiUrl}/${id}`);
  }

  update(id: number, request: TechnologyRequest): Observable<Technology> {
    return this.http.put<Technology>(`${this.apiUrl}/${id}`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}