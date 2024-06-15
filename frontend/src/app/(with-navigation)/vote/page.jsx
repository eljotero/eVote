'use client';
import {useDispatch, useSelector} from "react-redux";
import React, {useEffect, useState} from "react";
import {toast} from "react-hot-toast";
import {setVotingToken} from "@/store/votingTokenSlice";
import CountdownForm from "@/app/components/Countdown/CountdownForm";
import axios from "../../../../lib/axios";

export default function Vote() {
    const id = useSelector((state) => state.id.value);
    const token = useSelector((state) => state.token.value);
    const dispatch = useDispatch();
    const [votingCode, setVotingCode] = useState('');
    const [showForm, setShowForm] = useState(false);
    const [elections, setElections] = useState([]);
    const [precincts, setPrecincts] = useState([]);
    const [candidates, setCandidates] = useState([]);
    const [user, setUser] = useState({});
    const [selectedCandidateId, setSelectedCandidateId] = useState(null);
    const upcomingElectionStartDate = elections.length > 0 ? new Date(elections[0].startDate).toLocaleDateString() : null;

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
                  .filter(precinct => precinct.address.city === user.city)
                  .map(precinct => precinct.precinct_id);
                setPrecincts(matchingPrecinctIds)
            } catch (error) {
                console.error('Error fetching precincts:', error);
            }
        };
        fetchPrecincts();
    }, [user])

    useEffect(() => {
        const fetchCandidates = async () => {
            try {
                for (const precinctId of precincts) {
                    for (const election of elections) {
                        const response = await axios.get(`http://localhost:8080/api/candidates/filtered?electionId=${election.election_id}&precinctId=${precinctId}`);
                        const candidates = response.data;
                        setCandidates(prevState => [...prevState, ...candidates]);
                    }
                }
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
            const response = await axios.post(`vote/${id}`, { code: votingCode }, {
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
            const response = await axios.post(`vote/submit`, {
                voterBirthDate: user.birthDate,
                voterCityType: user.cityType,              
                voterEducation: user.education,
                voterCountry: user.country,
                candidateId: selectedCandidateId,
            }, {
                headers: {
                    Authorization: `Bearer ${votingToken}`, 
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
        setSelectedCandidateId(candidateId);
        setShowForm(true);
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
            <CountdownForm initialCount={upcomingElectionStartDate}/>
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
                            Zweryfikuj Kod
                        </button>
                    </div>
                </div>
            )}
        </div>
        <div className='grid grid-cols-1 gap-4 lg:grid-cols-4'>
            {candidates.map((candidate) => (
                <div
                    key={candidate.candidate_id}
                    className='p-2 bg-white shadow-md rounded-xl'
                >
                    <img src={candidate.image} alt={`${candidate.name} ${candidate.surname}`} className="w-full max-h-100 object-cover rounded-t-xl" />
                    <h2 className='text-lg font-semibold'>{candidate.name} {candidate.surname}</h2> 
                    <p className='text-md'>{candidate.education}</p> 
                    <p className='text-md'>{candidate.profession}</p> 
                    <button
                        className='mt-2 py-1 px-4 bg-blue-500 hover:bg-blue-600 text-xs text-white font-bold rounded-xl transition duration-200' 
                        onClick={() => handleVoteClick(candidate.candidate_id)}
                    >
                        Zagłosuj
                    </button>
                </div>
            ))}
        </div>
    </>
);
}