import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BackendService } from '../../services/backend.service';
import { FrontendService } from '../../services/frontend.service';
import { ProjectService } from '../../services/project.service';
import { ToolService } from '../../services/tool.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  backendCount = 0;
  frontendCount = 0;
  projectCount = 0;
  toolCount = 0;
  userCount = 0;

  constructor(
    private backendService: BackendService,
    private frontendService: FrontendService,
    private projectService: ProjectService,
    private toolService: ToolService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.loadCounts();
  }

  loadCounts(): void {
    this.backendService.getAll().subscribe({
      next: (data) => this.backendCount = data.length,
      error: (err) => console.error('Failed to load backend count', err)
    });

    this.frontendService.getAll().subscribe({
      next: (data) => this.frontendCount = data.length,
      error: (err) => console.error('Failed to load frontend count', err)
    });

    this.projectService.getAll().subscribe({
      next: (data) => this.projectCount = data.length,
      error: (err) => console.error('Failed to load project count', err)
    });

    this.toolService.getAll().subscribe({
      next: (data) => this.toolCount = data.length,
      error: (err) => console.error('Failed to load tool count', err)
    });

    this.userService.getAll().subscribe({
      next: (data) => this.userCount = data.length,
      error: (err) => console.error('Failed to load user count', err)
    });
  }
}
