import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './shared/nav-bar/nav-bar.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardsComponent } from './shared/cards/cards.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { FiltroComponent } from './home/filtro/filtro.component';
import { PacienteComponent } from './paciente/paciente.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { DateComponent } from './shared/date/date.component';
import {MatCardModule} from '@angular/material/card';
import {MatNativeDateModule} from '@angular/material/core';
import { UsuarioComponent } from './usuario/usuario.component';
import { HttpClientModule } from '@angular/common/http';
import { PsicologoComponent } from './psicologo/psicologo.component';
import { SelectComponent } from './shared/inputs/select/select.component';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    CardsComponent,
    FiltroComponent,
    PacienteComponent,
    DateComponent,
    UsuarioComponent,
    PsicologoComponent,
    SelectComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CarouselModule.forRoot(),
    MatDatepickerModule,
    MatCardModule,
    MatNativeDateModule,
    HttpClientModule,
    MatSelectModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
