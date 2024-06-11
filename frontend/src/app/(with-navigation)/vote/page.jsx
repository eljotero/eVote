'use client';
import {useSelector} from "react-redux";
import React, {useEffect, useState} from "react";
import {toast} from "react-hot-toast";
import {setVotingToken} from "@/store/votingTokenSlice";
import CountdownForm from "@/app/components/Countdown/CountdownForm";
import axios from "../../../../lib/axios";

export default function Vote() {
    const id = useSelector((state) => state.id.value);
    const token = useSelector((state) => state.token.value);
    const [votingCode, setVotingCode] = useState('');
    const [showForm, setShowForm] = useState(false);
    const [elections, setElections] = useState([]);
    const upcomingElectionStartDate = elections.length > 0 ? new Date(elections[0].startDate).toLocaleDateString() : null;

    useEffect(() => {
        const fetchElections = async () => {
            try {
                const response = await axios.get('elections/upcoming');
                setElections(response.data);
            } catch (error) {
                console.error('Error fetching elections:', error);
            }
        };

        fetchElections();
    });


    const handleVoteButton = () => {
        setShowForm(prevState => !prevState);
    }

    const handleSubmitCode = async (e) => {
        e.preventDefault();
        if (votingCode === '') {
            toast.error("Błąd głosowania. Wymagane jest podanie kodu.");
            return;
        }
        try {
            const response = await axios.post(`vote/${id}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            toast.success("Głosowanie zostało zautoryzowane.");
        } catch (e) {
            toast.error("Nie udało się zautoryzować głosowania.");
        }
    }

    const closestElectionNames = elections
        .map((election) => election.election_name)
        .join(', ');

    return (
        <>
            <div className='text-center py-4 mb-8' style={{backgroundColor: '#f0f0f0', borderRadius: '15px'}}>
                <h1 className='text-1xl font-bold' style={{color: '#333'}}>
                    Najbliższe wybory:{' '}
                    {closestElectionNames
                        ? closestElectionNames
                        : 'Brak najbliższych wyborów'}
                </h1>
                {upcomingElectionStartDate && (
                    <p style={{color: '#555'}}>Data rozpoczęcia najbliższych wyborów: {upcomingElectionStartDate}</p>
                )}
                <br/>
                <CountdownForm initialCount={upcomingElectionStartDate} handleVoteButton={handleVoteButton}/>
                {showForm && (
                    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
                        <div className="bg-white -top-28 p-8 rounded-lg shadow-lg max-w-md w-full relative">
                            <button
                                onClick={handleVoteButton}
                                className="absolute top-2 right-2 text-gray-500 hover:text-gray-700"
                            >
                                &times;
                            </button>
                            <h1 className="text-xl font-semibold mb-4">Wpisz kod otrzymany w mailu</h1>
                            <div className="mb-4">
                                <input
                                    type="email"
                                    placeholder="Twój kod"
                                    value={votingCode}
                                    onChange={(e) => setVotingCode(e.target.value)}
                                    className="email-input w-full px-4 py-2 border rounded-lg text-gray-700 focus:border-blue-500"
                                />
                            </div>
                            <button
                                onClick={handleSubmitCode}
                                className="w-full font-semibold bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 focus:outline-none"
                            >
                                Wyślij
                            </button>
                        </div>
                    </div>
                )}
            </div>
        </>
    );
}