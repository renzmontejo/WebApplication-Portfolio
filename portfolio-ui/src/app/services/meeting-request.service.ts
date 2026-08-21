import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {
  MeetingRequest,
  MeetingRequestCreateRequest,
  MeetingRequestStatusRequest,
} from '../models/meeting-request.model';

@Injectable({
  providedIn: 'root',
})
export class MeetingRequestService {
  private apiUrl = `${environment.apiBaseUrl}/api/meeting-requests`;

  constructor(private http: HttpClient) {}

  create(request: MeetingRequestCreateRequest): Observable<MeetingRequest> {
    return this.http.post<MeetingRequest>(this.apiUrl, request);
  }

  getAll(): Observable<MeetingRequest[]> {
    return this.http.get<MeetingRequest[]>(this.apiUrl);
  }

  getById(id: number): Observable<MeetingRequest> {
    return this.http.get<MeetingRequest>(`${this.apiUrl}/${id}`);
  }

  updateStatus(id: number, request: MeetingRequestStatusRequest): Observable<MeetingRequest> {
    return this.http.patch<MeetingRequest>(`${this.apiUrl}/${id}/status`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}