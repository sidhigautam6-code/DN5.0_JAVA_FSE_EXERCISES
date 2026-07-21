import React, { Component } from 'react';

class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rupees: '',
            euro: '',
            convertedAmount: '',
            conversionRate: 0.011, // 1 INR = 0.011 EUR (approximate)
            error: ''
        };
        
        // Binding this keyword to methods
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.convertCurrency = this.convertCurrency.bind(this);
    }

    // Handle input change
    handleChange(event) {
        const value = event.target.value;
        // Allow only numbers and decimal point
        if (value === '' || /^\d*\.?\d*$/.test(value)) {
            this.setState({
                rupees: value,
                error: ''
            });
        }
    }

    // Handle form submission (Click event)
    handleSubmit(event) {
        event.preventDefault(); // Prevent page refresh
        this.convertCurrency();
    }

    // Convert currency method
    convertCurrency() {
        const { rupees, conversionRate } = this.state;
        
        if (!rupees || parseFloat(rupees) <= 0) {
            this.setState({
                error: 'Please enter a valid amount in Rupees',
                convertedAmount: ''
            });
            return;
        }

        const amountInRupees = parseFloat(rupees);
        const amountInEuro = amountInRupees * conversionRate;
        
        this.setState({
            convertedAmount: amountInEuro.toFixed(2),
            error: ''
        });
    }

    render() {
        return (
            <div style={styles.container}>
                <h2 style={styles.heading}>💱 Currency Convertor</h2>
                <p style={styles.subheading}>Indian Rupee (INR) to Euro (EUR)</p>

                <form onSubmit={this.handleSubmit} style={styles.form}>
                    <div style={styles.inputGroup}>
                        <label style={styles.label}>
                            Amount in Rupees (₹):
                        </label>
                        <input
                            type="text"
                            value={this.state.rupees}
                            onChange={this.handleChange}
                            placeholder="Enter amount in INR"
                            style={styles.input}
                        />
                    </div>

                    <button 
                        type="submit" 
                        style={styles.convertBtn}
                    >
                        Convert to Euro
                    </button>

                    {this.state.error && (
                        <div style={styles.errorBox}>
                            <p style={styles.errorText}>{this.state.error}</p>
                        </div>
                    )}

                    {this.state.convertedAmount && !this.state.error && (
                        <div style={styles.resultBox}>
                            <p style={styles.resultText}>
                                💰 {this.state.rupees} INR = €{this.state.convertedAmount} EUR
                            </p>
                            <p style={styles.rateText}>
                                Conversion Rate: 1 INR = {this.state.conversionRate} EUR
                            </p>
                        </div>
                    )}
                </form>

                <div style={styles.infoBox}>
                    <p style={styles.infoText}>
                        <strong>Event Handling:</strong><br />
                        • Click event on "Convert" button triggers handleSubmit<br />
                        • handleSubmit prevents default form behavior<br />
                        • Input change event updates state in real-time
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
        maxWidth: '500px',
        margin: '20px auto'
    },
    heading: {
        color: '#2c3e50',
        textAlign: 'center',
        marginBottom: '5px'
    },
    subheading: {
        textAlign: 'center',
        color: '#7f8c8d',
        marginBottom: '25px'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '15px'
    },
    inputGroup: {
        display: 'flex',
        flexDirection: 'column',
        gap: '5px'
    },
    label: {
        fontSize: '1rem',
        fontWeight: 'bold',
        color: '#2c3e50'
    },
    input: {
        padding: '12px',
        fontSize: '1rem',
        border: '2px solid #bdc3c7',
        borderRadius: '5px',
        transition: 'border-color 0.3s ease',
        outline: 'none'
    },
    convertBtn: {
        padding: '12px',
        fontSize: '1.1rem',
        backgroundColor: '#27ae60',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        transition: 'all 0.3s ease',
        fontWeight: 'bold'
    },
    errorBox: {
        backgroundColor: '#fde8e8',
        padding: '12px',
        borderRadius: '5px',
        borderLeft: '4px solid #e74c3c'
    },
    errorText: {
        margin: '0',
        color: '#c0392b'
    },
    resultBox: {
        backgroundColor: '#e8f8f5',
        padding: '20px',
        borderRadius: '5px',
        textAlign: 'center',
        borderLeft: '4px solid #1abc9c'
    },
    resultText: {
        margin: '0 0 8px 0',
        fontSize: '1.2rem',
        fontWeight: 'bold',
        color: '#0e6655'
    },
    rateText: {
        margin: '0',
        fontSize: '0.9rem',
        color: '#148f77'
    },
    infoBox: {
        marginTop: '20px',
        padding: '15px',
        backgroundColor: '#ebf5fb',
        borderRadius: '8px',
        borderLeft: '4px solid #2980b9'
    },
    infoText: {
        margin: '0',
        color: '#1a5276',
        lineHeight: '1.8'
    }
};

// Add hover effects with CSS
// These will be applied via className in App.css
export default CurrencyConvertor;