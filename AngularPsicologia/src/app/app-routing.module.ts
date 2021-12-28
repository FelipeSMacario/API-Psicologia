import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PacienteComponent } from './paciente/paciente.component';
import { PsicologoComponent } from './psicologo/psicologo.component';
import { UsuarioComponent } from './usuario/usuario.component';

const routes: Routes = [
  {
    path : "",
    redirectTo : "login",
    pathMatch : "full"
  },
  {
    path : "login",
    component : LoginComponent
  },
  {
    path : "home",
    component : HomeComponent
  },
  {
    path : "paciente",
    component : PacienteComponent
  },
  {
    path : "usuario",
    component : UsuarioComponent
  },
  {
    path : "psicologo",
    component : PsicologoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
