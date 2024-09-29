import { Component, OnInit } from '@angular/core';
import { DocumentDetails } from '../../../model/documentDetails';
import { LucidChartService } from '../../../service/LucidChartService/lucid-chart.service';
import { NgFor } from '@angular/common';
import { ThreatAgentService } from '../../../service/ThreatAgentService/threat-agent.service';

@Component({
  selector: 'app-lucid-chart',
  standalone: true,
  imports: [NgFor],
  templateUrl: './lucid-chart.component.html',
  styleUrl: './lucid-chart.component.css'
})
export class LucidChartComponent implements OnInit {

  documentDetails: DocumentDetails[] = [];

  constructor(private lucidChartService: LucidChartService, private threatAgentService: ThreatAgentService) {
    // constructor
  }

  ngOnInit() {
    this.getAllDocuments();
  }

  getAllDocuments() {
    this.lucidChartService.getAllDocuments().subscribe((data: DocumentDetails[]) => {
      this.documentDetails = data;
    });
  }

  handleClickedDocument(documentId: string) {
    this.threatAgentService.getThreatAnalysisByDocumentId(documentId).subscribe((data) => {
      console.log(data);
    });
  }
}
