import { ReactiveEnrollmentFormComponent } from './pages/reactive-enrollment-form/reactive-enrollment-form.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'profile', component: StudentProfileComponent },
  { path: 'enroll', component: EnrollmentFormComponent },
  { path: 'enroll-reactive', component: ReactiveEnrollmentFormComponent },
  { path: '**', redirectTo: '' }
];