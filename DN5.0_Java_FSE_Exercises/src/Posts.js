// src/Posts.js
import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
    constructor(props) {
        super(props);
        // Initialize state with empty posts array
        this.state = {
            posts: [],
            loading: false,
            error: null
        };
        console.log('Constructor: Component initialized');
    }

    // Method to load posts from API
    loadPosts = async () => {
        try {
            this.setState({ loading: true });
            console.log('Loading posts from API...');
            
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            
            const data = await response.json();
            
            // Create Post objects from the data
            const posts = data.map(post => new Post(
                post.userId,
                post.id,
                post.title,
                post.body
            ));
            
            // Update state with fetched posts
            this.setState({ 
                posts: posts,
                loading: false 
            });
            
            console.log('Posts loaded successfully:', posts.length);
        } catch (error) {
            console.error('Error loading posts:', error);
            this.setState({ 
                error: error.message,
                loading: false 
            });
        }
    }

    // Lifecycle hook: Called after component mounts
    componentDidMount() {
        console.log('componentDidMount: Component mounted');
        // Call loadPosts to fetch data
        this.loadPosts();
    }

    // Lifecycle hook: Catch errors in child components
    componentDidCatch(error, errorInfo) {
        console.log('componentDidCatch: Error caught');
        console.error('Error:', error);
        console.error('Error Info:', errorInfo);
        
        // Display error as alert message
        alert(`Error in Posts Component: ${error.message}`);
        
        // Update state to show error
        this.setState({ 
            error: `Component Error: ${error.message}` 
        });
    }

    // Render method to display posts
    render() {
        console.log('Render: Rendering component');
        
        const { posts, loading, error } = this.state;

        // Show loading state
        if (loading) {
            return (
                <div style={styles.loadingContainer}>
                    <h2>📚 Blog Posts</h2>
                    <div style={styles.loader}>Loading posts...</div>
                </div>
            );
        }

        // Show error state
        if (error) {
            return (
                <div style={styles.errorContainer}>
                    <h2>⚠️ Error Loading Posts</h2>
                    <p style={styles.errorText}>{error}</p>
                    <button 
                        onClick={this.loadPosts}
                        style={styles.retryButton}
                    >
                        Retry
                    </button>
                </div>
            );
        }

        // Show posts
        return (
            <div style={styles.container}>
                <h1 style={styles.header}>📝 Blog Posts</h1>
                <p style={styles.subHeader}>Total Posts: {posts.length}</p>
                
                <div style={styles.postsContainer}>
                    {posts.map(post => (
                        <div key={post.id} style={styles.postCard}>
                            <h3 style={styles.postTitle}>
                                {post.id}. {post.title}
                            </h3>
                            <p style={styles.postBody}>{post.body}</p>
                            <div style={styles.postFooter}>
                                <span style={styles.userId}>User ID: {post.userId}</span>
                                <span style={styles.postId}>Post ID: {post.id}</span>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        );
    }
}

// Styles for the component
const styles = {
    container: {
        maxWidth: '800px',
        margin: '0 auto',
        padding: '20px',
        fontFamily: 'Arial, sans-serif'
    },
    header: {
        color: '#2c3e50',
        textAlign: 'center',
        borderBottom: '3px solid #3498db',
        paddingBottom: '10px'
    },
    subHeader: {
        textAlign: 'center',
        color: '#7f8c8d',
        marginBottom: '30px'
    },
    postsContainer: {
        display: 'flex',
        flexDirection: 'column',
        gap: '20px'
    },
    postCard: {
        backgroundColor: '#ffffff',
        borderRadius: '8px',
        padding: '20px',
        boxShadow: '0 2px 4px rgba(0,0,0,0.1)',
        border: '1px solid #e1e8ed',
        transition: 'transform 0.2s'
    },
    postTitle: {
        color: '#2c3e50',
        marginTop: '0',
        marginBottom: '10px'
    },
    postBody: {
        color: '#34495e',
        lineHeight: '1.6',
        marginBottom: '15px'
    },
    postFooter: {
        display: 'flex',
        justifyContent: 'space-between',
        fontSize: '12px',
        color: '#95a5a6',
        borderTop: '1px solid #ecf0f1',
        paddingTop: '10px'
    },
    userId: {
        backgroundColor: '#ecf0f1',
        padding: '2px 8px',
        borderRadius: '12px'
    },
    postId: {
        backgroundColor: '#ecf0f1',
        padding: '2px 8px',
        borderRadius: '12px'
    },
    loadingContainer: {
        textAlign: 'center',
        padding: '50px'
    },
    loader: {
        fontSize: '18px',
        color: '#3498db',
        animation: 'pulse 1.5s ease-in-out infinite'
    },
    errorContainer: {
        textAlign: 'center',
        padding: '40px',
        backgroundColor: '#fdf2f2',
        borderRadius: '8px',
        margin: '20px'
    },
    errorText: {
        color: '#e74c3c',
        marginBottom: '20px'
    },
    retryButton: {
        backgroundColor: '#3498db',
        color: 'white',
        border: 'none',
        padding: '10px 20px',
        borderRadius: '5px',
        cursor: 'pointer',
        fontSize: '16px'
    }
};

export default Posts;