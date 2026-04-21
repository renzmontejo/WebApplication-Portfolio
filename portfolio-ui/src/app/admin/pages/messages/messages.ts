import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMessageService } from '../../services/admin-message.service';

@Component({
  selector: 'app-admin-messages',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './messages.html',
})
export class Messages implements OnInit {
  messages: any[] = [];
  selectedMessage: any = null;
  isLoading = false;

  constructor(private messageService: AdminMessageService) {}

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(): void {
    this.isLoading = true;
    this.messageService.getAll().subscribe({
      next: (data) => {
        this.messages = data;
        this.isLoading = false;
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }

  viewMessage(message: any): void {
    this.selectedMessage = message;
  }

  markAsRead(id: number): void {
    this.messageService.markAsRead(id).subscribe({
      next: () => {
        this.loadMessages();
        if (this.selectedMessage?.id === id) {
          this.selectedMessage.status = 'READ';
        }
      },
    });
  }
}
