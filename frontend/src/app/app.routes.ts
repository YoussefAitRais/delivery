import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {ExpediteurDashboardComponent} from "./expediteur-dashboard/expediteur-dashboard.component";
import {ConducteurDashboardComponent} from "./conducteur-dashboard/conducteur-dashboard.component";

export const routes: Routes = [
  {path: '',component: HomeComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'dashboard', component: DashboardComponent},
  {
    path: 'expediteur-dashboard',
    loadComponent: () => import('./expediteur-dashboard/expediteur-dashboard.component')
      .then(m => m.ExpediteurDashboardComponent)
  },

  {
    path: 'conducteur-dashboard',
    loadComponent: () => import('./conducteur-dashboard/conducteur-dashboard.component')
      .then(m => m.ConducteurDashboardComponent)
  }

];
