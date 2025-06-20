import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpediteurService {
  private apiUrl = 'http://localhost:8080/api/expediteurs';

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  create(expediteur: any): Observable<any> {
    return this.http.post(this.apiUrl, expediteur);
  }

  update(id: number, expediteur: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, expediteur);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  getAllExpediteurs(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}

