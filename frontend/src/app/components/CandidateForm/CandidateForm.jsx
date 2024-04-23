import React, { useState } from 'react';

export default function CandidateForm({ candidate, onVote }) {
    const { candidate_id, name, votes, image } = candidate;

    const handleVote = () => {
        onVote(candidate_id);
    };

    return (
        <div className="max-w-md w-full bg-white shadow-lg rounded-lg overflow-hidden mb-4">
            <div className="px-4 py-2">
                <div className="flex items-center justify-between">
                    <div className="flex items-center">
                        <img src={image} alt={name} className="w-12 h-12 rounded-full" />
                        <p className="ml-4 font-bold">{name}</p>
                    </div>
                    <button onClick={handleVote} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                        Vote
                    </button>
                </div>
                <p className="text-gray-600 mt-2">{votes} votes</p>
            </div>
        </div>
    );
}
