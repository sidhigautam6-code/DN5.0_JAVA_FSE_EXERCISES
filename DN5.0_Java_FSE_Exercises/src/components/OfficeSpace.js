import React from 'react';

// OfficeSpace component using JSX
const OfficeSpace = () => {
    // Object to display office details (Name, Rent, Address)
    const office = {
        name: "Tech Hub Office",
        rent: 55000,
        address: "123 Business Park, Mumbai, India"
    };

    // List of Objects for more office space items
    const officeSpaces = [
        {
            id: 1,
            name: "Downtown Business Center",
            rent: 45000,
            address: "456 Commercial Street, Delhi, India",
            image: "https://images.unsplash.com/photo-1497366216548-37526070297c?w=600&h=400&fit=crop"
        },
        {
            id: 2,
            name: "Tech Park Plaza",
            rent: 75000,
            address: "789 IT Park Road, Bangalore, India",
            image: "https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=600&h=400&fit=crop"
        },
        {
            id: 3,
            name: "Corporate Tower",
            rent: 65000,
            address: "321 Financial District, Hyderabad, India",
            image: "https://images.unsplash.com/photo-1541124943474-e78c7f17a646?w=600&h=400&fit=crop"
        },
        {
            id: 4,
            name: "Business Hub",
            rent: 35000,
            address: "654 Industrial Area, Pune, India",
            image: "https://images.unsplash.com/photo-1497366412874-3415097a6e6b?w=600&h=400&fit=crop"
        },
        {
            id: 5,
            name: "Executive Suites",
            rent: 85000,
            address: "987 Premium Location, Chennai, India",
            image: "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=600&h=400&fit=crop"
        }
    ];

    // Function to determine rent color based on value
    const getRentColor = (rent) => {
        return rent < 60000 ? '#ff4444' : '#4CAF50';
    };

    return (
        <div style={{ 
            padding: '20px', 
            fontFamily: 'Arial, sans-serif',
            maxWidth: '1200px',
            margin: '0 auto'
        }}>
            {/* Heading of the page using JSX */}
            <h1 style={{ 
                textAlign: 'center', 
                color: '#2c3e50',
                fontSize: '2.5rem',
                marginBottom: '30px',
                borderBottom: '3px solid #3498db',
                paddingBottom: '10px'
            }}>
                🏢 Office Space Rental App
            </h1>

            {/* Office Details Section */}
            <div style={{
                backgroundColor: '#f8f9fa',
                padding: '20px',
                borderRadius: '10px',
                marginBottom: '30px',
                boxShadow: '0 2px 10px rgba(0,0,0,0.1)'
            }}>
                <h2 style={{ color: '#2c3e50', marginBottom: '15px' }}>Featured Office Space</h2>
                <p><strong>Name:</strong> {office.name}</p>
                <p style={{ color: getRentColor(office.rent) }}>
                    <strong>Rent:</strong> ₹{office.rent.toLocaleString()}/month
                </p>
                <p><strong>Address:</strong> {office.address}</p>
            </div>

            {/* Image Display using JSX attributes */}
            <div style={{ marginBottom: '30px', textAlign: 'center' }}>
                <h2 style={{ color: '#2c3e50', marginBottom: '15px' }}>Office Space Gallery</h2>
                <img 
                    src="https://images.unsplash.com/photo-1497366216548-37526070297c?w=800&h=400&fit=crop"
                    alt="Office Space"
                    style={{
                        width: '100%',
                        maxWidth: '800px',
                        height: 'auto',
                        borderRadius: '10px',
                        boxShadow: '0 4px 15px rgba(0,0,0,0.2)'
                    }}
                />
            </div>

            {/* Loop through office space items using map() */}
            <div>
                <h2 style={{ color: '#2c3e50', marginBottom: '20px' }}>Available Office Spaces</h2>
                <div style={{
                    display: 'grid',
                    gridTemplateColumns: 'repeat(auto-fit, minmax(300px, 1fr))',
                    gap: '20px'
                }}>
                    {officeSpaces.map((space) => (
                        <div 
                            key={space.id}
                            style={{
                                backgroundColor: '#ffffff',
                                borderRadius: '10px',
                                padding: '15px',
                                boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
                                transition: 'transform 0.3s ease',
                                cursor: 'pointer'
                            }}
                            onMouseEnter={(e) => {
                                e.currentTarget.style.transform = 'scale(1.03)';
                            }}
                            onMouseLeave={(e) => {
                                e.currentTarget.style.transform = 'scale(1)';
                            }}
                        >
                            <img 
                                src={space.image}
                                alt={space.name}
                                style={{
                                    width: '100%',
                                    height: '200px',
                                    objectFit: 'cover',
                                    borderRadius: '8px',
                                    marginBottom: '10px'
                                }}
                            />
                            <h3 style={{ color: '#2c3e50', marginBottom: '10px' }}>{space.name}</h3>
                            <p><strong>Address:</strong> {space.address}</p>
                            <p style={{ 
                                color: getRentColor(space.rent),
                                fontWeight: 'bold',
                                fontSize: '1.1rem'
                            }}>
                                <strong>Rent:</strong> ₹{space.rent.toLocaleString()}/month
                            </p>
                        </div>
                    ))}
                </div>
            </div>

            {/* JavaScript Expression in JSX - Display total count */}
            <div style={{
                marginTop: '30px',
                padding: '15px',
                backgroundColor: '#e8f4f8',
                borderRadius: '8px',
                textAlign: 'center'
            }}>
                <p style={{ fontSize: '1.1rem' }}>
                    <strong>Total Office Spaces Available:</strong> {officeSpaces.length} 
                    (Rent ranges from ₹{Math.min(...officeSpaces.map(s => s.rent)).toLocaleString()} 
                    to ₹{Math.max(...officeSpaces.map(s => s.rent)).toLocaleString()})
                </p>
            </div>
        </div>
    );
};

export default OfficeSpace;