import { Component, HostListener } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {
  trigger,
  transition,
  style,
  animate
} from '@angular/animations';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-main-layout',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
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
export class MainLayout {
  isResumeModalOpen = false;
  resumeUrl: SafeResourceUrl;

  constructor(private sanitizer: DomSanitizer) {
    this.resumeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(
      '/resume/resume-pdf.pdf'
    );
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
