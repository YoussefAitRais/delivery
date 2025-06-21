import { Component, OnInit } from '@angular/core';
import { ConducteurService } from '../services/conducteur.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {HttpClient} from "@angular/common/http";
import {RouterModule} from "@angular/router";

@Component({
  selector: 'app-conducteur-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule , RouterModule],
  templateUrl: './conducteur-dashboard.component.html',
})
export class ConducteurDashboardComponent implements OnInit {
  conducteurId: number = 1;
  trajets: any[] = [];
  demandes: any[] = [];
  etatEncoursCount = 0;

  isEdit = false;

  newTrajet = {
    id: null,
    depart: '',
    destination: '',
    date: '',
  };

  constructor(private conducteurService: ConducteurService) {}

  ngOnInit(): void {
    this.loadTrajets();
    this.loadDemandes();
  }

  loadTrajets() {
    this.conducteurService.getTrajetsForConducteur(this.conducteurId).subscribe((data: any[]) => {
      this.trajets = data;
      this.etatEncoursCount = this.trajets.filter(t => t.etat === 'EN_COURS').length;
    });
  }

  loadDemandes() {
    this.conducteurService.getAllDemandes().subscribe((data: any[]) => {
      this.demandes = data;
    });
  }

  addTrajet(): void {
    this.conducteurService
      .createTrajetForConducteur(this.conducteurId, this.newTrajet)
      .subscribe({
        next: () => {
          this.loadTrajets();
          this.resetForm();
        },
        error: err => console.error('Erreur ajout:', err),
      });
  }

  deleteTrajet(id: number) {
    this.conducteurService.deleteTrajet(id).subscribe(() => {
      this.loadTrajets();
    });
  }

  editTrajet(trajet: any) {
    this.newTrajet = {
      id: trajet.id,
      depart: trajet.depart,
      destination: trajet.destination,
      date: trajet.date,
    };
    this.isEdit = true;
  }

  updateTrajet(): void {
    if (this.newTrajet.id == null) {
      console.warn("ID de trajet est null !");
      return;
    }

    this.conducteurService
      .updateTrajet(this.newTrajet.id, this.newTrajet)
      .subscribe({
        next: () => {
          this.loadTrajets();
          this.resetForm();
        },
        error: err => console.error('Erreur update:', err),
      });
  }

  resetForm() {
    this.newTrajet = { id: null, depart: '', destination: '', date: '' };
    this.isEdit = false;
  }
}
