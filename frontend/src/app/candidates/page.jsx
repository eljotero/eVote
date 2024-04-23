'use client'
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import kandydat1 from './kandydat1.jpg';
import CandidateForm from '../components/CandidateForm/CandidateForm';

export default function Candidates() {
    const [candidates, setCandidates] = useState([]);

    useEffect(() => {
        const fetchCandidates = async () => {
            try {
                const response = await axios.get('/api/candidates');
                const candidatesWithShowPlan = response.data.map(candidate => ({ ...candidate, showPlan: false }));
                setCandidates(candidatesWithShowPlan);
            } catch (error) {
                console.error('Error fetching candidates:', error);
            }
        };

        fetchCandidates();
    }, []);

    const addSampleCandidate = () => {
        const sampleCandidate = {
            candidate_id: 1,
            name: 'John',
            surname: 'Doe',
            birthDate: '2000-01-01',
            education: "Bachelor's Degree",
            profession: 'Software Engineer',
            political_party: 'Prawo i Sprawiedliwość',
            image: kandydat1,
            showPlan: false,
        };
        setCandidates(prevCandidates => [...prevCandidates, sampleCandidate]);
    };

    const handleShowPlan = (candidateId) => {
        const updatedCandidates = candidates.map(candidate =>
            candidate.candidate_id === candidateId ? { ...candidate, showPlan: !candidate.showPlan } : candidate
        );
        setCandidates(updatedCandidates);
    };

    return (
        <div className="container mx-auto mt-10">
            <h1 className="text-4xl font-bold text-center mb-8">Get to know your candidates!</h1>
            <div className="flex justify-center mb-4">
                <button onClick={addSampleCandidate} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    Add Sample Candidate
                </button>
            </div>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
                {candidates.map(candidate => (
                    <CandidateForm key={candidate.candidate_id} candidate={candidate} onVote={handleShowPlan} />
                ))}
            </div>
        </div>
    );
}