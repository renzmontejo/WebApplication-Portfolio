import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
})
export class Dashboard {
  stats = [
    { label: 'Total Messages', value: 0 },
    { label: 'Unread Messages', value: 0 },
    { label: 'Projects', value: 0 },
    { label: 'Meeting Requests', value: 0 },
  ];
}
