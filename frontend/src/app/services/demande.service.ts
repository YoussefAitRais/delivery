import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DemandeService {
  private apiUrl = 'http://localhost:8080/api/demandes';

  constructor(private http: HttpClient) {}

  getByExpediteur(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/expediteur/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, data);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // ✅ NEW METHOD TO SEND demande + colis
  createWithColis(data: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/with-colis`, data);
  }
}
