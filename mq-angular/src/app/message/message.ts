export interface Page {
  pageSize: number;
  pageIndex: number;
  totalItems: number;
}

export interface Message {
  id: number;
  type: string;
  content: string;
}

/* export class MessagePageable {
  messages: Message[];
  page: Page;

  constructor(messages: Message[], page: Page) {
    this.messages = messages;
    this.page = page;
  }
}
 */
export class MessagePageable {
  messages: Message[];
  totalPages: number;
  size: number;
  page: number;
  constructor(messages: any, totalPages: number, size: number, page: number) {
    this.messages = messages;
    this.totalPages = totalPages;
    this.size = size;
    this.page = page;
  }
}
