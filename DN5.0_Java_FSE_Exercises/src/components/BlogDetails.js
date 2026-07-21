import React from 'react';

const BlogDetails = () => {
    const blogs = [
        {
            id: 1,
            title: 'Getting Started with React',
            author: 'Jane Smith',
            date: 'Jan 15, 2024',
            category: 'Technology',
            likes: 234,
            comments: 45,
            image: '💻'
        },
        {
            id: 2,
            title: 'The Art of Minimalist Living',
            author: 'John Doe',
            date: 'Jan 20, 2024',
            category: 'Lifestyle',
            likes: 189,
            comments: 32,
            image: '🏠'
        },
        {
            id: 3,
            title: 'Understanding Climate Change',
            author: 'Sarah Johnson',
            date: 'Jan 25, 2024',
            category: 'Environment',
            likes: 412,
            comments: 78,
            image: '🌍'
        },
        {
            id: 4,
            title: 'Mastering JavaScript',
            author: 'Mike Wilson',
            date: 'Jan 28, 2024',
            category: 'Programming',
            likes: 567,
            comments: 92,
            image: '⚛️'
        },
        {
            id: 5,
            title: 'Healthy Eating Habits',
            author: 'Emily Brown',
            date: 'Feb 1, 2024',
            category: 'Health',
            likes: 156,
            comments: 28,
            image: '🥗'
        }
    ];

    // Using map() to render blog posts
    const blogList = blogs.map((blog) => (
        <div key={blog.id} style={styles.blogCard}>
            <div style={styles.blogIcon}>{blog.image}</div>
            <div style={styles.blogContent}>
                <h3 style={styles.blogTitle}>{blog.title}</h3>
                <div style={styles.blogMeta}>
                    <span style={styles.blogAuthor}>✍️ {blog.author}</span>
                    <span style={styles.blogDate}>📅 {blog.date}</span>
                    <span style={styles.blogCategory}>🏷️ {blog.category}</span>
                </div>
                <div style={styles.blogStats}>
                    <span>❤️ {blog.likes} likes</span>
                    <span>💬 {blog.comments} comments</span>
                </div>
            </div>
        </div>
    ));

    return (
        <div style={styles.container}>
            <div style={styles.header}>
                <h2 style={styles.title}>📝 Blog Details</h2>
                <span style={styles.count}>Total: {blogs.length} posts</span>
            </div>
            <div style={styles.blogList}>
                {blogList}
            </div>
        </div>
    );
};

const styles = {
    container: {
        backgroundColor: '#f8f9fa',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 4px 15px rgba(0,0,0,0.1)',
        marginBottom: '20px'
    },
    header: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        marginBottom: '20px',
        borderBottom: '3px solid #e74c3c',
        paddingBottom: '10px'
    },
    title: {
        margin: '0',
        color: '#2c3e50',
        fontSize: '1.8rem'
    },
    count: {
        backgroundColor: '#e74c3c',
        color: 'white',
        padding: '5px 15px',
        borderRadius: '20px',
        fontSize: '0.9rem'
    },
    blogList: {
        display: 'flex',
        flexDirection: 'column',
        gap: '15px'
    },
    blogCard: {
        backgroundColor: 'white',
        padding: '15px',
        borderRadius: '8px',
        boxShadow: '0 2px 8px rgba(0,0,0,0.08)',
        display: 'flex',
        alignItems: 'center',
        gap: '20px',
        transition: 'transform 0.3s ease'
    },
    blogIcon: {
        fontSize: '2.5rem',
        backgroundColor: '#fde8e8',
        padding: '10px',
        borderRadius: '50%',
        width: '60px',
        height: '60px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        flexShrink: 0
    },
    blogContent: {
        flex: 1
    },
    blogTitle: {
        margin: '0 0 8px 0',
        color: '#2c3e50',
        fontSize: '1.1rem'
    },
    blogMeta: {
        display: 'flex',
        gap: '15px',
        fontSize: '0.85rem',
        color: '#7f8c8d',
        marginBottom: '8px',
        flexWrap: 'wrap'
    },
    blogAuthor: {
        color: '#3498db'
    },
    blogDate: {
        color: '#95a5a6'
    },
    blogCategory: {
        backgroundColor: '#e8f4f8',
        padding: '2px 10px',
        borderRadius: '12px',
        color: '#2c3e50'
    },
    blogStats: {
        display: 'flex',
        gap: '20px',
        fontSize: '0.9rem',
        color: '#5b6c7d'
    }
};

export default BlogDetails;