'use client';
import {useDispatch, useSelector} from "react-redux";
import React, {useEffect, useState} from "react";
import {toast} from "react-hot-toast";
import {setVotingToken} from "@/store/votingTokenSlice";
import CountdownForm from "@/app/components/Countdown/CountdownForm";
import axios from "../../../../lib/axios";
import Image from "next/image";
import Modal from "@/app/components/Modal/Modal";

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
            const response = await axios.post(`vote/voteToken`, {code: votingCode}, {
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
        <section aria-label="Sekcja głosowania" className="mx-auto">
            <Image
                src="https://firebasestorage.googleapis.com/v0/b/gnomenciaga.appspot.com/o/evote%2Fevote-vote3.png?alt=media&token=b51ef52f-be56-41c5-a9bd-1a153fa171d7"
                alt="Kobieta wrzucająca kartkę żeby zagłosować" width={800} height={400} className="mx-auto"/>
            <div className='text-center mx-auto py-4' style={{backgroundColor: '#f0f0f0', borderRadius: '15px'}}>
                <table className="min-w-[70%] bg-white mx-auto">
                    <thead>
                    <tr className="bg-blue-200">
                        <th className="py-2">Nazwa Wyborów</th>
                        <th className="py-2">Data Rozpoczęcia</th>
                        <th className="py-2">Odliczanie</th>
                    </tr>
                    </thead>
                    <tbody className="bg-blue-200">
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
                <Modal
                    showForm={showForm}
                    setShowForm={setShowForm}
                    votingCode={votingCode}
                    setVotingCode={setVotingCode}
                    verifyVotingCode={verifyVotingCode}
                />
            </div>

            <div className='space-y-8 flex justify-center flex-col'>
                {Object.entries(candidatesByElection).map(([electionId, candidates]) => (
                    <div key={electionId} className='mx-auto'>
                        <h2 className="mb-4 text-center">
                            <span
                                className="text-3xl font-bold text-transparent bg-clip-text bg-gradient-to-r from-blue-600 to-cyan-500">
                                {elections.find(election => election.election_id === Number(electionId)).election_name}</span>
                        </h2>
                        <div
                            className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 justify-items-center'>
                            {candidates.map((candidate) => (
                                <div
                                    key={candidate.candidate_id}
                                    className='p-4 bg-gray-100 shadow-lg rounded-lg hover:shadow-blue-400 hover:scale-95 hover:z-[1] hover:shadow-lg duration-300 mb-4'
                                >
                                    <Image src={candidate.image} alt={`${candidate.name} ${candidate.surname}`}
                                           width={500} height={200}
                                           className="rounded-t-xl"/>
                                    <h2 className='text-lg font-bold mt-2'>{candidate.name} {candidate.surname}</h2>
                                    <p className='text-md'><span
                                        className="font-semibold">Wykształcenie:</span> {candidate.education}</p>
                                    <p className='text-md'><span
                                        className="font-semibold">Zawód:</span> {candidate.profession}</p>
                                    <p className='text-md'>
                                        {politicalParties.find(politicalParty => politicalParty.politicalPartyId === candidate.political_party_id).name}
                                    </p>
                                    <button
                                        className={`mt-2 py-1 px-4 text-md font-bold rounded transition duration-300 hover:shadow-lg hover:shadow-blue-500/20 text-white ${
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