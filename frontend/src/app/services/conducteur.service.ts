import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class ConducteurService {
  private baseUrl = 'http://localhost:8080/api/trajets';

  constructor(private http: HttpClient) {}

  getTrajetsForConducteur(conducteurId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/conducteur/${conducteurId}`);
  }

  createTrajetForConducteur(conducteurId: number, trajet: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/conducteur/${conducteurId}`, trajet);
  }

  updateTrajet(id: number, trajet: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, trajet);
  }

  deleteTrajet(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  getAllDemandes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/demandes`);
  }
}
