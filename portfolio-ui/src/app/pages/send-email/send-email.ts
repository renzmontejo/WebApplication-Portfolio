import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-send-email',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './send-email.html'
})
export class SendEmail {
  emailForm = {
    fullName: '',
    email: '',
    subject: '',
    message: ''
  };

  submitEmailForm(): void {
    console.log('Email form submitted:', this.emailForm);
    alert('Your message has been submitted.');

    this.emailForm = {
      fullName: '',
      email: '',
      subject: '',
      message: ''
    };
  }
}
