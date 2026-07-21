import React, { Component } from 'react';
import './App.css';
import ContentSelector from './components/ContentSelector';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            appLoaded: false
        };
    }

    componentDidMount() {
        // Simulate app loading
        setTimeout(() => {
            this.setState({ appLoaded: true });
        }, 300);
    }

    render() {
        const { appLoaded } = this.state;

        // Conditional rendering with element variable
        let appContent;

        if (!appLoaded) {
            appContent = (
                <div style={styles.loadingContainer}>
                    <div style={styles.loadingSpinner}></div>
                    <h2 style={styles.loadingText}>Loading Blogger App...</h2>
                </div>
            );
        } else {
            appContent = <ContentSelector />;
        }

        return (
            <div className="App">
                <div className="App-body">
                    {appContent}
                </div>
                <footer className="App-footer">
                    <p>© 2024 Blogger App | Conditional Rendering Demo</p>
                </footer>
            </div>
        );
    }
}

const styles = {
    loadingContainer: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        height: '100vh',
        color: 'white'
    },
    loadingSpinner: {
        border: '4px solid rgba(255,255,255,0.3)',
        borderTop: '4px solid white',
        borderRadius: '50%',
        width: '50px',
        height: '50px',
        animation: 'spin 1s linear infinite',
        marginBottom: '20px'
    },
    loadingText: {
        fontSize: '1.5rem',
        fontWeight: 'normal'
    }
};

export default App;