import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BackendService } from '../../services/backend.service';
import { Backend } from '../../models/backend.model';

@Component({
  selector: 'app-backend-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './backend-form.component.html',
  styleUrl: './backend-form.component.css'
})
export class BackendFormComponent implements OnInit {
  backend: Backend = {
    backendName: ''
  };

  backends: Backend[] = [];
  message = '';

  constructor(private backendService: BackendService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.backendService.getAll().subscribe({
      next: (data) => {
        this.backends = data;
      },
      error: (err) => {
        console.error('Failed to load backends', err);
      }
    });
  }

  save(): void {
    if (!this.backend.backendName.trim()) {
      this.message = 'Backend name is required.';
      return;
    }

    this.backendService.create(this.backend).subscribe({
      next: (response) => {
        this.message = 'Backend saved successfully.';
        this.backend = { backendName: '' };
        this.loadData();
      },
      error: (err) => {
        console.error('Failed to save backend', err);
        this.message = 'Failed to save backend.';
      }
    });
  }
}
