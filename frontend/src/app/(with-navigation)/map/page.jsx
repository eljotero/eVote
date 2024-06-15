'use client'
import React from 'react';

export default function MapPage() {
    return (
        <div className="map-page" style={{width: '100%', height: '98vh'}}>
            <iframe src="map.html" style={{width: '100%', height: '100%'}}></iframe>
        </div>
    );
}
