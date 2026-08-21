import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {
  ContactMessage,
  ContactMessageCreateRequest,
  ContactMessageStatusRequest,
} from '../models/contact-message.model';

@Injectable({
  providedIn: 'root',
})
export class ContactMessageService {
  private apiUrl = `${environment.apiBaseUrl}/api/contact-messages`;

  constructor(private http: HttpClient) {}

  create(request: ContactMessageCreateRequest): Observable<ContactMessage> {
    return this.http.post<ContactMessage>(this.apiUrl, request);
  }

  getAll(): Observable<ContactMessage[]> {
    return this.http.get<ContactMessage[]>(this.apiUrl);
  }

  getById(id: number): Observable<ContactMessage> {
    return this.http.get<ContactMessage>(`${this.apiUrl}/${id}`);
  }

  updateStatus(id: number, request: ContactMessageStatusRequest): Observable<ContactMessage> {
    return this.http.patch<ContactMessage>(`${this.apiUrl}/${id}/status`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}