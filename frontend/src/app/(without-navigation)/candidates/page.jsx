'use client';
import React, {useState, useEffect} from 'react';
import axios from '../../../../lib/axios';
import CandidateForm from '../../components/CandidateForm/CandidateForm';
import CountdownForm from "@/app/components/Countdown/CountdownForm";


export default function Candidates() {
    const [candidates, setCandidates] = useState([]);
    const [elections, setElections] = useState([]);
    const [selectedRegion, setSelectedRegion] = useState('');
    const [selectedDistrict, setSelectedDistrict] = useState('');
    const [selectedDistrict2, setSelectedDistrict2] = useState('');
    const upcomingElectionStartDate = elections.length > 0 ? new Date(elections[0].startDate).toLocaleDateString() : null;

    useEffect(() => {
        const urlParams = new URLSearchParams(window.location.search);
        const woj = urlParams.get('woj');
        setSelectedRegion(woj || '');
        const fetchCandidates = async () => {
                try {
                    const responseSejm = await axios.get(
                        `candidates/filtered?electionId=${1}&precinctId=${getDistrictNumber(selectedDistrict)}`
                    );

                    const responseSenate = await axios.get(
                        `candidates/filtered?electionId=${2}&precinctId=${getDistrictNumber(selectedDistrict2)}`
                    );
                    const candidatesWithShowPlanSejm = responseSejm.data.map(
                        (candidate) => ({...candidate, showPlan: false})
                    );
                    const candidatesWithShowPlanSenate = responseSenate.data.map(
                        (candidate) => ({...candidate, showPlan: false})
                    );
                    setCandidates([
                        ...candidatesWithShowPlanSejm,
                        ...candidatesWithShowPlanSenate,
                    ]);
                } catch (error) {
                    console.error('Error fetching candidates:', error);
                }
        };


        const fetchElections = async () => {
            try {
                const response = await axios.get('elections/upcoming');
                setElections(response.data);
            } catch (error) {
                console.error('Error fetching elections:', error);
            }
        };

        fetchCandidates();
        fetchElections();
    }, [selectedDistrict, selectedDistrict2, selectedRegion]);

    const handleShowPlan = (candidateId) => {
        const updatedCandidates = candidates.map((candidate) =>
            candidate.candidate_id === candidateId
                ? {...candidate, showPlan: !candidate.showPlan}
                : candidate
        );
        setCandidates(updatedCandidates);
    };


    const districtsByRegion = {
        Dolnośląskie: [
            'Okręg wyborczy nr 1 - Legnica',
            'Okręg wyborczy nr 2 - Wałbrzych',
            'Okręg wyborczy nr 3 - Wrocław',
        ],
        'Kujawsko-pomorskie': [
            'Okręg wyborczy nr 4 - Bydgoszcz',
            'Okręg wyborczy nr 5 - Toruń',
        ],
        Lubelskie: ['Okręg wyborczy nr 6 - Lublin', 'Okręg wyborczy nr 7 - Chełm'],
        Lubuskie: ['Okręg wyborczy nr 8 - Zielona Góra'],
        Łódzkie: [
            'Okręg wyborczy nr 9 - Łódź',
            'Okręg wyborczy nr 10 - Piotrków Trybunalskich',
            'Okręg wyborczy nr 11 - Sieradz',
        ],
        Małopolskie: [
            'Okręg wyborczy nr 12 - Chrzanów',
            'Okręg wyborczy nr 13 - Kraków',
            'Okręg wyborczy nr 14 - Nowy Sącz',
            'Okręg wyborczy nr 15 - Tarnów',
        ],
        Mazowieckie: [
            'Okręg wyborczy nr 16 - Płock',
            'Okręg wyborczy nr 17 - Radom',
            'Okręg wyborczy nr 18 - Siedlice',
            'Okręg wyborczy nr 19 - Warszawa I',
            'Okręg wyborczy nr 20 - Warszawa II',
        ],
        Opolskie: ['Okręg wyborczy nr 21 - Opole'],
        Podkarpackie: [
            'Okręg wyborczy nr 22 - Krosno',
            'Okręg wyborczy nr 23 - Rzeszów',
        ],
        Podlaskie: ['Okręg wyborczy nr 24 - Białystok'],
        Pomorskie: [
            'Okręg wyborczy nr 25 - Gdańsk',
            'Okręg wyborczy nr 26 - Słupsk',
        ],
        Śląskie: [
            'Okręg wyborczy nr 27 - Bielsko-Biała',
            'Okręg wyborczy nr 28 - Częstochowa',
            'Okręg wyborczy nr 29 - Katowice',
            'Okręg wyborczy nr 30 - Bielsko-Biała',
            'Okręg wyborczy nr 31 - Katowice I',
            'Okręg wyborczy nr 32 - Katowice II',
        ],
        Świętokrzyskie: ['Okręg wyborczy nr 33 - Kielce'],
        'Warmińsko-mazurskie': [
            'Okręg wyborczy nr 34 - Elbląg',
            'Okręg wyborczy nr 35 - Olsztyn',
        ],
        Wielkopolskie: [
            'Okręg wyborczy nr 36 - Kalisz',
            'Okręg wyborczy nr 37 - Konin',
            'Okręg wyborczy nr 38 - Piła',
            'Okręg wyborczy nr 39 - Poznań',
        ],
        Zachodniopomorskie: [
            'Okręg wyborczy nr 40 - Koszalin',
            'Okręg wyborczy nr 41 - Szczecin',
        ],
    };
    const districtsByRegion2 = {
        Dolnośląskie: [
            'Okręg wyborczy nr 1 - Bolesławiec',
            'Okręg wyborczy nr 2 - Jelenia Góra',
            'Okręg wyborczy nr 3 - Legnica',
            'Okręg wyborczy nr 4 - Wałbrzych',
            'Okręg wyborczy nr 5 - Dzierżoniów',
            'Okręg wyborczy nr 6 - Oleśnica',
            'Okręg wyborczy nr 7 - Wrocław I',
            'Okręg wyborczy nr 8 - Wrocław II',
        ],
        'Kujawsko-pomorskie': [
            'Okręg wyborczy nr 9 - Bydgoszcz',
            'Okręg wyborczy nr 10 - Inowrocław',
            'Okręg wyborczy nr 11 - Toruń',
            'Okręg wyborczy nr 12 - Grudziąc',
            'Okręg wyborczy nr 13 - Włocławek',
        ],
        Lubelskie: [
            'Okręg wyborczy nr 14 - Puławy',
            'Okręg wyborczy nr 15 - Świdnik',
            'Okręg wyborczy nr 16 - Lublin',
            'Okręg wyborczy nr 17 - Biała Podlaska',
            'Okręg wyborczy nr 18 - Chełm',
            'Okręg wyborczy nr 19 - Zamość',
        ],
        Lubuskie: [
            'Okręg wyborczy nr 20 - Zielona Góra',
            'Okręg wyborczy nr 21 - Gorzów Wielkopolski',
            'Okręg wyborczy nr 22 - Nowa Sól',
        ],
        Łódzkie: [
            'Okręg wyborczy nr 23 - Łódź I ',
            'Okręg wyborczy nr 24 - Łódź II',
            'Okręg wyborczy nr 25 - Kutno',
            'Okręg wyborczy nr 26 - Pabianice',
            'Okręg wyborczy nr 27 - Sieradz',
            'Okręg wyborczy nr 28 - Piotrków Trybunalski',
            'Okręg wyborczy nr 29 - Tomaszów Mazowiecki',
        ],
        Małopolskie: [
            'Okręg wyborczy nr 30 - Oświęcim',
            'Okręg wyborczy nr 31 - Olkusz',
            'Okręg wyborczy nr 32 - Kraków I',
            'Okręg wyborczy nr 33 - Kraków II',
            'Okręg wyborczy nr 34 - Bochnia',
            'Okręg wyborczy nr 35 - Tarnów',
            'Okręg wyborczy nr 36 - Nowy Targ',
            'Okręg wyborczy nr 37 - Nowy Sącz',
        ],
        Mazowieckie: [
            'Okręg wyborczy nr 38 - Płock',
            'Okręg wyborczy nr 39 - Ciechanów',
            'Okręg wyborczy nr 40 - Legionowo',
            'Okręg wyborczy nr 41 - Pruszków',
            'Okręg wyborczy nr 42 - Warszawa I',
            'Okręg wyborczy nr 43 - Warszawa II',
            'Okręg wyborczy nr 44 - Warszawa III',
            'Okręg wyborczy nr 45 - Warszawa IV',
            'Okręg wyborczy nr 46 - Ostrołęka',
            'Okręg wyborczy nr 47 - Mińsk Mazowiecki',
            'Okręg wyborczy nr 48 - Siedlce',
            'Okreg wyborczy nr 49 - Kozienice',
            'Okreg wyborczy nr 50 - Radom',
        ],
        Opolskie: [
            'Okręg wyborczy nr 51 - Nysa',
            'Okręg wyborczy nr 52 - Opole',
            'Okręg wyborczy nr 53 - Kędzierzyn-Koźle',
        ],
        Podkarpackie: [
            'Okręg wyborczy nr 54 - Stalowa Wola',
            'Okręg wyborczy nr 55 - Mielc',
            'Okręg wyborczy nr 56 - Rzeszów',
        ],
        Podlaskie: [
            'Okręg wyborczy nr 57 - Krosno',
            'Okręg wyborczy nr 58 - Przemyśl',
            'Okręg wyborczy nr 59 - Suwałki',
            'Okręg wyborczy nr 60 - Białystok',
            'Okręg wyborczy nr 61 - Bielsk Podlaski',
        ],
        Pomorskie: [
            'Okręg wyborczy nr 62 - Słupsk',
            'Okręg wyborczy nr 63 - Chojnice',
            'Okręg wyborczy nr 64 - Gdynia',
            'Okręg wyborczy nr 65 - Gdańsk',
            'Okręg wyborczy nr 66 - Tczew',
            'Okręg wyborczy nr 67 - Malbork',
        ],
        Śląskie: [
            'Okręg wyborczy nr 68 - Myszków',
            'Okręg wyborczy nr 69 - Częstochowa',
            'Okręg wyborczy nr 70 - Gliwice',
            'Okręg wyborczy nr 71 - Zabrze',
            'Okręg wyborczy nr 72 - Jastrzębie-Zdrój',
            'Okręg wyborczy nr 73 - Rybnik',
            'Okręg wyborczy nr 74 - Ruda Śląska',
            'Okręg wyborczy nr 75 - Tychy',
            'Okręg wyborczy nr 76 - Dąbrowa Górnicza',
            'Okręg wyborczy nr 77 - Sosnowiec',
            'Okręg wyborczy nr 78 - Bielsko-Biała',
            'Okręg wyborczy nr 79 - Cieszyn',
            'Okręg wyborczy nr 80 - Katowice',
        ],
        Świętokrzyskie: [
            'Okręg wyborczy nr 81 - Końskie',
            'Okręg wyborczy nr 82 - Ostrowiec Świętokrzyski',
            'Okręg wyborczy nr 83 - Kielce',
        ],
        'Warmińsko-mazurskie': [
            'Okręg wyborczy nr 84 - Elbląg',
            'Okręg wyborczy nr 85 - Iława',
            'Okręg wyborczy nr 86 - Olsztyn',
            'Okręg wyborczy nr 87 - Ełk',
        ],
        Wielkopolskie: [
            'Okręg wyborczy nr 88 - Piła',
            'Okręg wyborczy nr 89 - Szamotuły',
            'Okręg wyborczy nr 90 - Swarzędz',
            'Okręg wyborczy nr 91 - Poznań',
            'Okręg wyborczy nr 92 - Gniezno',
            'Okręg wyborczy nr 93 - Konin',
            'Okręg wyborczy nr 94 - Leszno',
            'Okręg wyborczy nr 95 - Ostrów Wielkopolski',
            'Okręg wyborczy nr 96 - Kalisz',
        ],
        Zachodniopomorskie: [
            'Okręg wyborczy nr 97 - Szczecin',
            'Okręg wyborczy nr 98 - Stargard',
            'Okręg wyborczy nr 99 - Kołobrzeg',
            'Okręg wyborczy nr 100 - Koszalin',
        ],
    };

    function getDistrictNumber(districtLabel) {
        const districtNumber = districtLabel.split(' ')[3];
        return parseInt(districtNumber);
    }

    const sejmCandidates = candidates.filter(
        (candidate) => candidate.election_id === 1
    );
    const senateCandidates = candidates.filter(
        (candidate) => candidate.election_id === 2
    );
    const closestElectionNames = elections
        .map((election) => election.election_name)
        .join(', ');

    return (
        <div className='container mx-auto mt-10'>
            <div className='text-center py-4 mb-8' style={{backgroundColor: '#f0f0f0', borderRadius: '15px'}}>
                <h1 className='text-4xl font-bold' style={{color: '#333'}}>Poznaj swoich kandydatów!</h1>
                <h2 className='text-2xl font-bold' style={{color: '#555'}}>Region: {selectedRegion} </h2> {}
            </div>
            <div className='text-center py-4 mb-8' style={{backgroundColor: '#f0f0f0'}}>
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
                            <td className="py-2">{new Date(election.startDate).toLocaleDateString()}</td>
                            <td className="py-2">
                                <CountdownForm initialCount={new Date(election.startDate).toLocaleDateString()}/>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            </div>
            <h2 className='text-2xl font-bold mb-4' style={{color: '#333'}}>Kandydaci do sejmu</h2>
            <div className='flex justify-center mb-4'>
                <select
                    onChange={(e) => setSelectedDistrict(e.target.value)}
                    className='form-select block w-full mt-1'
                    style={{borderRadius: '15px'}}
                    id='district-select'
                >
                    {selectedRegion &&
                        districtsByRegion[selectedRegion] &&
                        districtsByRegion[selectedRegion].map((district) => (
                            <option key={district} value={district}>{district}</option>
                        ))}
                </select>
            </div>
            <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6'>
                {sejmCandidates.map((candidate) => (
                    <CandidateForm
                        key={candidate.candidate_id}
                        candidate={candidate}
                        onVote={handleShowPlan}
                    />
                ))}
            </div>
            <h2 className='text-2xl font-bold mb-4' style={{color: '#333'}}>Kandydaci do senatu</h2>
            <div className='flex justify-center mb-4'>
                <select
                    onChange={(e) => setSelectedDistrict2(e.target.value)}
                    className='form-select block w-full mt-1'
                    style={{borderRadius: '15px'}}
                    id='district-select2'
                >
                    {selectedRegion &&
                        districtsByRegion2[selectedRegion].map((district) => (
                            <option key={district} value={district}>{district}</option>
                        ))}
                </select>
            </div>
            <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6'>
                {senateCandidates.map((candidate) => (
                    <CandidateForm
                        key={candidate.candidate_id}
                        candidate={candidate}
                        onVote={handleShowPlan}
                    />
                ))}
            </div>
        </div>
    );
}
