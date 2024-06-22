'use client';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Bar, Doughnut, Pie, PolarArea} from 'react-chartjs-2';
import { Chart } from 'chart.js/auto';



const StatsPage = () => {
    const [ageGroupResults, setAgeGroupResults] = useState([]);
    const [educationGroupResults, setEducationGroupResults] = useState([]);
    const [sexGroupResults, setSexGroupResults] = useState([]);
    const [cityGroupResults, setCityGroupResults] = useState([]);
    const [countryGroupResults, setCountryGroupResults] = useState([]);
    const [sejmGroupResults, setSejmGroupResults] = useState([]);
    const [ageGroupResultsSenat, setAgeGroupResultsSenat] = useState([]);
    const [educationGroupResultsSenat, setEducationGroupResultsSenat] = useState([]);
    const [sexGroupResultsSenat, setSexGroupResultsSenat] = useState([]);
    const [cityGroupResultsSenat, setCityGroupResultsSenat] = useState([]);
    const [countryGroupResultsSenat, setCountryGroupResultsSenat] = useState([]);
    const [groupResultsSenat, setGroupResultsSenat] = useState([]);
    const [groupMandates, setGroupMandates] = useState([]);
    const [prediction, setPrediction] = useState([]);

    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchStats = async () => {
            try {
                const response = await axios.get('https://localhost:8080/api/stats/allResults/1');
                setAgeGroupResults(response.data.resultsByAgeGroup);
                setEducationGroupResults(response.data.resultsByEducation);
                setSexGroupResults(response.data.resultsBySex);
                setCityGroupResults(response.data.resultsByCityType);
                setCountryGroupResults(response.data.resultsByCountry);
                setSejmGroupResults(response.data.results);
                const response2 = await axios.get('https://localhost:8080/api/stats/allResults/2');
                setAgeGroupResultsSenat(response2.data.resultsByAgeGroup);
                setEducationGroupResultsSenat(response2.data.resultsByEducation);
                setSexGroupResultsSenat(response2.data.resultsBySex);
                setCityGroupResultsSenat(response2.data.resultsByCityType);
                setCountryGroupResultsSenat(response2.data.resultsByCountry);
                setGroupResultsSenat(response2.data.results);
                const response3 = await axios.get('https://localhost:8080/api/stats/mandates/1');
                setGroupMandates(response3.data);
                const response4 = await axios.get('https://localhost:8080/api/stats/prediction/Parliamentary');
                setPrediction(response4.data);

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

    const ageGroups2 = Object.keys(ageGroupResultsSenat);
    const educationGroups2 = Object.keys(educationGroupResultsSenat);
    const sexGroups2 = Object.keys(sexGroupResultsSenat);
    const cityGroups2 = Object.keys(cityGroupResultsSenat);
    const countryGroups2 = Object.keys(countryGroupResultsSenat);


    const countryGroupCharts2 = countryGroups2.map((countryGroup2, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla danego kraju {countryGroup2}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={countryGroupResultsSenat[countryGroup2]} partyName={`Kraj: ${countryGroup2}`} />
            </div>
        </div>
    ));

    const countryGroupCharts = countryGroups.map((countryGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla danego kraju {countryGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={countryGroupResults[countryGroup]} partyName={`Kraj: ${countryGroup}`} />
            </div>
        </div>
    ));

    const cityGroupCharts2 = cityGroups2.map((cityGroup2, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla typu miasta: {cityGroup2} mieszkańców</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={cityGroupResultsSenat[cityGroup2]} partyName={`Miasto: ${cityGroup2} mieszkańców`} />
            </div>
        </div>
    ));

    const sexGroupCharts2 = sexGroups2.map((sexGroup2, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla płci: {sexGroup2}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <DoughnutChart data={sexGroupResultsSenat[sexGroup2]} partyName={`Płeć: ${sexGroup2}`} />
            </div>
        </div>
    ));

    const ageGroupCharts2 = ageGroups2.map((ageGroup2, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy wiekowej: {ageGroup2} lat</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={ageGroupResultsSenat[ageGroup2]} partyName={`Grupa wiekowa: ${ageGroup2} lat`} />
            </div>
        </div>
    ));
    const educationGroupCharts2 = educationGroups2.map((educationGroup2, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla wykształcenia wyborców: {educationGroup2}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={educationGroupResultsSenat[educationGroup2]} partyName={`Wykształcenie: ${educationGroup2}`} />
            </div>
        </div>
    ));



    const cityGroupCharts = cityGroups.map((cityGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla typu miasta: {cityGroup} mieszkańców</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={cityGroupResults[cityGroup]} partyName={`Typ miasta: ${cityGroup} mieszkańców`} />
            </div>
        </div>
    ));

    const sexGroupCharts = sexGroups.map((sexGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla płci: {sexGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <DoughnutChart data={sexGroupResults[sexGroup]} partyName={`Płeć: ${sexGroup}`} />
            </div>
        </div>
    ));

    const ageGroupCharts = ageGroups.map((ageGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla grupy wiekowej {ageGroup} lat</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={ageGroupResults[ageGroup]} partyName={`Grupa wiekowa ${ageGroup} lat`} />
            </div>
        </div>
    ));
    const educationGroupCharts = educationGroups.map((educationGroup, index) => (
        <div key={index} className="p-4 bg-white rounded-lg shadow-md">
            <h3 className="text-lg font-semibold">Głosy dla wykształcenia wyborców: {educationGroup}</h3>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <PolarAreaChart data={educationGroupResults[educationGroup]} partyName={`Wykształcenie wyborcy: ${educationGroup}`} />
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
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <h3 className="text-lg font-semibold mb-4 text-center">Wyniki głosowania</h3>
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <div className="grid grid-cols-2 gap-4">
                                <BarChart data={sejmGroupResults} />
                            </div>
                        </div>
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <h3 className="text-lg font-semibold mb-4 text-center">Podział mandatów</h3>
                            <div className="grid grid-cols-2 gap-4">
                                <PieChart data={groupMandates} />
                            </div>
                        </div>
                        <div className="p-4 bg-white rounded-lg shadow-md">
                            <h3 className="text-lg font-semibold mb-4 text-center">Predykcja na następne wybory</h3>
                            <div className="grid grid-cols-2 gap-4">
                                <PieChart data={prediction} />
                            </div>
                        </div>
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wynik głosowania z podziałem na grupy wiekowe</h2>
                        <hr className="my-8" />
                        {ageGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na wykształcenie wyborców</h2>
                        <hr className="my-8" />
                        {educationGroupCharts}
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na płeć wyborców</h2>
                        <hr className="my-8" />
                        {sexGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na typy miast wyborców</h2>
                        <hr className="my-8" />
                        {cityGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na kraj</h2>
                        <hr className="my-8" />
                        {countryGroupCharts}
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                        <hr className="my-8" />
                    </div>
                </div>
            </div>
            <div className="container mx-auto p-4">
                <div className="bg-gray-200 mb-8">
                    <div className="container mx-auto p-4">
                        <h2 className="text-3xl font-semibold mb-4 text-center">Senat</h2>
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-8">
                            <hr className="my-8" />
                            <div className="p-4 bg-white rounded-lg shadow-md">
                                <hr className="my-8" />
                                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                                    <BarChart data={groupResultsSenat} />
                                </div>
                            </div>
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <h2 className="text-xl font-semibold mb-4 text-center">Wynik głosowania z podziałem na grupy wiekowe</h2>
                            <hr className="my-8" />
                            {ageGroupCharts2}
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na wykształcenie wyborców</h2>
                            <hr className="my-8" />
                            {educationGroupCharts2}
                            <hr className="my-8" />
                            <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na płeć wyborców</h2>
                            <hr className="my-8" />
                            {sexGroupCharts2}
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na typy miast wyborców</h2>
                            <hr className="my-8" />
                            {cityGroupCharts2}
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <h2 className="text-xl font-semibold mb-4 text-center">Wyniki głosowania z podziałem na kraj</h2>
                            <hr className="my-8" />
                            {countryGroupCharts2}
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <hr className="my-8" />
                            <hr className="my-8" />
                        </div>
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

const PieChart = ({ data}) => {
    const chartData = {
        labels: Object.keys(data),
        datasets: [
            {
                label: `Liczba mandatów`,
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
                position: 'left',
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

const DoughnutChart = ({ data, partyName }) => {
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

    return <Doughnut data={chartData} options={chartOptions} />;
};
export default StatsPage;