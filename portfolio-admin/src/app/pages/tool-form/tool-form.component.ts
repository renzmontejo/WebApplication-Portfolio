import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ToolService } from '../../services/tool.service';
import { Tool } from '../../models/tool.model';

@Component({
  selector: 'app-tool-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './tool-form.component.html',
  styleUrl: './tool-form.component.css'
})
export class ToolFormComponent implements OnInit {
  tool: Tool = {
    toolName: ''
  };

  tools: Tool[] = [];
  message = '';

  constructor(private toolService: ToolService) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.toolService.getAll().subscribe({
      next: (data) => {
        this.tools = data;
      },
      error: (err) => {
        console.error('Failed to load tools', err);
        this.message = 'Failed to load tool records.';
      }
    });
  }

  save(): void {
    if (!this.tool.toolName.trim()) {
      this.message = 'Tool name is required.';
      return;
    }

    this.toolService.create(this.tool).subscribe({
      next: () => {
        this.message = 'Tool saved successfully.';
        this.tool = { toolName: '' };
        this.loadData();
      },
      error: (err) => {
        console.error('Failed to save tool', err);
        this.message = 'Failed to save tool.';
      }
    });
  }
}
