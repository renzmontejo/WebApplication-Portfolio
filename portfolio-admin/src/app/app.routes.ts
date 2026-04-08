import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { BackendFormComponent } from './pages/backend-form/backend-form.component';
import { FrontendFormComponent } from './pages/frontend-form/frontend-form.component';
import { ProjectFormComponent } from './pages/project-form/project-form.component';
import { ToolFormComponent } from './pages/tool-form/tool-form.component';
import { UserFormComponent } from './pages/user-form/user-form.component';

export const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'backends', component: BackendFormComponent },
  { path: 'frontends', component: FrontendFormComponent },
  { path: 'projects', component: ProjectFormComponent },
  { path: 'tools', component: ToolFormComponent },
  { path: 'users', component: UserFormComponent }
];
