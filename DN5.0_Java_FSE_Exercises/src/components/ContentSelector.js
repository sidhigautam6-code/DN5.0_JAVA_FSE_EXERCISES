import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

const ContentSelector = () => {
    // State to track selected content type
    const [selectedContent, setSelectedContent] = useState('books');
    const [isLoading, setIsLoading] = useState(false);
    const [showAll, setShowAll] = useState(false);

    // Method 1: Using element variables
    let contentToRender;
    
    if (showAll) {
        // Render all components
        contentToRender = (
            <div style={styles.allContent}>
                <div style={styles.contentSection}>
                    <BookDetails />
                </div>
                <div style={styles.contentSection}>
                    <BlogDetails />
                </div>
                <div style={styles.contentSection}>
                    <CourseDetails />
                </div>
            </div>
        );
    } else {
        // Render selected component
        switch (selectedContent) {
            case 'books':
                contentToRender = <BookDetails />;
                break;
            case 'blogs':
                contentToRender = <BlogDetails />;
                break;
            case 'courses':
                contentToRender = <CourseDetails />;
                break;
            default:
                contentToRender = <BookDetails />;
        }
    }

    // Method 2: Using inline conditional rendering with logical && operator
    const renderLoader = isLoading && (
        <div style={styles.loader}>
            <div style={styles.spinner}></div>
            <p>Loading content...</p>
        </div>
    );

    // Method 3: Using ternary operator for button states
    const buttonStyle = (type) => ({
        ...styles.navBtn,
        backgroundColor: selectedContent === type ? '#3498db' : '#ecf0f1',
        color: selectedContent === type ? 'white' : '#2c3e50'
    });

    // Method 4: Conditional rendering with && operator
    const showContent = !isLoading && contentToRender;

    return (
        <div style={styles.container}>
            <div style={styles.navHeader}>
                <h1 style={styles.mainTitle}>📱 Blogger App</h1>
                <p style={styles.subtitle}>Multiple Ways of Conditional Rendering</p>
            </div>

            {/* Navigation Tabs */}
            <div style={styles.navTabs}>
                <button 
                    onClick={() => {
                        setSelectedContent('books');
                        setShowAll(false);
                        setIsLoading(true);
                        setTimeout(() => setIsLoading(false), 500);
                    }}
                    style={buttonStyle('books')}
                >
                    📚 Books
                </button>
                <button 
                    onClick={() => {
                        setSelectedContent('blogs');
                        setShowAll(false);
                        setIsLoading(true);
                        setTimeout(() => setIsLoading(false), 500);
                    }}
                    style={buttonStyle('blogs')}
                >
                    📝 Blogs
                </button>
                <button 
                    onClick={() => {
                        setSelectedContent('courses');
                        setShowAll(false);
                        setIsLoading(true);
                        setTimeout(() => setIsLoading(false), 500);
                    }}
                    style={buttonStyle('courses')}
                >
                    🎓 Courses
                </button>
                <button 
                    onClick={() => {
                        setShowAll(!showAll);
                        setIsLoading(true);
                        setTimeout(() => setIsLoading(false), 500);
                    }}
                    style={{
                        ...styles.navBtn,
                        backgroundColor: showAll ? '#27ae60' : '#ecf0f1',
                        color: showAll ? 'white' : '#2c3e50'
                    }}
                >
                    {showAll ? '📋 Show Selected' : '📋 Show All'}
                </button>
            </div>

            {/* Display loading indicator */}
            {renderLoader}

            {/* Display content */}
            {showContent}

            {/* Display info about current rendering method */}
            <div style={styles.infoBox}>
                <h4 style={styles.infoTitle}>🔄 Conditional Rendering Methods Used:</h4>
                <div style={styles.infoGrid}>
                    <div style={styles.infoItem}>
                        <strong>1. Element Variables</strong>
                        <p>Using variables to store JSX content</p>
                    </div>
                    <div style={styles.infoItem}>
                        <strong>2. Switch Statements</strong>
                        <p>Using switch for multiple content types</p>
                    </div>
                    <div style={styles.infoItem}>
                        <strong>3. Ternary Operator</strong>
                        <p>Used for dynamic styling of buttons</p>
                    </div>
                    <div style={styles.infoItem}>
                        <strong>4. Logical && Operator</strong>
                        <p>Used for conditional loading and content</p>
                    </div>
                    <div style={styles.infoItem}>
                        <strong>5. Map() Function</strong>
                        <p>Used in all components for rendering lists</p>
                    </div>
                    <div style={styles.infoItem}>
                        <strong>6. Keys in React</strong>
                        <p>Unique keys provided to list items</p>
                    </div>
                </div>
            </div>
        </div>
    );
};

const styles = {
    container: {
        maxWidth: '1200px',
        margin: '0 auto',
        padding: '20px'
    },
    navHeader: {
        textAlign: 'center',
        marginBottom: '30px',
        color: 'white'
    },
    mainTitle: {
        fontSize: '2.5rem',
        margin: '0',
        textShadow: '2px 2px 4px rgba(0,0,0,0.3)'
    },
    subtitle: {
        fontSize: '1.1rem',
        opacity: 0.9,
        margin: '5px 0 0 0'
    },
    navTabs: {
        display: 'flex',
        gap: '10px',
        justifyContent: 'center',
        marginBottom: '30px',
        flexWrap: 'wrap'
    },
    navBtn: {
        padding: '12px 25px',
        border: 'none',
        borderRadius: '5px',
        fontSize: '1rem',
        cursor: 'pointer',
        transition: 'all 0.3s ease',
        fontWeight: 'bold'
    },
    allContent: {
        display: 'flex',
        flexDirection: 'column',
        gap: '30px'
    },
    contentSection: {
        animation: 'fadeIn 0.5s ease'
    },
    loader: {
        textAlign: 'center',
        padding: '40px',
        backgroundColor: 'white',
        borderRadius: '10px',
        margin: '20px 0',
        boxShadow: '0 4px 15px rgba(0,0,0,0.1)'
    },
    spinner: {
        border: '4px solid #f3f3f3',
        borderTop: '4px solid #3498db',
        borderRadius: '50%',
        width: '40px',
        height: '40px',
        animation: 'spin 1s linear infinite',
        margin: '0 auto'
    },
    infoBox: {
        backgroundColor: 'white',
        padding: '25px',
        borderRadius: '10px',
        marginTop: '30px',
        boxShadow: '0 4px 15px rgba(0,0,0,0.1)'
    },
    infoTitle: {
        margin: '0 0 15px 0',
        color: '#2c3e50'
    },
    infoGrid: {
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))',
        gap: '15px'
    },
    infoItem: {
        padding: '12px',
        backgroundColor: '#f8f9fa',
        borderRadius: '5px',
        borderLeft: '3px solid #3498db'
    }
};

// Adding animations to document
const styleSheet = document.createElement('style');
styleSheet.textContent = `
    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
    
    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }
`;
document.head.appendChild(styleSheet);

export default ContentSelector;