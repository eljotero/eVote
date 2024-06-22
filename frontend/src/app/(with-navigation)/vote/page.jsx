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
    const [selectedElectionId, setSelectedElectionId] = useState(null);
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
            try {
                const response = await axios.get('https://localhost:8080/api/precinct/all');
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
                const response = await axios.get('https://localhost:8080/api/political_parties/all');
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
                        const response = await axios.get(`https://localhost:8080/api/candidates/filtered?electionId=${election.election_id}&precinctId=${precinctId}`);
                        const candidates = response.data;
                        if (newCandidatesByElection[election.election_id]) {
                            newCandidatesByElection[election.election_id] = [...newCandidatesByElection[election.election_id], ...candidates];
                        } else {
                            newCandidatesByElection[election.election_id] = candidates;
                        }
                    }
                }
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
                        "candidateId": selectedCandidateId,
                        "electionId": selectedElectionId,
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

    const handleVoteClick = (candidateId, electionId) => {
        setSelectedCandidateId(candidateId);
        setSelectedElectionId(electionId);
        setShowForm(true);
    }

 return (
    <section className="Sekcja głosowania mx-auto">

        <div className='text-center mx-auto py-4 mb-8' style={{backgroundColor: '#f0f0f0', borderRadius: '15px'}}>
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
                    <div className="bg-white p-8 rounded-lg shadow-lg max-w-md w-full relative">
                        <button
                            className="absolute top-0 right-0 m-4 p-2 text-gray-700 hover:text-gray-900"
                            onClick={() => setShowForm(false)}
                            aria-label="Zamknij"
                        >
                            <svg
                                className='h-6 w-6 text-gray-400 cursor-pointer hover:text-gray-500'
                                xmlns='http://www.w3.org/2000/svg'
                                fill='none'
                                viewBox='0 0 24 24'
                                stroke='currentColor'
                            >
                                <path
                                    strokeLinecap='round'
                                    strokeLinejoin='round'
                                    strokeWidth='2'
                                    d='M6 18L18 6M6 6l12 12'
                                ></path>
                            </svg>
                        </button>
                        <h1 className="text-xl font-semibold mb-4">Wpisz kod otrzymany w mailu</h1>
                        <div className="mb-4">
                            <input
                                type="text"
                                placeholder="Twój kod"
                                value={votingCode}
                                onChange={(e) => setVotingCode(e.target.value)}
                                className="email-input w-full px-4 py-2 border rounded text-gray-700 focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300"
                            />
                        </div>
                        <button
                            className='mt-2 py-1 px-4 bg-blue-400 hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-500/20 text-md text-white font-bold rounded transition duration-300'
                            aria-label="Zweryfikuj kod i oddaj głos"
                            onClick={verifyVotingCode}
                        >
                            Zweryfikuj kod i oddaj głos
                        </button>
                    </div>
                </div>
            )}

        </div>

        <div className='space-y-8 mx-auto'>
        {Object.entries(candidatesByElection).map(([electionId, candidates]) => (
            <div key={electionId} className='mx-auto'>
                <h2 className="text-3xl font-bold mb-4 text-center">
                    {elections.find(election => election.election_id === Number(electionId)).election_name}
                </h2>
                <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 justify-items-center'>
                    {candidates.map((candidate) => (
                        <div
                            key={candidate.candidate_id}
                            className='py-2 bg-white shadow-md rounded'
                        >
                            <Image src={candidate.image} alt={`${candidate.name} ${candidate.surname}`} width={500} height={200} className="rounded-t-xl" />
                            <h2 className='text-lg font-bold mt-2'>{candidate.name} {candidate.surname}</h2>
                            <p className='text-md'><span className="font-semibold">Wykształcenie:</span> {candidate.education}</p>
                            <p className='text-md'><span className="font-semibold">Zawód:</span> {candidate.profession}</p>
                            <p className='text-md'>
                                {politicalParties.find(politicalParty => politicalParty.politicalPartyId === candidate.political_party_id).name}
                            </p>
                            <button
                                className={`mt-2 py-1 px-4 text-sm font-bold rounded transition duration-300 hover:shadow-lg hover:shadow-blue-500/20 text-white ${
                                    new Date() < new Date(elections.find(election => election.election_id === Number(electionId)).startDate) ? 
                                    'bg-gray-500 cursor-not-allowed' : 
                                    'bg-blue-400 hover:bg-blue-500'
                                }`}
                                onClick={() => handleVoteClick(candidate.candidate_id, electionId)}
                                aria-label='Zagłosuj'
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
    </section>
);
}