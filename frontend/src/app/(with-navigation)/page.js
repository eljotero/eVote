import React from 'react';
import {FaQuestion} from "react-icons/fa";
import {GoPersonFill} from "react-icons/go";
import {MdHowToVote} from "react-icons/md";
import Image from 'next/image';
import evote from '../../../public/evote-home.png';
import Link from "next/link";

export default function Home() {
    return (
        <section className="bg-white relative pt-28 pb-16 lg:pt-20" aria-label="Sekcja główna">
            <div className="relative xl:container m-auto px-6 md:px-12 lg:px-6">
                <h1 className="sm:mx-auto sm:w-10/12 md:w-2/3 font-black text-blue-900 text-4xl text-center sm:text-5xl md:text-6xl lg:w-auto lg:text-left xl:text-7xl">
                    Nowoczesny <br className="lg:block hidden"/>
                    <span className="relative text-transparent bg-clip-text bg-gradient-to-r from-blue-600 to-cyan-500">
                        system głosowania
                    </span>
                </h1>
                <div className="lg:flex">
                    <div
                        className="relative mt-8 md:mt-16 space-y-8 sm:w-10/12 md:w-2/3 lg:ml-0 sm:mx-auto text-center lg:text-left lg:mr-auto lg:w-6/12">
                        <p className="sm:text-lg text-gray-700 lg:w-11/12">
                            Witaj na eVote, platformie do elektronicznego głosowania, dzięki któremu możesz w wygodny
                            dla siebie sposób uczestniczyć w demokracji.
                            Nasza aplikacja zapewnia bezpieczny, szybki i wygodny sposób oddania głosu bez konieczności
                            wychodzenia z domu.
                        </p>
                        <span className="block font-semibold text-gray-500">
                            <Link href='/login' className='hover:underline' aria-label="Zarejestruj się teraz">Zarejestruj się teraz</Link> i bądź częścią zmiany!
                        </span>

                        <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 md:gap-6">
                            <Link aria-label="Dowiedz się, jak to działa" href="/about"
                                  className="p-4 border border-gray-200 rounded-full duration-300 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <FaQuestion size={32}/>
                                    <span
                                        className="font-medium md:block text-center">Dowiedz się, jak to działa</span>
                                </div>
                            </Link>
                            <Link aria-label="Poznaj kandydatów" href="/map"
                                  className="p-4 border border-gray-200 rounded-full duration-300 hover:border-amber-400 hover:shadow-lg hover:shadow-amber-600/20 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <GoPersonFill size={32}/>
                                    <span className="font-medium md:block text-center">Poznaj kandydatów</span>
                                </div>
                            </Link>
                        </div>
                        <div className="mt-4 grid grid-cols-1 lg:grid-cols-2">
                            <Link aria-label="Zagłosuj" href="/vote"
                                  className="p-4 border border-gray-200 rounded-full duration-300 hover:border-cyan-400 hover:shadow-lg hover:shadow-cyan-600/20 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <MdHowToVote size={32}/>
                                    <span className="font-medium md:block text-center">Zagłosuj</span>
                                </div>
                            </Link>
                        </div>
                    </div>
                    <div className="mt-12 md:mt-0 lg:absolute -right-24 lg:w-7/12">
                        <div className="relative w-full">
                            <div aria-hidden="true"
                                 className="absolute scale-75 md:scale-110 inset-0 m-auto w-full h-full md:w-96 md:h-96 rounded-full rotate-45 bg-gradient-to-r from-blue-500 to-sky-300 blur-3xl"></div>
                            <Image src={evote} alt="Opis obrazu" className="relative w-full" loading='lazy'
                                   layout='responsive'/>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
};
