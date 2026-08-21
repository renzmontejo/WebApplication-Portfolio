export interface ServiceItem {
  id: number;
  item: string;
  createdAt?: string;
}

export interface ServiceItemRequest {
  item: string;
}

export interface PortfolioService {
  id: number;
  title: string;
  description?: string;
  icon?: string;
  items: ServiceItem[];
  createdAt?: string;
  updatedAt?: string;
}

export interface PortfolioServiceRequest {
  title: string;
  description?: string;
  icon?: string;
  items: ServiceItemRequest[];
}