import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeComponent } from './Features/home/home.component';
import { EvenementsComponent } from './Features/evenements/evenements.component';
import { LieuxComponent } from './Features/lieux/lieux.component';
import { SponsorsComponent } from './Features/sponsors/sponsors.component';
import { ReservationsComponent } from './Features/reservations/reservations.component';
import { NavbarComponent } from './Core/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { MediaComponent } from './Features/media/media.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    EvenementsComponent,
    LieuxComponent,
    SponsorsComponent,
    ReservationsComponent,
    MediaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
