import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface ContactRequest {
  name: string;
  email: string;
  phone: string;
  message: string;
}

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  private apiUrl = `${environment.apiBaseUrl}/api/contact`;

  constructor(private http: HttpClient) {}

  sendMessage(data: ContactRequest): Observable<any> {
    return this.http.post(`${this.apiUrl}/send`, data);
  }
}
