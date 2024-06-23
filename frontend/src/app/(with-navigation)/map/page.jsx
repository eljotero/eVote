'use client'
import React from 'react';

export default function MapPage() {
    return (
        <div className="text-gray-900 pt-12 pr-0 pb-14 pl-0 bg-white">
            <div className="w-full pt-4 pr-5 pb-6 pl-5 mt-0 mr-auto mb-0 ml-auto space-y-5 sm:py-8 md:py-12 sm:space-y-8 md:space-y-16
      max-w-7xl">
                <div className="flex flex-col items-center sm:px-5 md:flex-row">
                    <div
                        className="flex flex-col items-start justify-center w-full h-full pt-6 pr-0 pb-6 pl-0 mb-6 md:mb-0 md:w-1/2">
                        <div className="flex flex-col items-start justify-center h-full space-y-3 transform md:pr-10 lg:pr-16
            md:space-y-5">

                            <h1 className="sm:mx-auto sm:w-10/12 md:w-2/3 font-black text-blue-900 text-2xl text-center sm:text-3xl md:text-4xl lg:w-auto lg:text-left xl:text-5xl">
                                Wybierz swój region <br className="lg:block hidden"/>
                                <span className="relative text-transparent bg-clip-text bg-gradient-to-r from-blue-600 to-cyan-500">
        i poznaj swoich kandydatów!
    </span>
                            </h1>

                        </div>
                    </div>
                    <div className="w-full md:w-1/2">
                        <div className="block">
                            <img
                                src="https://storage.googleapis.com/evote_c/evote-about.png"
                                className="object-cover rounded-lg max-h-64 sm:max-h-96 btn- w-full h-full"/>
                        </div>
                    </div>
                </div>
                <div className="map-page" style={{width: '100%', height: '98vh'}}>
                    <iframe src="map.html" style={{width: '100%', height: '100%'}}></iframe>
                </div>

            </div>
        </div>
    );
}