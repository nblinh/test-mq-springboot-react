import { FormsModule } from '@angular/forms';
import { Message } from '../message/message';
import { Component, Inject } from '@angular/core';
import { NgIf, UpperCasePipe } from '@angular/common';
import {
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogTitle,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-message-detail',
  standalone: true,
  imports: [NgIf, UpperCasePipe, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule],
  templateUrl: './message-detail.component.html',
  styleUrl: './message-detail.component.css'
})
export class MessageDetailComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public message: Message) { }

}
