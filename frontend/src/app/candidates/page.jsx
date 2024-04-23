'use client'
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import CandidateForm from '../components/CandidateForm/CandidateForm';

export default function Candidates() {
    const [candidates, setCandidates] = useState([]);

    useEffect(() => {
        const fetchCandidates = async () => {
            try {
                const response = await getAllCandidates();
                setCandidates(response);
            } catch (error) {
                console.error('Error fetching candidates:', error);
            }
        };

        fetchCandidates();
    }, []);

    const getAllCandidates = async () => {
        try {
            const response = await axios.get('/api/candidates');
            return response.data;
        } catch (error) {
            console.error('Error fetching candidates:', error);
            return [];
        }
    };

    const vote = async (candidate_id) => {
        try {
            const response = await axios.post(`/api/candidates/${candidate_id}/vote`);
            if (!response.ok) {
                throw new Error('Failed to vote');
            }
            const updatedCandidates = candidates.map(candidate =>
                candidate.candidate_id === candidate_id ? { ...candidate, votes: candidate.votes + 1 } : candidate
            );
            setCandidates(updatedCandidates);
        } catch (error) {
            console.error('Error voting:', error);
        }
    };

    return (
        <div>
            <h1 className="text-4xl font-bold text-center mb-4">Get to know your candidates!</h1>
            <div className="max-w-4xl mx-auto">
                {candidates.map(candidate => (
                    <CandidateForm key={candidate.candidate_id} candidate={candidate} onVote={vote} />
                ))}
            </div>
        </div>
    );
}

