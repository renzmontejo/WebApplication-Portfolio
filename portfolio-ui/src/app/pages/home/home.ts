import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContactService } from '../../services/contact.service';
import { Projects } from '../projects/projects';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, Projects],
  templateUrl: './home.html',
})
export class HomeComponent {
  contactForm = {
    name: '',
    email: '',
    phone: '',
    message: '',
  };

  isSubmitting = false;
  successMessage = '';
  errorMessage = '';

  constructor(private contactService: ContactService) {}

  submitContactForm() {
    this.successMessage = '';
    this.errorMessage = '';

    if (!this.contactForm.name || !this.contactForm.email || !this.contactForm.message) {
      this.errorMessage = 'Please fill in the required fields.';
      return;
    }

    this.isSubmitting = true;

    this.contactService.sendMessage(this.contactForm).subscribe({
      next: () => {
        this.successMessage = 'Message sent successfully.';
        this.contactForm = {
          name: '',
          email: '',
          phone: '',
          message: '',
        };
        this.isSubmitting = false;
      },
      error: (error) => {
        console.error('CONTACT FORM ERROR:', error);
        this.errorMessage = 'Failed to send message.';
        this.isSubmitting = false;
      },
    });
  }
}
