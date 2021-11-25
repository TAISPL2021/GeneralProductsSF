import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {SharedModule} from './shared/shared.module';
import { LayoutComponent } from './layout/layout.component';
import {CoreModule} from './core/core.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { MatGridListModule } from '@angular/material/grid-list';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    LayoutComponent
  ],
  imports: [
    SharedModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CoreModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatGridListModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
