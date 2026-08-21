import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PortfolioService, PortfolioServiceRequest } from '../models/portfolio-service.model';

@Injectable({
  providedIn: 'root',
})
export class PortfolioServiceService {
  private apiUrl = `${environment.apiBaseUrl}/api/services`;

  constructor(private http: HttpClient) {}

  create(request: PortfolioServiceRequest): Observable<PortfolioService> {
    return this.http.post<PortfolioService>(this.apiUrl, request);
  }

  getAll(): Observable<PortfolioService[]> {
    return this.http.get<PortfolioService[]>(this.apiUrl);
  }

  getById(id: number): Observable<PortfolioService> {
    return this.http.get<PortfolioService>(`${this.apiUrl}/${id}`);
  }

  update(id: number, request: PortfolioServiceRequest): Observable<PortfolioService> {
    return this.http.put<PortfolioService>(`${this.apiUrl}/${id}`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}