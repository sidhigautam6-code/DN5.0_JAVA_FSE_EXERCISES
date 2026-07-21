import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        // Initial state
        this.state = {
            count: 0,
            message: ''
        };
        
        // Binding this keyword to methods
        this.increment = this.increment.bind(this);
        this.decrement = this.decrement.bind(this);
        this.sayHello = this.sayHello.bind(this);
        this.handleMultipleMethods = this.handleMultipleMethods.bind(this);
    }

    // Method to increment the value
    increment() {
        this.setState((prevState) => ({
            count: prevState.count + 1
        }));
    }

    // Method to decrement the value
    decrement() {
        this.setState((prevState) => ({
            count: prevState.count - 1
        }));
    }

    // Method to say Hello with static message
    sayHello() {
        this.setState({
            message: 'Hello! Welcome to React Event Handling! 🎉'
        });
    }

    // Method that invokes multiple methods
    handleMultipleMethods() {
        this.increment();
        this.sayHello();
    }

    render() {
        return (
            <div style={styles.container}>
                <h2 style={styles.heading}>📊 Counter with Event Handling</h2>
                
                <div style={styles.counterDisplay}>
                    <h1 style={styles.count}>{this.state.count}</h1>
                </div>

                <div style={styles.buttonGroup}>
                    <button 
                        onClick={this.handleMultipleMethods} 
                        style={styles.incrementBtn}
                    >
                        ➕ Increment
                    </button>
                    <button 
                        onClick={this.decrement} 
                        style={styles.decrementBtn}
                    >
                        ➖ Decrement
                    </button>
                </div>

                {this.state.message && (
                    <div style={styles.messageBox}>
                        <p style={styles.message}>{this.state.message}</p>
                    </div>
                )}

                <div style={styles.infoBox}>
                    <p style={styles.infoText}>
                        <strong>Note:</strong> Increment button invokes multiple methods:
                        <br />
                        1. Increment the counter value
                        <br />
                        2. Say Hello with static message
                    </p>
                </div>
            </div>
        );
    }
}

// Inline styles
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
    counterDisplay: {
        backgroundColor: '#ffffff',
        padding: '20px',
        borderRadius: '8px',
        textAlign: 'center',
        marginBottom: '20px',
        boxShadow: 'inset 0 2px 5px rgba(0,0,0,0.05)'
    },
    count: {
        fontSize: '4rem',
        color: '#3498db',
        margin: '0'
    },
    buttonGroup: {
        display: 'flex',
        justifyContent: 'center',
        gap: '15px',
        marginBottom: '20px'
    },
    incrementBtn: {
        padding: '12px 30px',
        fontSize: '1.1rem',
        backgroundColor: '#2ecc71',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        transition: 'all 0.3s ease'
    },
    decrementBtn: {
        padding: '12px 30px',
        fontSize: '1.1rem',
        backgroundColor: '#e74c3c',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        transition: 'all 0.3s ease'
    },
    messageBox: {
        backgroundColor: '#e8f4f8',
        padding: '15px',
        borderRadius: '8px',
        marginTop: '15px',
        borderLeft: '4px solid #3498db'
    },
    message: {
        margin: '0',
        fontSize: '1.1rem',
        color: '#2c3e50'
    },
    infoBox: {
        marginTop: '20px',
        padding: '15px',
        backgroundColor: '#fff3cd',
        borderRadius: '8px',
        borderLeft: '4px solid #ffc107'
    },
    infoText: {
        margin: '0',
        color: '#856404',
        lineHeight: '1.6'
    }
};

export default Counter;