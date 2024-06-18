'use client';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Bar, Pie, PolarArea} from 'react-chartjs-2';
import { Chart } from 'chart.js/auto';



const StatsPage = () => {
    const [sejmPartyStats, setSejmPartyStats] = useState([]);
    const [ageGroupResults, setAgeGroupResults] = useState([]);
    const [educationGroupResults, setEducationGroupResults] = useState([]);
    const [sexGroupResults, setSexGroupResults] = useState([]);
    const [cityGroupResults, setCityGroupResults] = useState([]);
    const [countryGroupResults, setCountryGroupResults] = useState([]);
    const [sejmGroupResults, setSejmGroupResults] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchStats = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/stats/allResults/1');
                setAgeGroupResults(response.data.resultsByAgeGroup);
                setEducationGroupResults(response.data.resultsByEducation);
                setSexGroupResults(response.data.resultsBySex);
                setCityGroupResults(response.data.resultsByCityType);
                setCountryGroupResults(response.data.resultsByCountry);
                setSejmGroupResults(response.data.results);


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

    const ageGroups = Object.keys(ageGroupResults);
    const educationGroups = Object.keys(educationGroupResults);
    const sexGroups = Object.keys(sexGroupResults);
    const cityGroups = Object.keys(cityGroupResults);
    const countryGroups = Object.keys(countryGroupResults);


    const countryGroupCharts = countryGroups.map((countryGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla danego kraju {countryGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={countryGroupResults[countryGroup]} partyName={`Grupa krajów ${countryGroup}`} />
            </div>
        </div>
    ));

    const cityGroupCharts = cityGroups.map((cityGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy {cityGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={cityGroupResults[cityGroup]} partyName={`Grupa miast ${cityGroup}`} />
            </div>
        </div>
    ));

    const sexGroupCharts = sexGroups.map((sexGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy {sexGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={sexGroupResults[sexGroup]} partyName={`Grupa płci ${sexGroup}`} />
            </div>
        </div>
    ));

    const ageGroupCharts = ageGroups.map((ageGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy wiekowej {ageGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={ageGroupResults[ageGroup]} partyName={`Grupa wiekowa ${ageGroup}`} />
            </div>
        </div>
    ));
    const educationGroupCharts = educationGroups.map((educationGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy wiekowej {educationGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={educationGroupResults[educationGroup]} partyName={`Grupa społeczna ${educationGroup}`} />
            </div>
        </div>
    ));
    return (
        <div className="container mx-auto p-4">
            <h1 className="text-4xl font-bold mb-8 text-center">Aktualne statystyki wyborcze</h1>
            <div className="bg-gray-200 mb-8">
                <div className="container mx-auto p-4">
                    <h2 className="text-3xl font-semibold mb-4 text-center">Sejm</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki ogólne wyborcze</h2>
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                <BarChart data={sejmGroupResults} />
                            </div>
                        </div>
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze - grupy wiekowe</h2>
                        <hr className="my-8" />
                        {ageGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze według grup społecznych</h2>
                        <hr className="my-8" />
                        {educationGroupCharts}
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze według płci</h2>
                        <hr className="my-8" />
                        {sexGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze według typów miast</h2>
                        <hr className="my-8" />
                        {cityGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze według krajów</h2>
                        <hr className="my-8" />
                        {countryGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />

                    </div>
                </div>
            </div>
            <div className="bg-gray-200">
                <div className="container mx-auto p-4">
                    <h2 className="text-xl font-semibold mb-4 text-center">Senat</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                    </div>
                </div>
            </div>
            <div className="bg-gray-200">
                <div className="container mx-auto p-4">
                    <h2 className="text-xl font-semibold mb-4 text-center">Wyniki wyborcze według grup wiekowych</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                        {ageGroupCharts}
                    </div>
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
                label: 'Liczba głosów',
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

const PolarAreaChart = ({ data, partyName }) => {
    const chartData = {
        labels: Object.keys(data),
        datasets: [
            {
                label: `Głosy dla ${partyName}`,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)',
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                borderWidth: 1,
                hoverBackgroundColor: [
                    'rgba(255, 99, 132, 0.8)',
                    'rgba(54, 162, 235, 0.8)',
                    'rgba(255, 206, 86, 0.8)',
                    'rgba(75, 192, 192, 0.8)',
                    'rgba(153, 102, 255, 0.8)',
                    'rgba(255, 159, 64, 0.8)',
                ],
                hoverBorderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                data: Object.values(data),
            },
        ],
    };

    const chartOptions = {
        scales: {
            r: {
                angleLines: {
                    display: true,
                },
                suggestedMin: 0,
            },
        },
    };

    return <PolarArea data={chartData} options={chartOptions} />;
};

const PieChart = ({ data, partyName }) => {
    const chartData = {
        labels: Object.keys(data),
        datasets: [
            {
                label: `Głosy dla ${partyName}`,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)',
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                borderWidth: 1,
                hoverBackgroundColor: [
                    'rgba(255, 99, 132, 0.8)',
                    'rgba(54, 162, 235, 0.8)',
                    'rgba(255, 206, 86, 0.8)',
                    'rgba(75, 192, 192, 0.8)',
                    'rgba(153, 102, 255, 0.8)',
                    'rgba(255, 159, 64, 0.8)',
                ],
                hoverBorderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                data: Object.values(data),
            },
        ],
    };

    const chartOptions = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            tooltip: {
                callbacks: {
                    label: (tooltipItem) => {
                        return `${tooltipItem.label}: ${tooltipItem.formattedValue}`;
                    },
                },
            },
        },
    };

    return <Pie data={chartData} options={chartOptions} />;
};
export default StatsPage;
