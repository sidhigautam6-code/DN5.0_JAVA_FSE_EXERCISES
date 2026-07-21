import React, { useState } from 'react';
import './App.css';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
    // Flag variable to toggle between components
    const [flag, setFlag] = useState(true);

    return (
        <div className="App">
            <header className="App-header">
                <h1>Cricket App</h1>
                
                <div style={{ marginBottom: '20px' }}>
                    <button 
                        onClick={() => setFlag(true)} 
                        style={{ 
                            padding: '10px 20px', 
                            margin: '5px', 
                            backgroundColor: flag ? '#4CAF50' : '#ddd',
                            color: flag ? 'white' : 'black',
                            border: 'none',
                            borderRadius: '5px',
                            cursor: 'pointer'
                        }}
                    >
                        Show Players List
                    </button>
                    <button 
                        onClick={() => setFlag(false)} 
                        style={{ 
                            padding: '10px 20px', 
                            margin: '5px',
                            backgroundColor: !flag ? '#4CAF50' : '#ddd',
                            color: !flag ? 'white' : 'black',
                            border: 'none',
                            borderRadius: '5px',
                            cursor: 'pointer'
                        }}
                    >
                        Show Indian Players
                    </button>
                </div>

                {/* Simple if-else in flag variable */}
                {flag ? <ListofPlayers /> : <IndianPlayers />}
            </header>
        </div>
    );
}

export default App;