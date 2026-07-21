import React from 'react';

const ListofPlayers = () => {
    // Declare array with 11 players using map feature
    const players = [
        { name: 'Virat Kohli', score: 89 },
        { name: 'Rohit Sharma', score: 72 },
        { name: 'KL Rahul', score: 45 },
        { name: 'Suryakumar Yadav', score: 95 },
        { name: 'Shubman Gill', score: 68 },
        { name: 'Hardik Pandya', score: 55 },
        { name: 'Ravindra Jadeja', score: 78 },
        { name: 'Jasprit Bumrah', score: 12 },
        { name: 'Mohammed Shami', score: 8 },
        { name: 'Yuzvendra Chahal', score: 4 },
        { name: 'Axar Patel', score: 63 }
    ];

    // Filter players with scores below 70 using arrow functions
    const lowScorers = players.filter(player => player.score < 70);

    return (
        <div style={{ padding: '20px', fontFamily: 'Arial' }}>
            <h2>List of Players</h2>
            
            <h3>All Players:</h3>
            <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', marginBottom: '20px' }}>
                <thead>
                    <tr style={{ backgroundColor: '#4CAF50', color: 'white' }}>
                        <th>Player Name</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    {players.map((player, index) => (
                        <tr key={index}>
                            <td>{player.name}</td>
                            <td>{player.score}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <h3>Players with Score Below 70:</h3>
            <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse' }}>
                <thead>
                    <tr style={{ backgroundColor: '#f44336', color: 'white' }}>
                        <th>Player Name</th>
                        <th>Score</th>
                    </tr>
                </thead>
                <tbody>
                    {lowScorers.map((player, index) => (
                        <tr key={index}>
                            <td>{player.name}</td>
                            <td>{player.score}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ListofPlayers;