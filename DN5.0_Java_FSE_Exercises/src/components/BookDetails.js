import React from 'react';

const BookDetails = () => {
    const books = [
        {
            id: 1,
            title: 'The Great Gatsby',
            author: 'F. Scott Fitzgerald',
            year: 1925,
            genre: 'Classic Fiction',
            rating: 4.5,
            image: '📚'
        },
        {
            id: 2,
            title: 'To Kill a Mockingbird',
            author: 'Harper Lee',
            year: 1960,
            genre: 'Literary Fiction',
            rating: 4.8,
            image: '📖'
        },
        {
            id: 3,
            title: '1984',
            author: 'George Orwell',
            year: 1949,
            genre: 'Dystopian Fiction',
            rating: 4.6,
            image: '📕'
        },
        {
            id: 4,
            title: 'Pride and Prejudice',
            author: 'Jane Austen',
            year: 1813,
            genre: 'Romantic Fiction',
            rating: 4.4,
            image: '📗'
        },
        {
            id: 5,
            title: 'The Catcher in the Rye',
            author: 'J.D. Salinger',
            year: 1951,
            genre: 'Coming-of-age Fiction',
            rating: 4.2,
            image: '📘'
        }
    ];

    // Using map() to render multiple components
    const bookList = books.map((book) => (
        <div key={book.id} style={styles.bookCard}>
            <div style={styles.bookIcon}>{book.image}</div>
            <div style={styles.bookInfo}>
                <h3 style={styles.bookTitle}>{book.title}</h3>
                <p style={styles.bookAuthor}>✍️ {book.author}</p>
                <div style={styles.bookMeta}>
                    <span style={styles.bookYear}>📅 {book.year}</span>
                    <span style={styles.bookGenre}>🏷️ {book.genre}</span>
                </div>
                <div style={styles.bookRating}>
                    ⭐ {book.rating} / 5.0
                </div>
            </div>
        </div>
    ));

    return (
        <div style={styles.container}>
            <div style={styles.header}>
                <h2 style={styles.title}>📚 Book Details</h2>
                <span style={styles.count}>Total: {books.length} books</span>
            </div>
            <div style={styles.bookGrid}>
                {bookList}
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
        borderBottom: '3px solid #3498db',
        paddingBottom: '10px'
    },
    title: {
        margin: '0',
        color: '#2c3e50',
        fontSize: '1.8rem'
    },
    count: {
        backgroundColor: '#3498db',
        color: 'white',
        padding: '5px 15px',
        borderRadius: '20px',
        fontSize: '0.9rem'
    },
    bookGrid: {
        display: 'grid',
        gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))',
        gap: '20px'
    },
    bookCard: {
        backgroundColor: 'white',
        padding: '15px',
        borderRadius: '8px',
        boxShadow: '0 2px 8px rgba(0,0,0,0.08)',
        display: 'flex',
        alignItems: 'center',
        gap: '15px',
        transition: 'transform 0.3s ease'
    },
    bookIcon: {
        fontSize: '3rem',
        backgroundColor: '#e8f4f8',
        padding: '10px',
        borderRadius: '8px',
        width: '60px',
        height: '60px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
    },
    bookInfo: {
        flex: 1
    },
    bookTitle: {
        margin: '0 0 5px 0',
        color: '#2c3e50',
        fontSize: '1.1rem'
    },
    bookAuthor: {
        margin: '0 0 8px 0',
        color: '#7f8c8d',
        fontSize: '0.9rem'
    },
    bookMeta: {
        display: 'flex',
        gap: '15px',
        fontSize: '0.8rem',
        color: '#95a5a6',
        marginBottom: '5px'
    },
    bookYear: {
        color: '#5b6c7d'
    },
    bookGenre: {
        color: '#5b6c7d'
    },
    bookRating: {
        color: '#f39c12',
        fontWeight: 'bold'
    }
};

export default BookDetails;