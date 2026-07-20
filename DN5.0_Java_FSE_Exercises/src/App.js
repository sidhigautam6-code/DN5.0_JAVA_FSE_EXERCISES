// src/App.js
import React from 'react';
import CohortDetails from './CohortDetails';
import './App.css';

function App() {
    // Sample cohort data
    const cohorts = [
        {
            name: 'React Development',
            status: 'ongoing',
            startDate: '2026-01-15',
            endDate: '2026-03-15',
            totalStudents: 25,
            trainer: 'John Smith',
            module: 'React Advanced'
        },
        {
            name: 'Full Stack Java',
            status: 'completed',
            startDate: '2025-10-01',
            endDate: '2025-12-20',
            totalStudents: 30,
            trainer: 'Sarah Johnson',
            module: 'Java Spring Boot'
        },
        {
            name: 'Python Data Science',
            status: 'ongoing',
            startDate: '2026-02-01',
            endDate: '2026-04-30',
            totalStudents: 20,
            trainer: 'Michael Chen',
            module: 'Data Analytics'
        },
        {
            name: 'AWS Cloud Computing',
            status: 'completed',
            startDate: '2025-11-01',
            endDate: '2026-01-15',
            totalStudents: 18,
            trainer: 'Emily Davis',
            module: 'AWS Solutions'
        },
        {
            name: 'DevOps Engineering',
            status: 'ongoing',
            startDate: '2026-03-01',
            endDate: '2026-05-30',
            totalStudents: 22,
            trainer: 'Robert Wilson',
            module: 'CI/CD Pipeline'
        },
        {
            name: 'Angular Development',
            status: 'completed',
            startDate: '2025-09-15',
            endDate: '2025-12-10',
            totalStudents: 28,
            trainer: 'Lisa Martinez',
            module: 'Angular 15'
        }
    ];

    return (
        <div className="App">
            <CohortDetails cohorts={cohorts} />
        </div>
    );
}

export default App;