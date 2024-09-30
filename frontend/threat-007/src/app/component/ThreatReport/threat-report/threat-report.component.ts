import { NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-threat-report',
  standalone: true,
  imports: [NgIf],
  templateUrl: './threat-report.component.html',
  styleUrl: './threat-report.component.css'
})
export class ThreatReportComponent {

  threatReport: string = '';

  public showReport: boolean = false;

  
  @Input() data: any;

  ngOnInit() {
    this.threatReport = this.data;
  }

}
