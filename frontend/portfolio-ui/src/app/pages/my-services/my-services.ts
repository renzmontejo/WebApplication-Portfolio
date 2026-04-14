import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-my-services',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './my-services.html'
})
export class MyServices {
  services = [
    {
      title: 'UI/UX Design',
      icon: 'fa-solid fa-palette',
      description:
        'Clean and practical interface design focused on usability, structure, and modern layout presentation.',
      items: [
        'Wireframing & Prototyping',
        'Responsive Layouts',
        'Clean Visual Structure',
        'Pixel-Consistent UI Design'
      ]
    },
    {
      title: 'Frontend Development',
      icon: 'fa-solid fa-laptop-code',
      description:
        'Responsive and modern frontend interfaces built for smooth user experience and clean presentation.',
      items: [
        'Angular / React / Next.js',
        'Tailwind CSS & Bootstrap',
        'REST API Integration',
        'Mobile-First Responsive Design'
      ]
    },
    {
      title: 'Backend Development',
      icon: 'fa-solid fa-server',
      description:
        'Structured backend systems with API logic, authentication flow, and database integration.',
      items: [
        'Java Spring Boot',
        'Laravel & PHP',
        'Node.js Basics',
        'MySQL Database Design'
      ]
    },
    {
      title: 'Full-Stack Systems',
      icon: 'fa-solid fa-layer-group',
      description:
        'End-to-end systems that combine frontend, backend, database, and deployment-ready structure.',
      items: [
        'Enterprise App Development',
        'CRUD & Business Systems',
        'Authentication & Roles',
        'Deployment Preparation'
      ]
    },
    {
      title: 'Website Development',
      icon: 'fa-solid fa-globe',
      description:
        'Professional websites for portfolios, small businesses, and personal brands with clean structure.',
      items: [
        'Portfolio Websites',
        'Business Landing Pages',
        'Company Profile Pages',
        'SEO-Friendly Structure'
      ]
    },
    {
      title: 'Maintenance & Improvements',
      icon: 'fa-solid fa-screwdriver-wrench',
      description:
        'Ongoing support for improvements, redesigns, bug fixes, and feature enhancement of existing systems.',
      items: [
        'Bug Fixes & Refinement',
        'UI Improvement',
        'Performance Cleanup',
        'Feature Enhancements'
      ]
    }
  ];
}
