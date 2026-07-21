import React, { Component } from 'react';

class SyntheticEvent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            clickMessage: '',
            eventType: ''
        };
        
        // Binding this keyword
        this.handleClick = this.handleClick.bind(this);
        this.handleOnPress = this.handleOnPress.bind(this);
    }

    // Synthetic event handler
    handleClick(event) {
        // SyntheticEvent properties
        console.log('Synthetic Event:', event);
        console.log('Event Type:', event.type);
        console.log('Target:', event.target);
        
        this.setState({
            clickMessage: 'I was clicked! 🖱️',
            eventType: `Event Type: ${event.type}`
        });
    }

    // Another synthetic event handler
    handleOnPress(event) {
        this.setState({
            clickMessage: 'Button was pressed! 🔘',
            eventType: `Event Type: ${event.type}`
        });
    }

    render() {
        return (
            <div style={styles.container}>
                <h2 style={styles.heading}>🎯 Synthetic Events</h2>
                
                <div style={styles.buttonGroup}>
                    <button 
                        onClick={this.handleClick} 
                        style={styles.clickBtn}
                    >
                        Click Me
                    </button>
                    <button 
                        onClick={this.handleOnPress} 
                        style={styles.pressBtn}
                    >
                        OnPress
                    </button>
                </div>

                {this.state.clickMessage && (
                    <div style={styles.messageBox}>
                        <p style={styles.message}>{this.state.clickMessage}</p>
                        <p style={styles.eventTypeText}>{this.state.eventType}</p>
                    </div>
                )}

                <div style={styles.infoBox}>
                    <p style={styles.infoText}>
                        <strong>Synthetic Event Information:</strong><br />
                        • React uses SyntheticEvent - a cross-browser wrapper<br />
                        • Events are named using camelCase (onClick, onSubmit)<br />
                        • Event handlers receive SyntheticEvent object<br />
                        • Check console for event details
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
    buttonGroup: {
        display: 'flex',
        justifyContent: 'center',
        gap: '20px',
        marginBottom: '20px'
    },
    clickBtn: {
        padding: '12px 35px',
        fontSize: '1.1rem',
        backgroundColor: '#3498db',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        transition: 'all 0.3s ease'
    },
    pressBtn: {
        padding: '12px 35px',
        fontSize: '1.1rem',
        backgroundColor: '#e67e22',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        transition: 'all 0.3s ease'
    },
    messageBox: {
        backgroundColor: '#e8f8f5',
        padding: '20px',
        borderRadius: '8px',
        marginTop: '20px',
        textAlign: 'center',
        borderLeft: '4px solid #1abc9c'
    },
    message: {
        margin: '0 0 10px 0',
        fontSize: '1.3rem',
        color: '#0e6655'
    },
    eventTypeText: {
        margin: '0',
        fontSize: '0.9rem',
        color: '#148f77',
        fontStyle: 'italic'
    },
    infoBox: {
        marginTop: '20px',
        padding: '15px',
        backgroundColor: '#eaf2f8',
        borderRadius: '8px',
        borderLeft: '4px solid #2c3e50'
    },
    infoText: {
        margin: '0',
        color: '#1a5276',
        lineHeight: '1.8'
    }
};

export default SyntheticEvent;