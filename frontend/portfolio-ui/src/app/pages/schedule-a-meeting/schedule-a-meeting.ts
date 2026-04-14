import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-schedule-a-meeting',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './schedule-a-meeting.html'
})
export class ScheduleAMeeting {
  meetingForm = {
    fullName: '',
    email: '',
    meetingType: '',
    preferredDate: '',
    message: ''
  };

  submitMeetingRequest(): void {
    console.log('Meeting request submitted:', this.meetingForm);
    alert('Meeting request submitted successfully.');

    this.meetingForm = {
      fullName: '',
      email: '',
      meetingType: '',
      preferredDate: '',
      message: ''
    };
  }
}
