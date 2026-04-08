import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { AppUser } from '../../models/app-user.model';

@Component({
  selector: 'app-user-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})
export class UserFormComponent implements OnInit {
  user: AppUser = {
    fullName: '',
    email: ''
  };

  users: AppUser[] = [];
  message = '';

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.userService.getAll().subscribe({
      next: (data) => {
        this.users = data;
      },
      error: (err) => {
        console.error('Failed to load users', err);
        this.message = 'Failed to load user records.';
      }
    });
  }

  save(): void {
    if (!this.user.fullName.trim() || !this.user.email.trim()) {
      this.message = 'Full name and email are required.';
      return;
    }

    this.userService.create(this.user).subscribe({
      next: () => {
        this.message = 'User saved successfully.';
        this.user = {
          fullName: '',
          email: ''
        };
        this.loadData();
      },
      error: (err) => {
        console.error('Failed to save user', err);
        this.message = 'Failed to save user.';
      }
    });
  }
}
