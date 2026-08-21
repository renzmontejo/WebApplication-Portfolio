import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Experience, ExperienceRequest } from '../models/experience.model';

@Injectable({
  providedIn: 'root',
})
export class ExperienceService {
  private apiUrl = `${environment.apiBaseUrl}/api/experiences`;

  constructor(private http: HttpClient) {}

  create(request: ExperienceRequest): Observable<Experience> {
    return this.http.post<Experience>(this.apiUrl, request);
  }

  getAll(): Observable<Experience[]> {
    return this.http.get<Experience[]>(this.apiUrl);
  }

  getById(id: number): Observable<Experience> {
    return this.http.get<Experience>(`${this.apiUrl}/${id}`);
  }

  update(id: number, request: ExperienceRequest): Observable<Experience> {
    return this.http.put<Experience>(`${this.apiUrl}/${id}`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}