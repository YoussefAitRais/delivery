import { Component, OnInit } from '@angular/core';
import { ExpediteurService } from '../services/expediteur.service';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-expediteur-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './expediteur-dashboard.component.html',
})
export class ExpediteurDashboardComponent implements OnInit {

  expediteurs: any[] = [];

  constructor(private expediteurService: ExpediteurService) {}

  ngOnInit(): void {
    this.expediteurService.getAllExpediteurs().subscribe(data => {
      this.expediteurs = data;
      console.log('✅ Expéditeurs récupérés depuis l\'API :', data);
    }, error => {
      console.error('❌ Erreur lors de la récupération des expéditeurs :', error);
    });
  }
}
