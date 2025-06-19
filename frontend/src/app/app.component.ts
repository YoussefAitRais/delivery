import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {ExpediteurDashboardComponent} from "./expediteur-dashboard/expediteur-dashboard.component";
import {ConducteurDashboardComponent} from "./conducteur-dashboard/conducteur-dashboard.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {HomeComponent} from "./home/home.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, LoginComponent, RegisterComponent, DashboardComponent, ExpediteurDashboardComponent, ConducteurDashboardComponent, NavbarComponent, HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';


}
