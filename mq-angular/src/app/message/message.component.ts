import { Component, ViewChild } from '@angular/core';
import { Message } from './message';
import { NgFor } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MessageDetailComponent } from '../message-detail/message-detail.component';
import { MatDialog } from '@angular/material/dialog';
import { MessageService } from '../service/message.service';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';

@Component({
  selector: 'app-message',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule],
  templateUrl: './message.component.html',
  styleUrl: './message.component.css'
})
export class MessageComponent {
  page: number = 0;
  size = 2;
  totalElements!: number;
  totalPages!: number;
  selectedItem: any;
  displayedColumns: string[] = ['id', 'type', 'content'];

  messages: any;

  selectedMessage?: Message;

  constructor(private dialog: MatDialog, private messageService: MessageService) {
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  /*  ngAfterViewInit() {
     this.messages.paginator = this.paginator;
   }
  */
  ngOnInit(): void {
    this.getMessage(this.page, this.size);
  }

  getMessage(offset: number, pageSize: number): void {
    this.messageService.getMessages(offset, pageSize)
      .subscribe((res: any) => {
        this.messages = res.content as Message[];
        this.size = res.size;
        this.page = res.number;
        this.totalPages = res.totalPages;
        this.totalElements = res.totalElements;
      })
  }

  onSelect(message: Message): void {
    this.selectedMessage = message;
    this.dialog.closeAll();

    this.dialog.open(MessageDetailComponent, {
      data: this.selectedMessage,
    });
  }

}
