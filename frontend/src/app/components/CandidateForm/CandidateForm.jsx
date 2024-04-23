import React, { useState } from 'react';
import Image from "next/image";

export default function CandidateForm({ candidate, onVote }) {
    const { candidate_id, name, surname, birthDate, education, profession, political_party ,image } = candidate;
    const [showPlan, setShowPlan] = useState(false);

    const handleVote = () => {
        onVote(candidate_id);
    };

    const handleShowPlan = () => {
        setShowPlan(!showPlan);
    };

    return (
        <div className="bg-white shadow-md rounded-md overflow-hidden relative">
            <Image src={image} alt={name} width={500} height={300} objectFit="cover" />
            <div className="p-4">
                <h2 className="text-lg font-semibold mb-2">{name} {surname}</h2>
                <p className="text-gray-700 mb-2">Date of Birth: {birthDate}</p>
                <p className="text-gray-700 mb-2">Education: {education}</p>
                <p className="text-gray-700 mb-2">Profession: {profession}</p>
                <p className="text-gray-700 mb-2">Political party: {political_party}</p>
                <button onClick={handleShowPlan} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    {showPlan ? 'Hide Plan' : 'Show Plan'}
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
                                Close
                            </button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}