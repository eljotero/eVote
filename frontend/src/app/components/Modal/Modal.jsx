import React from 'react';
import { motion, AnimatePresence } from 'framer-motion';

const dropIn = {
    hidden: {
        y: "-100vh",
        opacity: 0,
    },
    visible: {
        y: "0",
        opacity: 1,
        transition: {
            duration: 0.3,
            type: "spring",
            damping: 25,
            stiffness: 500,
        },
    },
    exit: {
        y: "100vh",
        opacity: 0,
    },
};

export default function Modal ({ showForm, setShowForm, votingCode, setVotingCode, verifyVotingCode }) {
    return (
        <AnimatePresence>
            {showForm && (
                <motion.div
                    className="fixed inset-0 flex items-center justify-center z-50"
                    initial="hidden"
                    animate="visible"
                    exit="exit"
                    variants={dropIn}
                >
                    <motion.div
                        className="bg-white p-8 rounded-lg shadow-lg shadow-gray-500 border border-gray-200 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-400 duration-300 max-w-md w-full relative"
                        initial={{ opacity: 0 }}
                        animate={{ opacity: 1 }}
                        exit={{ opacity: 0 }}
                        transition={{ duration: 0.3 }}
                    >
                        <button
                            className="absolute top-0 right-0 m-4 p-2 text-gray-700 hover:text-gray-900"
                            onClick={() => setShowForm(false)}
                            aria-label="Zamknij"
                        >
                            <svg
                                className="h-6 w-6 text-gray-400 cursor-pointer hover:text-gray-500"
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                            >
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12"></path>
                            </svg>
                        </button>
                        <h1 className="text-xl font-semibold mb-4">Wpisz kod otrzymany w mailu</h1>
                        <div className="mb-4">
                            <input
                                type="text"
                                placeholder="Twój kod"
                                value={votingCode}
                                onChange={(e) => setVotingCode(e.target.value)}
                                className="email-input w-full px-4 py-2 border rounded text-gray-700 focus:border-gray-200 focus:outline-none focus:ring-1 focus:ring-offset-1 focus:ring-gray-300 transition-colors duration-300"
                            />
                        </div>
                        <button
                            className="mt-2 py-1 px-4 bg-blue-400 hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-500/20 text-md text-white font-bold rounded transition duration-300"
                            aria-label="Zweryfikuj kod i oddaj głos"
                            onClick={verifyVotingCode}
                        >
                            Zweryfikuj kod i oddaj głos
                        </button>
                    </motion.div>
                </motion.div>
            )}
        </AnimatePresence>
    );
};

