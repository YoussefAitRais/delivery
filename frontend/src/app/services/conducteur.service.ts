import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConducteurService {
  private baseUrl = 'http://localhost:8080/api/conducteurs';

  constructor(private http: HttpClient) {}

  getTrajetsForConducteur(conducteurId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/${conducteurId}/trajets`);
  }

  createTrajetForConducteur(conducteurId: number, trajet: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/${conducteurId}/trajets`, trajet);
  }

  updateTrajet(id: number, trajet: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/trajets/${id}`, trajet);
  }

  deleteTrajet(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/trajets/${id}`);
  }

  getAllDemandes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/demandes`); // ✅ هذا خصو يكون موجد في الباك
  }
}
