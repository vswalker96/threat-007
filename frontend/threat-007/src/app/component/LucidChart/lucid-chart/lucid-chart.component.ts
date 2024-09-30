import { Component, OnInit } from '@angular/core';
import { DocumentDetails } from '../../../model/documentDetails';
import { LucidChartService } from '../../../service/LucidChartService/lucid-chart.service';
import { NgFor, NgIf } from '@angular/common';
import { ThreatAgentService } from '../../../service/ThreatAgentService/threat-agent.service';
import { ThreatReportComponent } from "../../ThreatReport/threat-report/threat-report.component";

@Component({
  selector: 'app-lucid-chart',
  standalone: true,
  imports: [NgFor, NgIf, ThreatReportComponent],
  templateUrl: './lucid-chart.component.html',
  styleUrl: './lucid-chart.component.css'
})
export class LucidChartComponent implements OnInit {


  public showReport: boolean = false;
  public reportResponse: any;
  documentDetails: DocumentDetails[] = [];
  public isLoading: boolean = false;

  constructor(private lucidChartService: LucidChartService, private threatAgentService: ThreatAgentService) {
  }

  ngOnInit() {
    this.reportResponse = {};
    this.getAllDocuments();
  }

  getAllDocuments() {
    this.lucidChartService.getAllDocuments().subscribe((data: DocumentDetails[]) => {
      this.documentDetails = data;
    });
  }

  handleClickedDocument(documentId: string) {
    this.isLoading = true;
    
    this.threatAgentService.getThreatAnalysisByDocumentId(documentId).subscribe((data) => {
      this.reportResponse = data.response;
      this.isLoading = false;
      this.showReport = true;
     
    });    
  }
}
