import React, { useState, useEffect } from 'react';
import axios from 'axios';

function UserProfile() {
    // Handle the State Management logic
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');


    // Handle the API CALLS
    useEffect(() => {
        setLoading(true);
        axios.get('/api/user/123')
            .then(response => setUser(response.data))
            .catch(error => setError('Error fetching user data'))
            .finally(() => setLoading(false));
    }, []);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>{error}</div>;


    // Handles how the UI looks
    return (
        <div>
            <h1>User Profile</h1>
            {user && (
                <div>
                    <p>Name: {user.name}</p>
                    <p>Email: {user.email}</p>
                    {/* More user details */}
                </div>
            )}
            {/* Additional unrelated UI elements */}
        </div>
    );
}