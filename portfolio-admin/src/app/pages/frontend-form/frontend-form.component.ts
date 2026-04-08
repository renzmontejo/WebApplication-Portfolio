import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FrontendService } from '../../services/frontend.service';
import { Frontend } from '../../models/frontend.model';

@Component({
  selector: 'app-frontend-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './frontend-form.component.html',
  styleUrl: './frontend-form.component.css'
})
export class FrontendFormComponent implements OnInit {
  frontend: Frontend = {
    frontendName: ''
  };

  frontends: Frontend[] = [];
  message = '';

  constructor(private frontendService: FrontendService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.frontendService.getAll().subscribe({
      next: (data) => {
        this.frontends = data;
      },
      error: (err) => {
        console.error('Failed to load frontends', err);
        this.message = 'Failed to load frontend records.';
      }
    });
  }

  save(): void {
    if (!this.frontend.frontendName.trim()) {
      this.message = 'Frontend name is required.';
      return;
    }

    this.frontendService.create(this.frontend).subscribe({
      next: () => {
        this.message = 'Frontend saved successfully.';
        this.frontend = { frontendName: '' };
        this.loadData();
      },
      error: (err) => {
        console.error('Failed to save frontend', err);
        this.message = 'Failed to save frontend.';
      }
    });
  }
}
