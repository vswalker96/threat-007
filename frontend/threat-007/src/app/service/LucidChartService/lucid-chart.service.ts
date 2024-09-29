import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LucidChartService {
  
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getDocumentById(documentId: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/documents/${documentId}`);
  }

  getAllDocuments(): Observable<any> {
    let requestBody = {
      product: ["lucidchart"]
    };

    let requestBodyString = JSON.stringify(requestBody);
    return this.http.post(`${this.apiUrl}/documents/search`, requestBodyString);
  }

  getAllDocumentContentById(documentId: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/documents/${documentId}/contents`);
  }
}
