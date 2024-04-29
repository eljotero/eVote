'use client'
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import kandydat1 from './kandydat1.jpg';
import CandidateForm from '../components/CandidateForm/CandidateForm';

export default function Candidates() {
    const [candidates, setCandidates] = useState([]);
    const [elections, setElections] = useState([]);
    const [electionType, setElectionType] = useState('parliamentary');
    const [selectedRegion, setSelectedRegion] = useState('');


    useEffect(() => {
        const urlParams = new URLSearchParams(window.location.search);
        const woj = urlParams.get('woj');
        setSelectedRegion(woj || '');
        const fetchCandidates = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/candidates/all');
                const candidatesWithShowPlan = response.data.map(candidate => ({ ...candidate, showPlan: false }));
                setCandidates(candidatesWithShowPlan);
            } catch (error) {
                console.error('Error fetching candidates:', error);
            }
        };

        const fetchElections = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/elections/all');
                setElections(response.data);
            } catch (error) {
                console.error('Error fetching elections:', error);
            }
        };

        fetchCandidates();
        fetchElections();

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
            precinct_id: 1,
            election_id: 2,
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

    const upcomingElections = elections.filter(election => {
        const today = new Date();
        const electionDate = new Date(election.startDate);
        return electionDate >= today;
    });

    const closestDate = Math.min(...upcomingElections.map(election => new Date(election.startDate)));

    const closestElections = upcomingElections.filter(election => {
        const electionDate = new Date(election.startDate);
        return electionDate.getTime() === closestDate;
    });
    const sejmCandidates = candidates.filter(candidate => candidate.election_id === 1);
    const senateCandidates = candidates.filter(candidate => candidate.election_id === 2);
    const closestElectionNames = closestElections.map(election => election.election_name).join(', ');

    return (
        <div className="container mx-auto mt-10">
            <div className="bg-blue-500 text-white text-center py-4 mb-8">
                <h1 className="text-4xl font-bold">Poznaj swoich kandydatów!</h1>
                <h2 className="text-2xl">Region: {selectedRegion} </h2> {}
            </div>
            <div className="bg-blue-500 text-white text-center py-4 mb-8">
                <h1 className="text-1xl font-bold">Najbliższe wybory to: {closestElectionNames ? closestElectionNames : 'Brak nadchodzących wyborów'}</h1>
            </div>
            <div className="flex justify-center mb-4">
                <select onChange={(e) => setElectionType(e.target.value)} className="form-select block w-full mt-1">
                    <option value="parliamentary">Parliamentary Elections</option>
                    <option value="presidential">Presidential Elections</option>
                    <option value="local">Local Elections</option>
                </select>
            </div>
            <div className="flex justify-center mb-4">
                <button onClick={addSampleCandidate} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    Add Sample Candidate
                </button>
            </div>
            <h2>Kandydaci do Sejmu</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
                {sejmCandidates.map(candidate => (
                    <CandidateForm key={candidate.candidate_id} candidate={candidate} onVote={handleShowPlan} />
                ))}
            </div>
            <h2>Kandydaci do Senatu</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
                {senateCandidates.map(candidate => (
                    <CandidateForm key={candidate.candidate_id} candidate={candidate} onVote={handleShowPlan} />
                ))}
            </div>
        </div>
    );
}
