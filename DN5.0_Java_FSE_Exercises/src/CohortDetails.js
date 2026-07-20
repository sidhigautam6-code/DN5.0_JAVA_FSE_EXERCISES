// src/CohortDetails.js
import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohorts }) => {
    return (
        <div className={styles.container}>
            <h1 className={styles.title}>🎓 Academy Cohort Dashboard</h1>
            <div className={styles.cohortGrid}>
                {cohorts.map((cohort, index) => (
                    <div key={index} className={styles.box}>
                        <h3 
                            className={styles.cohortTitle}
                            style={{ 
                                color: cohort.status === 'ongoing' ? 'green' : 'blue' 
                            }}
                        >
                            {cohort.name}
                        </h3>
                        <dl className={styles.detailsList}>
                            <dt>Status:</dt>
                            <dd>
                                <span 
                                    className={styles.statusBadge}
                                    style={{
                                        backgroundColor: cohort.status === 'ongoing' ? '#4CAF50' : '#2196F3'
                                    }}
                                >
                                    {cohort.status}
                                </span>
                            </dd>
                            
                            <dt>Start Date:</dt>
                            <dd>{cohort.startDate}</dd>
                            
                            <dt>End Date:</dt>
                            <dd>{cohort.endDate}</dd>
                            
                            <dt>Total Students:</dt>
                            <dd>{cohort.totalStudents}</dd>
                            
                            <dt>Trainer:</dt>
                            <dd>{cohort.trainer}</dd>
                            
                            <dt>Module:</dt>
                            <dd>{cohort.module}</dd>
                        </dl>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CohortDetails;