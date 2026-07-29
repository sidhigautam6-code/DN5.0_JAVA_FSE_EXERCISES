import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-enrollment-form',
  templateUrl: './enrollment-form.component.html',
  styleUrls: ['./enrollment-form.component.css']
})
export class EnrollmentFormComponent {
  model = {
    studentName: '',
    studentEmail: '',
    courseId: null,
    preferredSemester: 'Odd',
    agreeToTerms: false
  };

  submitted = false;

  onSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Form Value:', form.value);
      console.log('Form Valid:', form.valid);
      this.submitted = true;
    }
  }

  onReset(form: NgForm) {
    form.resetForm();
    this.submitted = false;
  }
}