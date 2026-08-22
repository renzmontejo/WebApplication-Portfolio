import { Component, HostListener, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {
  trigger,
  transition,
  style,
  animate
} from '@angular/animations';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { TechnologyService } from '../../services/technology.service';
import { GroupedTechnologies } from '../../models/technology.model';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './main-layout.html',
  animations: [
    trigger('fadeAnimation', [
      transition('* <=> *', [
        style({ opacity: 0 }),
        animate('220ms ease-out', style({ opacity: 1 }))
      ])
    ])
  ]
})
export class MainLayout implements OnInit {
  isResumeModalOpen = false;
  resumeUrl: SafeResourceUrl;

  groupedTechnologies: GroupedTechnologies = {
    FRONTEND: [],
    BACKEND: [],
    TOOLS: [],
  };
  isLoadingSkills = false;

  constructor(
    private sanitizer: DomSanitizer,
    private technologyService: TechnologyService,
  ) {
    this.resumeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(
      '/resume/resume-pdf.pdf'
    );
  }

  ngOnInit(): void {
    this.loadTechnologies();
  }

  loadTechnologies(): void {
    this.isLoadingSkills = true;
    this.technologyService.getGrouped().subscribe({
      next: (data) => {
        this.groupedTechnologies = data;
        this.isLoadingSkills = false;
      },
      error: () => {
        this.isLoadingSkills = false;
      },
    });
  }

  getRouteState(outlet: RouterOutlet): string {
    return outlet?.isActivated
      ? (outlet.activatedRoute?.routeConfig?.path ?? '')
      : '';
  }

  openResumeModal(): void {
    this.isResumeModalOpen = true;
    document.body.style.overflow = 'hidden';
  }

  closeResumeModal(): void {
    this.isResumeModalOpen = false;
    document.body.style.overflow = '';
  }

  @HostListener('document:keydown.escape')
  onEscapeKey(): void {
    if (this.isResumeModalOpen) {
      this.closeResumeModal();
    }
  }
}