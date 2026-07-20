// Import React
import React from 'react';
// Import CSS file for styling
import '../Stylesheets/mystyle.css';

// Create function component
const CalculateScore = (props) => {
    // Calculate average
    const average = props.Total / props.goal;
    
    return (
        <div className="score-card">
            <h2>Student Score Report</h2>
            <div className="student-info">
                <p><strong>Name:</strong> {props.Name}</p>
                <p><strong>School:</strong> {props.School}</p>
                <p><strong>Total Score:</strong> {props.Total}</p>
                <p><strong>Goal:</strong> {props.goal}</p>
                <p><strong>Average Score:</strong> {average.toFixed(2)}</p>
            </div>
            <div className="result">
                {average >= 50 ? (
                    <p className="pass">✅ Status: Pass</p>
                ) : (
                    <p className="fail">❌ Status: Fail</p>
                )}
            </div>
        </div>
    );
};

// Export the component
export default CalculateScore;