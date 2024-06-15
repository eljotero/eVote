'use client';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import { Chart } from 'chart.js/auto';

const StatsPage = () => {
    const [sejmStats, setSejmStats] = useState(null);
    const [senatStats, setSenatStats] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchStats = async () => {
            try {
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

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error loading stats: {error.message}</div>;
    }

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Aktualne statystyki</h1>
            {}
            <h2 className="text-xl font-semibold mb-4">Sejm</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Liczba głosów na partie</h3>
                    <BarChart data={sejmStats.partyVotes} />
                </div>
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Głosy według typu miasta</h3>
                    <BarChart data={sejmStats.cityTypeVotes} />
                </div>
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Głosy według wykształcenia</h3>
                    <BarChart data={sejmStats.educationVotes} />
                </div>
            </div>
            {}
            <h2 className="text-xl font-semibold mb-4">Senat</h2>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Liczba głosów na partie</h3>
                    <BarChart data={senatStats.partyVotes} />
                </div>
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Głosy według typu miasta</h3>
                    <BarChart data={senatStats.cityTypeVotes} />
                </div>
                <div className="p-4 bg-white rounded-lg shadow-md">
                    <h3 className="text-lg font-semibold">Głosy według wykształcenia</h3>
                    <BarChart data={senatStats.educationVotes} />
                </div>
            </div>
        </div>
    );
};

const BarChart = ({ data }) => {
    const chartData = {
        labels: Object.keys(data),
        datasets: [
            {
                label: 'Głosy',
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
                type: 'category',
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
