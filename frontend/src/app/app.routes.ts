import { Routes } from '@angular/router';
import { MainpageComponent } from './mainpage/mainpage/mainpage.component';
import { InitialConfigComponent } from './initialconfig/initial-config/initial-config.component';

export const routes: Routes = [
  {
    path: 'mainpage',
    component: MainpageComponent
  },
  {
    path: '',
    redirectTo: '/initialConfig',
    pathMatch: 'full'
  },
  {
    path: 'initialConfig',
    component: InitialConfigComponent
  }
];