import React from 'react';
import './App.css';
import Counter from './components/Counter';
import WelcomeMessage from './components/WelcomeMessage';
import SyntheticEvent from './components/SyntheticEvent';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>⚛️ React Event Handling Examples</h1>
                <p style={{ color: '#7f8c8d', marginBottom: '30px' }}>
                    Demonstrating various event handlers, synthetic events, and this keyword binding
                </p>
            </header>

            <div className="container">
                <Counter />
                <WelcomeMessage />
                <SyntheticEvent />
                <CurrencyConvertor />
            </div>
        </div>
    );
}

export default App;