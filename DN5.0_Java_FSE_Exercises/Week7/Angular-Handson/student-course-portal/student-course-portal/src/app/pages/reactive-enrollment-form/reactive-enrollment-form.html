import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray, FormControl } from '@angular/forms';
import { noCourseCode, simulateEmailCheck } from '../../validators/custom.validators';

@Component({
  selector: 'app-reactive-enrollment-form',
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrls: ['./reactive-enrollment-form.component.css']
})
export class ReactiveEnrollmentFormComponent implements OnInit {
  enrollForm!: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [simulateEmailCheck]],
      courseId: [null, [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  /**
   * Difference between value and getRawValue():
   * - value: Returns only enabled controls (disabled controls are excluded)
   * - getRawValue(): Returns all controls including disabled ones
   */
  onSubmit() {
    if (this.enrollForm.valid) {
      console.log('Form Value:', this.enrollForm.value);
      console.log('Raw Value:', this.enrollForm.getRawValue());
      this.submitted = true;
    }
  }

  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourse() {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeCourse(index: number) {
    this.additionalCourses.removeAt(index);
  }

  resetForm() {
    this.enrollForm.reset();
    this.additionalCourses.clear();
    this.submitted = false;
  }
}