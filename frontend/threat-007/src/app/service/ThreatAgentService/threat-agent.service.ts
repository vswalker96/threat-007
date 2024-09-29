import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ThreatAgentService {
  
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getThreatAnalysisByDocumentId(documentId: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/threatAnalysis/${documentId}`);
  }   
}
