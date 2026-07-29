import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from '../../app-routing.module';
import { AppComponent } from '../../app.component';
import { HeaderComponent } from '../../components/header/header.component';
import { HomeComponent } from './home.component';
import { CourseListComponent } from '../course-list/course-list.component';
import { StudentProfileComponent } from '../student-profile/student-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CourseListComponent,
    StudentProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }