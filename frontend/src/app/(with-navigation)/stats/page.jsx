'use client';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import { Chart } from 'chart.js/auto';



const StatsPage = () => {
    const [sejmPartyStats, setSejmPartyStats] = useState([]);
    const [senatPartyStats, setSenatPartyStats] = useState([]);
    const [sejmStats, setSejmStats] = useState(null);
    const [senatStats, setSenatStats] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchStats = async () => {
            try {
                const sejmStatsPromises = [];
                const senatStatsPromises = [];

                for (let i = 1; i <= 5; i++) {
                    sejmStatsPromises.push(fetchDetailedStats(1, i));
                    senatStatsPromises.push(fetchDetailedStats(2, i));
                }

                const sejmStatsResponses = await Promise.all(sejmStatsPromises);
                const senatStatsResponses = await Promise.all(senatStatsPromises);

                const sejmPartyStats = sejmStatsResponses.map((response, index) => ({
                    politicalPartyId: index + 1,
                    educationVotes: response.educationVotes,
                    cityTypeVotes: response.cityTypeVotes,
                    partyName: getPartyName(index + 1),
                }));

                const senatPartyStats = senatStatsResponses.map((response, index) => ({
                    politicalPartyId: index + 1,
                    educationVotes: response.educationVotes,
                    cityTypeVotes: response.cityTypeVotes,
                    partyName: getPartyName(index + 1),
                }));

                setSejmPartyStats(sejmPartyStats);
                setSenatPartyStats(senatPartyStats);

                const sejmResultsResponse = await axios.get('http://localhost:8080/api/vote/results/1');
                const sejmDetailedResultsResponse = await axios.get('http://localhost:8080/api/vote/detailedResults/1');
                const senatResultsResponse = await axios.get('http://localhost:8080/api/vote/results/2');
                const senatDetailedResultsResponse = await axios.get('http://localhost:8080/api/vote/detailedResults/2');

                setSejmStats({
                    partyVotes: sejmResultsResponse.data,
                    cityTypeVotes: sejmDetailedResultsResponse.data.cityTypeVotes,
                    educationVotes: sejmDetailedResultsResponse.data.educationVotes
                });

                setSenatStats({
                    partyVotes: senatResultsResponse.data,
                    cityTypeVotes: senatDetailedResultsResponse.data.cityTypeVotes,
                    educationVotes: senatDetailedResultsResponse.data.educationVotes
                });

                setLoading(false);
            } catch (err) {
                setError(err);
                setLoading(false);
            }
        };

        fetchStats();
    }, []);

    const fetchDetailedStats = async (electionId, politicalPartyId) => {
        try {
            const response = await axios.get(`http://localhost:8080/api/vote/detailedVotesByParty/${electionId}/${politicalPartyId}`);
            return response.data;
        } catch (err) {
            throw err;
        }
    };

    const getPartyName = (politicalPartyId) => {
        switch (politicalPartyId) {
            case 1:
                return 'Prawo i Sprawiedliwość';
            case 2:
                return 'Koalicja Obywatelska';
            case 3:
                return 'Konfederacja';
            case 4:
                return 'Nowa Lewica';
            case 5:
                return 'Trzecia Droga';
            default:
                return 'Nieznana partia';
        }
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error loading stats: {error.message}</div>;
    }
    return (
        <div className="container mx-auto p-4">
            <h1 className="text-3xl font-bold mb-8 text-center">Aktualne statystyki wyborcze</h1>
            <div className="bg-gray-200 mb-8">
                <div className="container mx-auto p-4">
                    <h2 className="text-xl font-semibold mb-4 text-center">Sejm</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <h3 className="text-lg font-semibold">Liczba głosów na daną partie</h3>
                            <BarChart data={sejmStats.partyVotes} />
                        </div>
                        {sejmPartyStats.map(stats => (
                            <div key={stats.politicalPartyId} className="p-4 bg-white rounded-lg shadow-md">
                                <h3 className="text-lg font-semibold">Wykształcenie głosujących na partie {stats.partyName}</h3>
                                <BarChart data={stats.educationVotes} partyName={stats.partyName} />
                            </div>
                        ))}
                        {sejmPartyStats.map(stats => (
                            <div key={stats.politicalPartyId} className="p-4 bg-white rounded-lg shadow-md">
                                <h3 className="text-lg font-semibold">Głosy w poszczególnych typach miast dla partii {stats.partyName}</h3>
                                <BarChart data={stats.cityTypeVotes} partyName={stats.partyName} />
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <div className="bg-gray-200">
                <div className="container mx-auto p-4">
                    <h2 className="text-xl font-semibold mb-4 text-center">Senat</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <h3 className="text-lg font-semibold">Liczba głosów na partie (Senat)</h3>
                            <BarChart data={senatStats.partyVotes} />
                        </div>
                        {senatPartyStats.map(stats => (
                            <div key={stats.politicalPartyId} className="p-4 bg-white rounded-lg shadow-md">
                                <h3 className="text-lg font-semibold">Wykształcenie głosujących na partie {stats.partyName}</h3>
                                <BarChart data={stats.educationVotes} partyName={stats.partyName} />
                            </div>
                        ))}
                        {senatPartyStats.map(stats => (
                            <div key={stats.politicalPartyId} className="p-4 bg-white rounded-lg shadow-md">
                                <h3 className="text-lg font-semibold">Głosy w poszczególnych typach miast dla partii {stats.partyName}</h3>
                                <BarChart data={stats.cityTypeVotes} partyName={stats.partyName} />
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );
};

const BarChart = ({ data, partyName }) => {
    const chartData = {
        labels: Object.keys(data),
        datasets: [
            {
                label: `Głosy dla ${partyName}`,
                backgroundColor: 'rgba(75,192,192,0.4)',
                borderColor: 'rgba(75,192,192,1)',
                borderWidth: 1,
                hoverBackgroundColor: 'rgba(75,192,192,0.6)',
                hoverBorderColor: 'rgba(75,192,192,1)',
                data: Object.values(data),
            },
        ],
    };

    const chartOptions = {
        scales: {
            x: {
                indexAxis: 'x',
                labels: chartData.labels,
            },
            y: {
                beginAtZero: true,
            },
        },
    };

    return <Bar data={chartData} options={chartOptions} />;
};
export default StatsPage;
