import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FormGroup, FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PartnerService } from '../service/partner.service';
import { NgFor, NgIf } from '@angular/common';
import { DirectionEnum, ProcessedFlowTypeEnum } from '../partner/partner';

@Component({
  selector: 'app-add-partner',
  standalone: true,
  imports: [NgIf, FormsModule, ReactiveFormsModule, NgFor],
  templateUrl: './add-partner.component.html',
  styleUrl: './add-partner.component.css'
})
export class AddPartnerComponent implements OnInit {

  form!: FormGroup;
  directionOptions: string[] = Object.keys(DirectionEnum);
  processedFlowTypeOptions: string[] = Object.keys(ProcessedFlowTypeEnum);

  constructor(public partnerService: PartnerService, private router: Router) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      alias: new FormControl('', [Validators.required]),
      type: new FormControl('', Validators.required),
      direction: new FormControl('', Validators.required),
      application: new FormControl('', Validators.required),
      processedFlowType: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    this.partnerService.addPartner(this.form.value).subscribe((res: any) => {
      console.log('Post created successfully!');
      this.router.navigateByUrl('partners');
    })

  }



}
