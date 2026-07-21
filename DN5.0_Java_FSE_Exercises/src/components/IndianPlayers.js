import React from 'react';

const IndianPlayers = () => {
    // Destructuring: Odd Team Player and Even Team players
    const team = {
        oddPlayers: ['Rohit Sharma', 'Virat Kohli', 'Suryakumar Yadav', 'Hardik Pandya', 'Ravindra Jadeja', 'Jasprit Bumrah'],
        evenPlayers: ['KL Rahul', 'Shubman Gill', 'Axar Patel', 'Mohammed Shami', 'Yuzvendra Chahal']
    };

    // Destructuring the team object
    const { oddPlayers, evenPlayers } = team;

    // Merge feature: Declare two arrays and merge them
    const T20players = ['Virat Kohli', 'Rohit Sharma', 'KL Rahul', 'Suryakumar Yadav', 'Hardik Pandya'];
    const RanjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Ravichandran Ashwin', 'Shardul Thakur'];
    
    // Using spread operator to merge arrays
    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

    return (
        <div style={{ padding: '20px', fontFamily: 'Arial' }}>
            <h2>Indian Players</h2>

            <h3>Odd Team Players:</h3>
            <ul>
                {oddPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>

            <h3>Even Team Players:</h3>
            <ul>
                {evenPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>

            <h3>Merged Players (T20 + Ranji Trophy):</h3>
            <ul>
                {mergedPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>
        </div>
    );
};

export default IndianPlayers;