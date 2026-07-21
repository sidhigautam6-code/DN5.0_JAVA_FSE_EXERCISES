import React, { Component } from 'react';

class WelcomeMessage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            welcomeMessage: ''
        };
        
        // Binding this keyword
        this.showWelcome = this.showWelcome.bind(this);
    }

    // Method that takes "welcome" as an argument
    showWelcome(message) {
        this.setState({
            welcomeMessage: `${message}! 👋 Have a great day!`
        });
    }

    render() {
        return (
            <div style={styles.container}>
                <h2 style={styles.heading}>👋 Welcome Message</h2>
                
                <button 
                    onClick={() => this.showWelcome('Welcome')} 
                    style={styles.welcomeBtn}
                >
                    Say Welcome
                </button>

                {this.state.welcomeMessage && (
                    <div style={styles.messageBox}>
                        <p style={styles.message}>{this.state.welcomeMessage}</p>
                    </div>
                )}

                <div style={styles.infoBox}>
                    <p style={styles.infoText}>
                        <strong>Event Handler with Arguments:</strong><br />
                        The button invokes a function that takes "welcome" as an argument.
                    </p>
                </div>
            </div>
        );
    }
}

const styles = {
    container: {
        backgroundColor: '#f8f9fa',
        padding: '30px',
        borderRadius: '10px',
        marginBottom: '30px',
        boxShadow: '0 4px 15px rgba(0,0,0,0.1)',
        maxWidth: '600px',
        margin: '20px auto'
    },
    heading: {
        color: '#2c3e50',
        textAlign: 'center',
        marginBottom: '20px'
    },
    welcomeBtn: {
        padding: '12px 40px',
        fontSize: '1.1rem',
        backgroundColor: '#9b59b6',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        display: 'block',
        margin: '0 auto',
        transition: 'all 0.3s ease',
        width: '200px'
    },
    messageBox: {
        backgroundColor: '#f3e5f5',
        padding: '20px',
        borderRadius: '8px',
        marginTop: '20px',
        textAlign: 'center',
        borderLeft: '4px solid #9b59b6'
    },
    message: {
        margin: '0',
        fontSize: '1.3rem',
        color: '#6a1b9a'
    },
    infoBox: {
        marginTop: '20px',
        padding: '15px',
        backgroundColor: '#e8eaf6',
        borderRadius: '8px',
        borderLeft: '4px solid #3f51b5'
    },
    infoText: {
        margin: '0',
        color: '#1a237e',
        lineHeight: '1.6'
    }
};

export default WelcomeMessage;