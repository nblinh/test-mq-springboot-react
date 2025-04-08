import { Component } from '@angular/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { Partner } from './partner';
import { PartnerService } from '../service/partner.service';

@Component({
  selector: 'app-partner',
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule],
  templateUrl: './partner.component.html',
  styleUrl: './partner.component.css'
})
export class PartnerComponent {

  displayedColumns: string[] = ['id', 'alias', 'type', 'direction', 'application', 'processedFlowType', 'description', 'delete'];

  partners: Partner[] = [];

  constructor(private partnerService: PartnerService) { }

  ngOnInit(): void {
    this.getPartners();
  }

  getPartners(): void {
    this.partnerService.getPartners()
      .subscribe(partners => this.partners = partners);
  }

  deletePartner(id: number) {
    if (confirm("Are you sure to delete partner id: " + id)) {
      this.partnerService.deletePartner(id).subscribe(res => {
        this.partners = this.partners.filter(item => item.id !== id);
        console.log('Partner deleted successfully!');
      })
    }
  }
}
