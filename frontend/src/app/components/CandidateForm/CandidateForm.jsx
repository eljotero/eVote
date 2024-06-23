import Image from 'next/image';
import { useEffect, useState } from 'react';

export default function CandidateForm({ candidate, onVote }) {
  const {
    candidate_id,
    name,
    surname,
    birthDate,
    education,
    profession,
    political_party_id,
    precinct_id,
    election_id,
    info,
    image,
  } = candidate;
  const [showPlan, setShowPlan] = useState(false);
  const [politicalPartyName, setPoliticalPartyName] = useState('');

  useEffect(() => {
    fetch('https://localhost:8080/api/political_parties/all')
        .then((response) => response.json())
        .then((data) => {
          const politicalParty = data.find(
              (party) => party.politicalPartyId === political_party_id
          );
          if (politicalParty) {
            setPoliticalPartyName(politicalParty.name);
          }
        });
  }, [political_party_id]);

  const handleShowPlan = () => {
    setShowPlan(!showPlan);
  };
  const date = new Date(birthDate);
  const formattedDate = `${String(date.getDate()).padStart(2, '0')}-${String(
    date.getMonth() + 1
  ).padStart(2, '0')}-${date.getFullYear()}`;

  return (
    <div className='bg-white shadow-md rounded-md overflow-hidden relative'>
      {image ? (
        <Image
          src={image}
          alt={name}
          width={500}
          height={200}
          objectFit='cover'
        />
      ) : (
        <p>Brak zdjęcia</p>
      )}
      <div className='p-4'>
        <h2 className='text-lg font-semibold mb-2'>
          {name} {surname}
        </h2>
        <p className='text-gray-700 mb-2'>Data urodzenia: {formattedDate}</p>
        <p className='text-gray-700 mb-2'>Edukacja: {education}</p>
        <p className='text-gray-700 mb-2'>Zawód: {profession}</p>
        <p className='text-gray-700 mb-2'>
          Partia polityczna: {politicalPartyName}
        </p><button
          onClick={handleShowPlan}
          className='py-2 px-4 font-bold rounded bg-blue-400 hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-500/20 text-white duration-300'
          id='showPlanButton'
      >
        {showPlan ? 'Hide Plan' : 'Pokaż plan polityczny'}
      </button>
        {showPlan && (
            <div className='absolute top-0 left-0 w-full h-full bg-white bg-opacity-75 flex items-center justify-center z-10'>

              <div className='bg-white p-8 rounded shadow-lg text-center'>
                <h2 className='text-2xl mb-4'>Krótki plan polityczny</h2>
                <p>{info}</p>
                <button
                    onClick={handleShowPlan}
                    className='py-2 px-4 font-bold rounded bg-blue-400 hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-500/20 text-white duration-300'
                    id='closePlanButton'
                >
                  Zamknij
                </button>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
