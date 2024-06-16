import React from 'react';
import Image from 'next/image';
import contact from '../../../../public/images/evote-info.png';
import Link from "next/link";


export default function Contact() {
    return (
        <section className="bg-white relative pt-8 pb-16 lg:pt-20" aria-label="Sekcja główna">
            <div className="relative xl:container m-auto px-6 md:px-12 lg:px-6">
                <div className="lg:flex">
                    <div
                        className="mt-8 md:mt-16 space-y-8 sm:w-10/12 md:w-2/3 xl:ml-[60em] sm:mx-auto text-center lg:text-right lg:mr-auto lg:w-6/12">
                        <p className="sm:text-lg text-gray-700 lg:w-11/12">
                            Projekt stworzony w ramach przedmiotu [nazwa]
                        </p>
                        <span className="block font-semibold text-gray-500">
                            Obrazy zostały pobrane ze strony <Link href='https://www.canva.com'
                                                                   className='hover:underline'
                                                                   aria-label="Canva">Canva</Link>, utworzone przez zespół Canvy na darmowej licencji i użyte w celach niekomercyjnych.
                        </span>
                        <div className="grid grid-cols-1 gap-4 md:gap-6">
                            <div
                                className="p-4 border border-gray-200 rounded-full duration-300 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 hover:bg-gradient-to-r hover:from-blue-50 hover:to-cyan-50 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <span className="font-medium md:block text-center"><span className="font-bold">Imię Nazwisko</span> (nr indeksu)</span>
                                </div>
                            </div>
                            <div
                                className="p-4 border border-gray-200 rounded-full duration-300 hover:border-amber-400 hover:shadow-lg hover:shadow-amber-600/20 hover:bg-gradient-to-r hover:from-amber-50 hover:to-yellow-50 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <span className="font-medium md:block text-center"><span className="font-bold">Imię Nazwisko</span> (nr indeksu)</span>
                                </div>
                            </div>
                            <div
                                className="p-4 border border-gray-200 rounded-full duration-300 hover:border-cyan-400 hover:shadow-lg hover:shadow-cyan-600/20 hover:bg-gradient-to-r hover:from-cyan-50 hover:to-blue-50 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <span className="font-medium md:block text-center"><span className="font-bold">Imię Nazwisko</span> (nr indeksu)</span>
                                </div>
                            </div>
                            <div
                                className="p-4 border border-gray-200 rounded-full duration-300 hover:border-yellow-400 hover:shadow-lg hover:shadow-yellow-600/20 hover:bg-gradient-to-r hover:from-yellow-50 hover:to-amber-50 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <span className="font-medium md:block text-center"><span className="font-bold">Imię Nazwisko</span> (nr indeksu)</span>
                                </div>
                            </div>
                            <div
                                className="p-4 border border-gray-200 rounded-full duration-300 hover:border-blue-400 hover:shadow-lg hover:shadow-blue-600/20 hover:bg-gradient-to-r hover:from-blue-50 hover:to-cyan-50 flex items-center justify-center">
                                <div className="flex justify-center items-center space-x-4">
                                    <span className="font-medium md:block text-center"><span className="font-bold">Imię Nazwisko</span> (nr indeksu)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="mt-12 md:mt-0 xl:absolute left-0 lg:w-7/12">
                        <div className="relative w-full">
                            <div aria-hidden="true"
                                 className="absolute scale-75 md:scale-110 inset-0 right-80 bottom-80 m-auto w-full h-full md:w-96 md:h-96 rounded-full rotate-45"></div>
                            <Image src={contact} alt="Ilustracja kobiety zaznaczającej swój wybór na karcie głosowań" className="relative w-full" loading='lazy'
                                   layout='responsive'/>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
};

