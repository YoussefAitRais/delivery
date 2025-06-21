import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ConducteurDashboardComponent } from './conducteur-dashboard.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ConducteurService } from '../services/conducteur.service';
import { RouterTestingModule } from '@angular/router/testing'; // ✅ هذا هو لي خصو يخدم

describe('ConducteurDashboardComponent', () => {
  let component: ConducteurDashboardComponent;
  let fixture: ComponentFixture<ConducteurDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        ConducteurDashboardComponent, // ✅ standalone component
        HttpClientTestingModule,
        RouterTestingModule           // ✅ زيدو هنا فعلاً
      ],
      providers: [
        ConducteurService
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(ConducteurDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
