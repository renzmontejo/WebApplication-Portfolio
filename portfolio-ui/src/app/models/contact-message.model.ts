export type MessageType = 'CONTACT' | 'EMAIL';
export type MessageStatus = 'NEW' | 'READ' | 'REPLIED';

export interface ContactMessage {
  id: number;
  name: string;
  email: string;
  phone?: string;
  subject?: string;
  message: string;
  messageType: MessageType;
  status: MessageStatus;
  createdAt?: string;
}

export interface ContactMessageCreateRequest {
  name: string;
  email: string;
  phone?: string;
  subject?: string;
  message: string;
  messageType: MessageType;
}

export interface ContactMessageStatusRequest {
  status: MessageStatus;
}