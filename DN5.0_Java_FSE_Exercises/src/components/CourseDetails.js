import React from 'react';

const CourseDetails = () => {
    const courses = [
        {
            id: 1,
            name: 'React Development Bootcamp',
            instructor: 'Dr. Sarah Chen',
            duration: '12 weeks',
            level: 'Intermediate',
            students: 1245,
            rating: 4.8,
            icon: '⚛️'
        },
        {
            id: 2,
            name: 'Data Science Masterclass',
            instructor: 'Prof. James Wilson',
            duration: '16 weeks',
            level: 'Advanced',
            students: 876,
            rating: 4.9,
            icon: '📊'
        },
        {
            id: 3,
            name: 'Web Development Fundamentals',
            instructor: 'Lisa Martinez',
            duration: '8 weeks',
            level: 'Beginner',
            students: 2341,
            rating: 4.7,
            icon: '🌐'
        },
        {
            id: 4,
            name: 'Python Programming',
            instructor: 'David Kim',
            duration: '10 weeks',
            level: 'Intermediate',
            students: 1890,
            rating: 4.6,
            icon: '🐍'
        },
        {
            id: 5,
            name: 'Cloud Computing with AWS',
            instructor: 'Maria Garcia',
            duration: '14 weeks',
            level: 'Advanced',
            students: 654,
            rating: 4.9,
            icon: '☁️'
        }
    ];

    // Using map() to render course items
    const courseList = courses.map((course) => (
        <div key={course.id} style={styles.courseCard}>
            <div style={styles.courseIcon}>{course.icon}</div>
            <div style={styles.courseInfo}>
                <h3 style={styles.courseName}>{course.name}</h3>
                <p style={styles.courseInstructor}>👨‍🏫 {course.instructor}</p>
                <div style={styles.courseMeta}>
                    <span style={styles.courseDuration}>⏱️ {course.duration}</span>
                    <span style={styles.courseLevel}>📊 {course.level}</span>
                </div>
                <div style={styles.courseStats}>
                    <span>👥 {course.students.toLocaleString()} students</span>
                    <span style={styles.courseRating}>⭐ {course.rating}</span>
                </div>
            </div>
        </div>
    ));

    return (
        <div style={styles.container}>
            <div style={styles.header}>
                <h2 style={styles.title}>🎓 Course Details</h2>
                <span style={styles.count}>Total: {courses.length} courses</span>
            </div>
            <div style={styles.courseList}>
                {courseList}
            </div>
        </div>
    );
};

const styles = {
    container: {
        backgroundColor: '#f8f9fa',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 4px 15px rgba(0,0,0,0.1)',
        marginBottom: '20px'
    },
    header: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        marginBottom: '20px',
        borderBottom: '3px solid #9b59b6',
        paddingBottom: '10px'
    },
    title: {
        margin: '0',
        color: '#2c3e50',
        fontSize: '1.8rem'
    },
    count: {
        backgroundColor: '#9b59b6',
        color: 'white',
        padding: '5px 15px',
        borderRadius: '20px',
        fontSize: '0.9rem'
    },
    courseList: {
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))',
        gap: '20px'
    },
    courseCard: {
        backgroundColor: 'white',
        padding: '15px',
        borderRadius: '8px',
        boxShadow: '0 2px 8px rgba(0,0,0,0.08)',
        display: 'flex',
        alignItems: 'center',
        gap: '15px',
        transition: 'transform 0.3s ease'
    },
    courseIcon: {
        fontSize: '2.5rem',
        backgroundColor: '#f3e5f5',
        padding: '10px',
        borderRadius: '50%',
        width: '60px',
        height: '60px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flexShrink: 0
    },
    courseInfo: {
        flex: 1
    },
    courseName: {
        margin: '0 0 5px 0',
        color: '#2c3e50',
        fontSize: '1.1rem'
    },
    courseInstructor: {
        margin: '0 0 8px 0',
        color: '#7f8c8d',
        fontSize: '0.9rem'
    },
    courseMeta: {
        display: 'flex',
        gap: '15px',
        fontSize: '0.85rem',
        color: '#95a5a6',
        marginBottom: '5px'
    },
    courseDuration: {
        color: '#3498db'
    },
    courseLevel: {
        backgroundColor: '#f3e5f5',
        padding: '2px 10px',
        borderRadius: '12px',
        color: '#7b1fa2'
    },
    courseStats: {
        display: 'flex',
        justifyContent: 'space-between',
        fontSize: '0.9rem',
        color: '#5b6c7d'
    },
    courseRating: {
        fontWeight: 'bold',
        color: '#f39c12'
    }
};

export default CourseDetails;