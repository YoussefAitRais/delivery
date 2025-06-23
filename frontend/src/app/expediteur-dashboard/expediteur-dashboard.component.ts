import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ColisService } from '../services/colis.service';
import { DemandeService } from '../services/demande.service';

@Component({
  selector: 'app-expediteur-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './expediteur-dashboard.component.html',
})
export class ExpediteurDashboardComponent implements OnInit {
  colisList: any[] = [];
  demandesList: any[] = [];

  showColisForm = false;
  showDemandeForm = false;

  newColis: any = this.initColis();
  newDemande: any = this.initDemande();

  constructor(
    private colisService: ColisService,
    private demandeService: DemandeService
  ) {}

  ngOnInit(): void {
    this.fetchAll();
  }

  fetchAll() {
    this.colisService.getByExpediteur(1).subscribe(data => this.colisList = data);
    this.demandeService.getByExpediteur(1).subscribe(data => this.demandesList = data);
  }

  // Helpers init
  initColis() {
    return {
      destination: '',
      dimensions: '',
      typeColis: '',
      poids: 0,
      longueur: 0,
      largeur: 0,
      hauteur: 0,
      expediteurId: 1
    };
  }

  initDemande() {
    return {
      trajetId: 0,
      expediteurId: 1,
      status: '',
      date: '',
      colisId: 0
    };
  }

  // 🔁 FORM Toggle
  openColisForm() { this.showColisForm = true; }
  closeColisForm() { this.showColisForm = false; this.newColis = this.initColis(); }

  openDemandeForm() { this.showDemandeForm = true; }
  closeDemandeForm() { this.showDemandeForm = false; this.newColis = this.initColis(); this.newDemande = this.initDemande(); }

  // 💾 SAVE: Colis seul
  saveColis() {
    this.colisService.create(this.newColis).subscribe({
      next: colis => {
        this.colisList.push(colis);
        this.closeColisForm();
      },
      error: err => console.error('Erreur colis:', err)
    });
  }

  // 💾 SAVE: Demande + Colis ensemble
  saveDemandeWithColis() {
    const payload = {
      trajetId: this.newDemande.trajetId,
      expediteurId: this.newDemande.expediteurId,
      colis: {
        destination: this.newColis.destination,
        dimensions: this.newColis.dimensions,
        typeColis: this.newColis.typeColis,
        poids: this.newColis.poids,
        longueur: this.newColis.longueur,
        largeur: this.newColis.largeur,
        hauteur: this.newColis.hauteur
      }
    };

    this.demandeService.createWithColis(payload).subscribe({
      next: (demande) => {
        this.demandesList.push(demande);
        this.closeDemandeForm();
      },
      error: (err) => console.error('Erreur demande avec colis:', err)
    });
  }

  // ❌ DELETE
  deleteColis(id: number) {
    this.colisService.delete(id).subscribe(() => {
      this.colisList = this.colisList.filter(c => c.id !== id);
    });
  }

  deleteDemande(id: number) {
    this.demandeService.delete(id).subscribe(() => {
      this.demandesList = this.demandesList.filter(d => d.id !== id);
    });
  }

  // 🎨 UI
  getStatusColor(status: string): string {
    switch (status) {
      case 'ACCEPTEE': return 'text-green-600';
      case 'REFUSEE': return 'text-red-600';
      case 'EN_ATTENTE': return 'text-yellow-500';
      default: return 'text-gray-500';
    }
  }
}
