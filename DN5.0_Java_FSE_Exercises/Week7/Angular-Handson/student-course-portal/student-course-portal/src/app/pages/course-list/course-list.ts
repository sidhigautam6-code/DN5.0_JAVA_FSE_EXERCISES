import { Component, OnInit } from '@angular/core';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'Algorithms', code: 'CS201', credits: 4, gradeStatus: 'failed' },
    { id: 3, name: 'Web Development', code: 'CS301', credits: 3, gradeStatus: 'pending' },
    { id: 4, name: 'Database Systems', code: 'CS401', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Machine Learning', code: 'CS501', credits: 4, gradeStatus: 'pending' }
  ];

  selectedCourseId: number | null = null;
  isLoading = true;

  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }

  /**
   * trackBy improves performance for large lists
   * Without trackBy, Angular re-renders all list items on any array change
   * With trackBy, only changed items are updated
   */
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}