export interface Experience {
  id: number;
  jobTitle: string;
  company: string;
  description?: string;
  startDate?: string;
  endDate?: string;
  current: boolean;
  createdAt?: string;
  updatedAt?: string;
}

export interface ExperienceRequest {
  jobTitle: string;
  company: string;
  description?: string;
  startDate?: string;
  endDate?: string;
  current: boolean;
}