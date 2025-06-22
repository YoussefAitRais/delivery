
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ColisService {

  private apiUrl = 'http://localhost:8080/api/colis';

  constructor(private http: HttpClient) {}

  getByExpediteur(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/expediteur/${id}`);
  }



  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  create(colis: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, colis);
  }

}
