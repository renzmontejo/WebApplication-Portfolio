import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProjectService } from '../../services/project.service';
import { Project } from '../../models/project.model';

@Component({
  selector: 'app-project-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './project-form.component.html',
  styleUrl: './project-form.component.css'
})
export class ProjectFormComponent implements OnInit {
  project: Project = {
    projectName: '',
    description: ''
  };

  projects: Project[] = [];
  message = '';

  constructor(private projectService: ProjectService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.projectService.getAll().subscribe({
      next: (data) => {
        this.projects = data;
      },
      error: (err) => {
        console.error('Failed to load projects', err);
        this.message = 'Failed to load project records.';
      }
    });
  }

  save(): void {
    if (!this.project.projectName.trim()) {
      this.message = 'Project name is required.';
      return;
    }

    this.projectService.create(this.project).subscribe({
      next: () => {
        this.message = 'Project saved successfully.';
        this.project = {
          projectName: '',
          description: ''
        };
        this.loadData();
      },
      error: (err) => {
        console.error('Failed to save project', err);
        this.message = 'Failed to save project.';
      }
    });
  }
}
