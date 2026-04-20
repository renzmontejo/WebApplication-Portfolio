import { Routes } from '@angular/router';
import { MainLayout } from './layout/main-layout/main-layout';
import { HomeComponent } from './pages/home/home';
import { Projects } from './pages/projects/projects';
import { MyServices } from './pages/my-services/my-services';
import { ScheduleAMeeting } from './pages/schedule-a-meeting/schedule-a-meeting';
import { SendEmail } from './pages/send-email/send-email';

export const routes: Routes = [
  {
    path: '',
    component: MainLayout,
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', component: HomeComponent },
      { path: 'projects', component: Projects },
      { path: 'my-services', component: MyServices },
      { path: 'schedule-a-meeting', component: ScheduleAMeeting },
      { path: 'send-email', component: SendEmail }
    ]
  },
  { path: '**', redirectTo: '' }
];
