import { Routes } from '@angular/router';
import { MessageComponent } from './message/message.component';
import { PartnerComponent } from './partner/partner.component';
import { AddPartnerComponent } from './add-partner/add-partner.component';

export const routes: Routes = [
  { path: 'messages', component: MessageComponent },
  { path: 'partners', component: PartnerComponent },
  { path: 'partners/add', component: AddPartnerComponent },
];
