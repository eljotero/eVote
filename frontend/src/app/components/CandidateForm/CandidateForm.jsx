import React, { useState } from 'react';
import Image from "next/image";

export default function CandidateForm({ candidate, onVote }) {
    const { candidate_id, name, surname, birthDate, education, profession, votes, image } = candidate;

    const handleVote = () => {
        onVote(candidate_id);
    };

    return (
        <div className="bg-white shadow-md rounded-md overflow-hidden">
            <Image src={image} alt={name} width={500} height={300} objectFit="cover" />
            <div className="p-4">
                <h2 className="text-lg font-semibold mb-2">{name} {surname}</h2>
                <p className="text-gray-700 mb-2">Date of Birth: {birthDate}</p>
                <p className="text-gray-700 mb-2">Education: {education}</p>
                <p className="text-gray-700 mb-2">Profession: {profession}</p>
                <p className="text-gray-700 mb-2">{votes} votes</p>
                <button onClick={handleVote} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    Vote
                </button>
            </div>
        </div>
    );
}