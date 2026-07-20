// Import React
import React from 'react';
// Import the CalculateScore component
import CalculateScore from "./Components/CalculateScore";
// Optional: Keep default App.css or remove it
import './App.css';

function App() {
    return (
        <div className="App">
            <CalculateScore 
                Name="John Doe" 
                School="Springfield High School" 
                Total={450} 
                goal={600} 
            />
            
            {/* You can add more students */}
            <CalculateScore 
                Name="Jane Smith" 
                School="Riverside Academy" 
                Total={320} 
                goal={400} 
            />
        </div>
    );
}

export default App;