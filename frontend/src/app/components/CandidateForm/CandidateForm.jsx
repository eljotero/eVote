import React, { useState, useEffect } from 'react';
import Image from "next/image";

export default function CandidateForm({ candidate, onVote }) {
    const { candidate_id, name, surname, birthDate, education, profession, political_party_id ,image, precinct_id, election_id } = candidate;
    const [showPlan, setShowPlan] = useState(false);
    const [politicalPartyName, setPoliticalPartyName] = useState('');

    useEffect(() => {
        fetch('http://localhost:8080/api/political_parties/all')
            .then(response => response.json())
            .then(data => {
                const politicalParty = data.find(party => party.political_party_id === political_party_id);
                if (politicalParty) {
                    setPoliticalPartyName(politicalParty.name);
                }
            });
    }, [political_party_id]);

    const handleShowPlan = () => {
        setShowPlan(!showPlan);
    };
    const date = new Date(birthDate);
    const formattedDate = `${String(date.getDate()).padStart(2, '0')}-${String(date.getMonth() + 1).padStart(2, '0')}-${date.getFullYear()}`;

    return (
        <div className="bg-white shadow-md rounded-md overflow-hidden relative">
            <Image src={image} alt={name} width={500} height={300} objectFit="cover" />
            <div className="p-4">
                <h2 className="text-lg font-semibold mb-2">{name} {surname}</h2>
                <p className="text-gray-700 mb-2">Data urodzenia: {formattedDate}</p>
                <p className="text-gray-700 mb-2">Edukacja: {education}</p>
                <p className="text-gray-700 mb-2">Zawód: {profession}</p>
                <p className="text-gray-700 mb-2">Partia polityczna: {politicalPartyName}</p>
                <button onClick={handleShowPlan} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    {showPlan ? 'Hide Plan' : 'Pokaz plan polityczny'}
                </button>
                {showPlan && (
                    <div className="absolute top-0 left-0 w-full h-full bg-white bg-opacity-75 flex items-center justify-center z-10">
                        <div className="bg-white p-8 rounded shadow-lg text-center">
                            <h2 className="text-2xl mb-4">Political Plan</h2>
                            <p>Dear Voter!</p>
                            <ul>
                                <li>Introduction</li>
                                <li>Situation Analysis</li>
                                <li>Campaign Objectives</li>
                                <li>Communication Strategy</li>
                                <li>Voter Outreach</li>
                                <li>Digital Campaign</li>
                                <li>Policy Development</li>
                                <li>Fundraising</li>
                                <li>Get-Out-The-Vote (GOTV) Efforts</li>
                                <li>Monitoring and Evaluation</li>
                                <li>Conclusion</li>
                            </ul>
                            <button onClick={handleShowPlan} className="mt-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                                Zamknij
                            </button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}