export interface Profile {
  id: number;
  name: string;
  headline?: string;
  about?: string;
  email?: string;
  phone?: string;
  location?: string;
  createdAt?: string;
  updatedAt?: string;
}

export interface ProfileRequest {
  name: string;
  headline?: string;
  about?: string;
  email?: string;
  phone?: string;
  location?: string;
}