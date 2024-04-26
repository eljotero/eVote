'use client'
import React from 'react';

function MapPage() {
    return (
        <div className="map-page" style={{width: '100%', height: '100vh'}}>
            <iframe src="index.html" style={{width: '100%', height: '100%'}}></iframe>
        </div>
    );
}

export default MapPage;