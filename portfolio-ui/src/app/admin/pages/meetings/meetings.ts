import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMeetingService } from '../../services/admin-meeting.service';

@Component({
  selector: 'app-admin-meetings',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './meetings.html',
})
export class Meetings implements OnInit {
  meetings: any[] = [];
  selectedMeeting: any = null;
  isLoading = false;

  constructor(private meetingService: AdminMeetingService) {}

  ngOnInit(): void {
    this.loadMeetings();
  }

  loadMeetings(): void {
    this.isLoading = true;
    this.meetingService.getAll().subscribe({
      next: (data) => {
        this.meetings = data;
        this.isLoading = false;
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }

  viewMeeting(meeting: any): void {
    this.selectedMeeting = meeting;
  }

  markAsRead(id: number): void {
    this.meetingService.markAsRead(id).subscribe({
      next: () => {
        this.loadMeetings();
        if (this.selectedMeeting?.id === id) {
          this.selectedMeeting.isRead = true;
          this.selectedMeeting.status = 'READ';
        }
      },
    });
  }
}
