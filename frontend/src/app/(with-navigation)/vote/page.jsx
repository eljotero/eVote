'use client';
import {useDispatch, useSelector} from "react-redux";
import React, {use, useEffect, useState} from "react";
import {toast} from "react-hot-toast";
import {setVotingToken} from "@/store/votingTokenSlice";
import CountdownForm from "@/app/components/Countdown/CountdownForm";
import axios from "../../../../lib/axios";
import Image from "next/image";

export default function Vote() {
    const id = useSelector((state) => state.id.value);
    const token = useSelector((state) => state.token.value);
    const dispatch = useDispatch();
    const [votingCode, setVotingCode] = useState('');
    const [showForm, setShowForm] = useState(false);
    const [elections, setElections] = useState([]);
    const [precincts, setPrecincts] = useState([]);
    const [politicalParties, setPoliticalParties] = useState([]);
    const [candidatesByElection, setCandidatesByElection] = useState({});
    const [user, setUser] = useState({});
    const [selectedCandidateId, setSelectedCandidateId] = useState(null);
    const upcomingElectionStartDate = elections.map(election => new Date(election.startDate).toLocaleDateString());

    useEffect(() => {
        const fetchAccount = async () => {
            const res = await axios.get(`account/${id}`, { 
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            setUser(res.data);
        };
        fetchAccount();
    }, [id, token]);
    
    useEffect(() => {
        const fetchPrecincts = async () => {
            console.log(user);
            try {
                const response = await axios.get('http://localhost:8080/api/precinct/all');
                const precincts = response.data;
                const matchingPrecinctIds = precincts
                  .filter(precinct => precinct.availableCities.includes(user.city))
                  .map(precinct => precinct.precinct_id);
                setPrecincts(matchingPrecinctIds)
            } catch (error) {
                console.error('Error fetching precincts:', error);
            }
        };
        fetchPrecincts();
    }, [user])

    useEffect(() => {
        const fetchPoliticalParties = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/political_parties/all');
                setPoliticalParties(response.data);
            } catch (error) {
                console.error('Error fetching political parties:', error);
            }
        };
        fetchPoliticalParties();
    }, [])

    useEffect(() => {
        const fetchCandidates = async () => {
            try {
                let newCandidatesByElection = {};
                for (const precinctId of precincts) {
                    for (const election of elections) {
                        const response = await axios.get(`http://localhost:8080/api/candidates/filtered?electionId=${election.election_id}&precinctId=${precinctId}`);
                        const candidates = response.data;
                        if (newCandidatesByElection[election.election_id]) {
                            newCandidatesByElection[election.election_id] = [...newCandidatesByElection[election.election_id], ...candidates];
                        } else {
                            newCandidatesByElection[election.election_id] = candidates;
                        }
                    }
                }
                console.log(newCandidatesByElection);
                setCandidatesByElection(newCandidatesByElection);
            } catch (error) {
                console.error('Error fetching candidates:', error);
            }
        };
        fetchCandidates();
    }, [precincts, elections]);

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
    }, []);
    
    const verifyVotingCode = async () => {
        if (votingCode === '') {
            toast.error("Błąd głosowania. Wymagane jest podanie kodu.");
            return;
        }
        try {
            const response = await axios.post(`vote/voteToken`, { code: votingCode }, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            const newVotingToken = response.data;
            dispatch(setVotingToken(newVotingToken));
            toast.success("Głosowanie zostało zautoryzowane.");
            submitVote(newVotingToken);
        } catch (e) {
            toast.error("Nie udało się zautoryzować głosowania.");
        }
    }


    const submitVote = async (votingToken) => {
        if (!votingToken || votingToken === '') {
            toast.error("Nie można głosować bez autoryzacji.");
            return; 
        }
    
        try {
            const response = await axios.post(`vote/vote`, {
              "votes": [
                    {
                        "candidate_id": selectedCandidateId,
                        "electionId": candidates.find(candidate => candidate.candidate_id === selectedCandidateId).election_id,
                    }
                ]
            }, {
                headers: {
                    Authorization: `Bearer ${token}`, 
                },
            });
    
            if (response.status === 200) {
                toast.success("Głos został oddany pomyślnie.");
            } else {
                toast.error("Nie udało się oddać głosu.");
            }
        } catch (e) {
            toast.error("Wystąpił błąd podczas głosowania.");
        }
    }
    
    const handleVoteClick = (candidateId) => {
        const selectedCandidateElection = candidates.find(candidate => candidate.candidate_id === candidateId);
        const electionStartDate = new Date(selectedCandidateElection.startDate);
    
        if (new Date() < electionStartDate) {
            return;
        }
    
        setSelectedCandidateId(candidateId);
        setShowForm(true);
    }
    
 return (
    <>
        <div className='text-center py-4 mb-8' style={{backgroundColor: '#f0f0f0', borderRadius: '15px'}}>
            <table className="min-w-full bg-white">
                <thead>
                    <tr>
                        <th className="py-2">Nazwa Wyborów</th>
                        <th className="py-2">Data Rozpoczęcia</th>
                        <th className="py-2">Odliczanie</th>
                    </tr>
                </thead>
                <tbody>
                    {elections.map((election, index) => (
                        <tr key={election.election_id} className="text-center">
                            <td className="py-2">{election.election_name}</td>
                            <td className="py-2">{upcomingElectionStartDate[index]}</td>
                            <td className="py-2">
                                <CountdownForm initialCount={new Date(election.startDate).toLocaleDateString()}/>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            {showForm && (
                <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
                    <button className="inherit top-0 right-0 p-4" onClick={() => setShowForm(false)}>
                        X
                    </button>
                    <div className="bg-white p-8 rounded-lg shadow-lg max-w-md w-full relative">
                        <h1 className="text-xl font-semibold mb-4">Wpisz kod otrzymany w mailu</h1>
                        <div className="mb-4">
                            <input
                                type="text"
                                placeholder="Twój kod"
                                value={votingCode}
                                onChange={(e) => setVotingCode(e.target.value)}
                                className="email-input w-full px-4 py-2 border rounded-lg text-gray-700 focus:border-blue-500"
                            />
                        </div>
                        <button
                            className='mt-2 py-1 px-4 bg-blue-500 hover:bg-blue-600 text-xs text-white font-bold rounded-xl transition duration-200'
                            onClick={verifyVotingCode}
                        >
                            Zweryfikuj kod i oddaj głos
                        </button>
                    </div>
                </div>
            )}
        </div>
        <div className='space-y-8'>
        {console.log(candidatesByElection)}
        {Object.entries(candidatesByElection).map(([electionId, candidates]) => (
            <div key={electionId}>
                <h2 className="text-3xl font-bold mb-4 text-center">
                    {elections.find(election => election.election_id === Number(electionId)).election_name}
                </h2>
                <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4'>
                    {candidates.map((candidate) => (
                        <div
                            key={candidate.candidate_id}
                            className='p-2 bg-white shadow-md rounded-xl'
                        >
                            <Image src={candidate.image} alt={`${candidate.name} ${candidate.surname}`} width={500} height={200} className="rounded-t-xl" />
                            <h2 className='text-lg font-semibold'>{candidate.name} {candidate.surname}</h2> 
                            <p className='text-md'>{candidate.education}</p> 
                            <p className='text-md'>{candidate.profession}</p> 
                            <p className='text-md'>     
                                {politicalParties.find(politicalParty => politicalParty.politicalPartyId === candidate.political_party_id).name}
                            </p>
                            <button
                                className={`mt-2 py-1 px-4 text-xs font-bold rounded-xl transition duration-200 ${
                                    new Date() < new Date(elections.find(election => election.election_id === Number(electionId)).startDate) ? 
                                    'bg-gray-400 cursor-not-allowed' : 
                                    'bg-blue-500 hover:bg-blue-600 text-white'
                                }`}
                                onClick={() => handleVoteClick(candidate.candidate_id)}
                                disabled={new Date() < new Date(elections.find(election => election.election_id === Number(electionId)).startDate)}
                            >
                                Zagłosuj
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        ))}
    </div>
    </>
);
}