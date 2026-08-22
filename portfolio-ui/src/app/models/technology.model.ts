export type TechnologyCategory = 'FRONTEND' | 'BACKEND' | 'TOOLS';

export interface Technology {
  id: number;
  name: string;
  caterory: TechnologyCategory;
  createdAt?: string;
}

export interface TechnologyRequest {
  name: string;
}

export type GroupedTechnologies = Record<TechnologyCategory, Technology[]>;