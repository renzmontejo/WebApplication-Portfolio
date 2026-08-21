import { Technology } from './technology.model';

export type ProjectType = 'PERSONAL' | 'CLIENT';

export interface Project {
  id: number;
  title: string;
  projectType: ProjectType;
  description?: string;
  dateCreated?: string;
  technologies: Technology[];
  createdAt?: string;
  updatedAt?: string;
}

export interface ProjectRequest {
  title: string;
  projectType: ProjectType;
  description?: string;
  dateCreated?: string;
  technologyIds: number[];
}