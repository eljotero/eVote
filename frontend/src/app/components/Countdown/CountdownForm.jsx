import React, { useState, useEffect } from 'react';

export default function CountdownForm({ initialCount }) {
    const parseDate = (dateStr) => {
        if (typeof dateStr !== 'string') {
            return null;
        }

        const [day, month, year] = dateStr.split('.').map(Number);
        return new Date(year, month - 1, day);
    };

    const targetDate = parseDate(initialCount);

    const calculateCountdown = () => {
        if (!targetDate) {
            return 0;
        }

        return Math.floor((targetDate - new Date()) / 1000);
    };

    const [countdown, setCountdown] = useState(calculateCountdown());

    useEffect(() => {
        const timer = setInterval(() => {
            const newCountdown = calculateCountdown();
            setCountdown(newCountdown);

            if (newCountdown <= 0) {
                clearInterval(timer);
            }
        }, 1000);

        return () => clearInterval(timer);
    }, [initialCount]);

    if (countdown <= 0) {
        return (
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', position: 'relative' }}>
                <div style={{ position: 'absolute', textAlign: 'center' }}>
                    <h2 style={{ color: 'black' }}>Wybory trwają.</h2>
                </div>
            </div>
        );
    }

    const seconds = Math.floor(countdown % 60);
    const minutes = Math.floor((countdown / 60) % 60);
    const hours = Math.floor((countdown / (60 * 60)) % 24);
    const days = Math.floor(countdown / (60 * 60 * 24));

    if (!targetDate) {
        return <div>Zły format daty (DD.MM.YYYY).</div>;
    }

    return (
        <div className="flex justify-center items-center relative">
            <div className="text-center">
                <h2 className="text-black">
                    <span className=" mr-1">{days} dni </span> 
                    <span className=" mr-1">{hours} godzin </span>
                    <span className=" mr-1">{minutes} minut </span> 
                    <span className=" mr-1">{seconds} sekund </span> 
                </h2>
            </div>
        </div>
    );
}