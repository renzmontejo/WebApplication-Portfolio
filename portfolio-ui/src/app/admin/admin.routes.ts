import { Routes } from '@angular/router';
import { authGuard } from './guards/auth-guard';
import { AdminLayout } from './components/admin-layout/admin-layout';
import { Login } from './pages/login/login';
import { Dashboard } from './pages/dashboard/dashboard';
import { Messages } from './pages/messages/messages';
import { Projects } from './pages/projects/projects';
import { Meetings } from './pages/meetings/meetings';

export const ADMIN_ROUTES: Routes = [
  {
    path: 'admin/login',
    component: Login,
  },
  {
    path: 'admin',
    component: AdminLayout,
    canActivate: [authGuard],
    children: [
      { path: 'dashboard', component: Dashboard },
      { path: 'messages', component: Messages },
      { path: 'projects', component: Projects },
      { path: 'meetings', component: Meetings },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    ],
  },
];
