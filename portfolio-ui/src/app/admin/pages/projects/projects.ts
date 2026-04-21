import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminProjectService } from '../../services/admin-project.service';

@Component({
  selector: 'app-admin-projects',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './projects.html',
  styleUrl: './projects.css',
})
export class Projects implements OnInit {
  projects: any[] = [];
  isLoading = false;

  isTypeFocused = false;
  isDateFocused = false;

  form = {
    title: '',
    projectType: '',
    dateCreated: '',
    description: '',
    techStack: '',
  };

  constructor(private projectService: AdminProjectService) {}

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects(): void {
    this.isLoading = true;
    this.projectService.getAll().subscribe({
      next: (data) => {
        this.projects = data;
        this.isLoading = false;
      },
      error: () => {
        this.isLoading = false;
      },
    });
  }

  createProject(): void {
    if (
      !this.form.title.trim() ||
      !this.form.projectType.trim() ||
      !this.form.dateCreated.trim() ||
      !this.form.description.trim() ||
      !this.form.techStack.trim()
    ) {
      alert('Please fill in all project fields.');
      return;
    }

    this.projectService.create(this.form).subscribe({
      next: () => {
        this.form = {
          title: '',
          projectType: '',
          dateCreated: '',
          description: '',
          techStack: '',
        };
        this.loadProjects();
      },
    });
  }

  deleteProject(id: number): void {
    this.projectService.delete(id).subscribe({
      next: () => {
        this.loadProjects();
      },
    });
  }
}
