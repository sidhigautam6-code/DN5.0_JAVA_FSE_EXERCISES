import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import TrainerList from './components/TrainerList';
import TrainerDetails from './components/TrainerDetails';
import trainersData from './data/TrainersMock';
import './App.css';

function App() {
    return (
        <BrowserRouter>
            <div className="app">
                <nav className="navbar">
                    <div className="nav-container">
                        <div className="nav-brand">
                            <h1>TrainersApp</h1>
                        </div>
                        <ul className="nav-links">
                            <li>
                                <Link to="/">Home</Link>
                            </li>
                            <li>
                                <Link to="/trainers">Trainers</Link>
                            </li>
                        </ul>
                    </div>
                </nav>

                <main className="main-content">
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/trainers" element={<TrainerList trainers={trainersData} />} />
                        <Route path="/trainer/:id" element={<TrainerDetails trainers={trainersData} />} />
                    </Routes>
                </main>

                <footer className="footer">
                    <p>&copy; 2024 Cognizant Academy. All rights reserved.</p>
                </footer>
            </div>
        </BrowserRouter>
    );
}

export default App;