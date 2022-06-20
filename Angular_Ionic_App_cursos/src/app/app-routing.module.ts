import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { LoginIn } from './guard/loginIn.guard';
import { LoginOut } from './guard/loginOut.guard';


const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule),
    canLoad: [LoginOut]
  },
  {
    path: 'new-course',
    loadChildren: () => import('./pages/new-course/new-course.module').then( m => m.NewCoursePageModule),
    canLoad: [LoginOut]
  },
  {
    path: 'list-courses',
    loadChildren: () => import('./pages/list-courses/list-courses.module').then( m => m.ListCoursesPageModule),
    canLoad: [LoginOut]
  },
  {
    path: 'details/:id',
    loadChildren: () => import('./pages/details/details.module').then( m => m.DetailsPageModule),
    canLoad: [LoginOut]
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/auth/login/login.module').then( m => m.LoginPageModule),
    canLoad: [LoginIn]
  },
  {
    path: 'register',
    loadChildren: () => import('./pages/auth/register/register.module').then( m => m.RegisterPageModule),
    canLoad: [LoginIn]
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'shop',
    loadChildren: () => import('./pages/shop/shop.module').then( m => m.ShopPageModule),
    canLoad: [LoginOut]
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
