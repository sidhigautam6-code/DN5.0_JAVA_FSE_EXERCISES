import { AbstractControl, ValidationErrors } from '@angular/forms';

/**
 * Custom synchronous validator
 * Checks if course code starts with 'XX' (disallowed prefix)
 */
export function noCourseCode(control: AbstractControl): ValidationErrors | null {
  if (control.value && control.value.toString().startsWith('XX')) {
    return { noCourseCode: true };
  }
  return null;
}

/**
 * Custom async validator
 * Simulates checking if email is already taken
 * Returns a Promise that resolves after 800ms
 */
export function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise((resolve) => {
    setTimeout(() => {
      if (control.value && control.value.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}