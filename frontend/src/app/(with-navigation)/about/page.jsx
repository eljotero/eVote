import React from 'react';
import {BiSolidUserAccount} from "react-icons/bi";
import {BsFillPersonVcardFill} from "react-icons/bs";
import {BsFillPersonCheckFill} from "react-icons/bs";
import {FaVoteYea} from "react-icons/fa";
import Image from 'next/image';
import './page.css';

export default function About() {
    return (
        <>
            <section className="bg-gray-50 min-h-auto flex-1 flex items-center justify-center px-16 pt-28 lg:pt-20"
                     aria-label="Sekcja instrukcji głosowania">
                <div className="lg:absolute lg:top-20 lg:right-20 lg:mb-8 lg:mr-8 hidden sm:hidden md:hidden lg:block">
                    <Image
                        src="https://firebasestorage.googleapis.com/v0/b/gnomenciaga.appspot.com/o/evote%2Fevote-about2.png?alt=media&token=1cdcf4f7-7089-461b-b94f-36cef059a75b"
                        alt="Waga" width="600" height="600"
                        priority={true}/>
                </div>

                <div className="relative w-full max-w-2xl">
                    <div
                        className="absolute top-0 -left-4 w-72 h-72 bg-blue-300 rounded-full mix-blend-multiply filter blur-xl opacity-70 animate-blob"></div>
                    <div
                        className="absolute top-16 -right-4 w-72 h-72 bg-amber-300 rounded-full mix-blend-multiply filter blur-xl opacity-70 animate-blob animation-delay-2000"></div>
                    <div
                        className="absolute -bottom-32 left-60 w-72 h-72 bg-cyan-300 rounded-full mix-blend-multiply filter blur-xl opacity-70 animate-blob animation-delay-4000"></div>

                    <div className="m-8 relative space-y-8 z-10">

                        <div className="flex flex-col md:flex-row bg-transparent rounded-xl gap-10">
                            <div className="w-full md:w-[500px] flex justify-center md:justify-end">
                                <div
                                    className="w-[120px] h-[120px] bg-white border border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 hover:bg-gradient-to-r hover:from-blue-50 hover:to-cyan-50 flex justify-center items-center">
                                    <BiSolidUserAccount size={60}/>
                                </div>
                            </div>

                            <div
                                className="bg-white border md:w-[110em] border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 hover:bg-gradient-to-r hover:from-blue-50 hover:to-cyan-50">
                                <h1 className="font-bold text-xl">1. Załóż konto</h1>
                                <p>
                                    Aby rozpocząć, załóż konto na naszej platformie. Kliknij przycisk &quot;Zaloguj
                                    się&quot;, a następnie &quot;Rejestracja&quot; i podaj swój adres e-mail oraz hasło.
                                </p>
                            </div>
                        </div>

                        <div className="flex flex-col md:flex-row bg-transparent rounded-xl gap-10">
                            <div className="w-full md:w-[500px] flex justify-center md:justify-end">
                                <div
                                    className="w-[120px] h-[120px] bg-white border border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-amber-400 hover:shadow-lg hover:shadow-amber-600/20 hover:bg-gradient-to-r hover:from-amber-50 hover:to-yellow-50 flex justify-center items-center">
                                    <BsFillPersonVcardFill size={60}/>
                                </div>
                            </div>
                            <div
                                className="bg-white border md:w-[110em] border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-amber-400 hover:shadow-lg hover:shadow-amber-600/20 hover:bg-gradient-to-r hover:from-amber-50 hover:to-yellow-50">
                                <h1 className="font-bold text-xl">2. Wypełnij potrzebne dane</h1>
                                <p>
                                    Po zalogowaniu się, wejdź w zakładkę &quot;Moje konto&quot; i wypełnij dodatkowe
                                    informacje potrzebne do weryfikacji tożsamości.
                                    Wprowadź swoje dane osobowe, takie jak PESEL czy adres zamieszkania. Wszystkie dane
                                    są
                                    zabezpieczone i przetwarzane zgodnie z przepisami o ochronie danych osobowych.
                                </p>
                            </div>
                        </div>

                        <div className="flex flex-col md:flex-row bg-transparent rounded-xl gap-10">
                            <div className="w-full md:w-[500px] flex justify-center md:justify-end">
                                <div
                                    className="w-[120px] h-[120px] bg-white border border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-cyan-400 hover:shadow-lg hover:shadow-cyan-600/20 hover:bg-gradient-to-r hover:from-cyan-50 hover:to-sky-50 flex justify-center items-center">
                                    <BsFillPersonCheckFill size={60}/>
                                </div>
                            </div>
                            <div
                                className="bg-white border md:w-[110em] border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-cyan-400 hover:shadow-lg hover:shadow-cyan-600/20 hover:bg-gradient-to-r hover:from-cyan-50 hover:to-sky-50">
                                <h1 className="font-bold text-xl">3. Znajdź swojego kandydata</h1>
                                <p>
                                    Następnie przejdź do sekcji &quot;Kandydaci&quot;. Tam znajdziesz listę dostępnych
                                    wyborów oraz kandydatów.
                                    Możesz przeglądać profile kandydatów, czytać ich programy wyborcze i zapoznać się z
                                    ich
                                    priorytetami.
                                </p>
                            </div>
                        </div>

                        <div className="flex flex-col md:flex-row bg-transparent rounded-xl gap-10">
                            <div className="w-full md:w-[500px] flex justify-center md:justify-end">
                                <div
                                    className="w-[120px] h-[120px] bg-white border border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-yellow-400 hover:shadow-lg hover:shadow-yellow-600/20 hover:bg-gradient-to-r hover:from-yellow-50 hover:to-amber-50 flex justify-center items-center">
                                    <FaVoteYea size={60}/>
                                </div>
                            </div>
                            <div
                                className="bg-white border md:w-[110em] border-gray-200 rounded-xl p-4 shadow-lg duration-300 hover:border-yellow-400 hover:shadow-lg hover:shadow-yellow-600/20 hover:bg-gradient-to-r hover:from-yellow-50 hover:to-amber-50">
                                <h1 className="font-bold text-xl">4. Zagłosuj</h1>
                                <p>
                                    Gdy już zdecydujesz, na kogo chcesz oddać głos, w sekcji &quot;Moje
                                    konto&quot; wygeneruj kod umożliwiający zagłosowanie.
                                    Po otrzymaniu go na podany adres e-mail, przejdź do sekcji &quot;Zagłosuj&quot; i
                                    wpisz
                                    kod.
                                    Twój głos na wybranego kandydata zostanie zarejestrowany i możesz być pewny, że jest
                                    bezpieczny i anonimowy.
                                </p>
                            </div>
                        </div>

                    </div>
                </div>

            </section>
            <div className="lg:fixed bottom-0 lg:left-0 lg:mr-8 hidden sm:hidden md:hidden lg:block ">
                <Image src="https://storage.googleapis.com/evote_c/evote-about.png" width="810" height="409"
                       alt="Troje ludzi zachęcających do głosowania" className="max-w-[50em]"
                       priority={true}/>
            </div>
        </>
    );
};


