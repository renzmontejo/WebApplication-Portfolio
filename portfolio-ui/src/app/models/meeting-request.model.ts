export type MeetingStatus = 'PENDING' | 'APPROVED' | 'REJECTED';

export interface MeetingRequest {
  id: number;
  fullName: string;
  email: string;
  meetingType: string;
  preferredDate?: string;
  message?: string;
  status: MeetingStatus;
  createdAt?: string;
  updatedAt?: string;
}

export interface MeetingRequestCreateRequest {
  fullName: string;
  email: string;
  meetingType: string;
  preferredDate?: string;
  message?: string;
}

export interface MeetingRequestStatusRequest {
  status: MeetingStatus;
}