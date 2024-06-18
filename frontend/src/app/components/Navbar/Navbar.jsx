'use client';
import Image from 'next/image';
import Link from 'next/link';
import React, {useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {clearID} from '../../../store/idSlice';
import {clearToken} from '../../../store/tokenSlice';
import {useRouter} from 'next/navigation';

export default function Navbar() {
    const [isMenuOpen, setIsMenuOpen] = useState(false);
    const token = useSelector((state) => state.token.value);
    const dispatch = useDispatch();
    const router = useRouter();

    const toggleMenu = () => {
        setIsMenuOpen(!isMenuOpen);
    };

    const logout = () => {
        dispatch(clearToken());
        dispatch(clearID());
        router.push('/');
    };

    return (
        <>
            <nav
                className='relative px-4 py-4 flex justify-between items-center bg-white'
                aria-label='Główna nawigacja'
            >
                <a
                    className='text-3xl font-bold leading-none'
                    href='/'
                    aria-label='Strona główna'
                >
                    <span className="text-transparent bg-clip-text bg-gradient-to-r from-blue-900 to-blue-500">
                        eVote
                    </span>
                </a>
                <div className='lg:hidden'>
                    <button
                        className='navbar-burger flex items-center text-blue-500 p-3'
                        onClick={toggleMenu}
                        aria-label='Przełącznik menu'
                    >
                        <svg
                            className='block h-4 w-4 fill-current'
                            viewBox='0 0 20 20'
                            xmlns='http://www.w3.org/2000/svg'
                        >
                            <title>Menu mobilne</title>
                            <path d='M0 3h20v2H0V3zm0 6h20v2H0V9zm0 6h20v2H0v-2z'></path>
                        </svg>
                    </button>
                </div>
                <ul
                    className={`hidden absolute top-1/2 left-1/2 transform -translate-y-1/2 -translate-x-1/2 lg:flex lg:mx-auto lg:items-center lg:w-auto lg:space-x-6 ${
                        isMenuOpen ? '' : 'hidden'
                    }`}
                >
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/'
                            aria-label='Strona główna'
                        >
                            Strona główna
                        </Link>
                    </li>
                    <li className='text-gray-300'>
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            fill='none'
                            stroke='currentColor'
                            className='w-4 h-4 current-fill'
                            viewBox='0 0 24 24'
                        >
                            <path
                                strokeLinecap='round'
                                strokeLinejoin='round'
                                strokeWidth='2'
                                d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                            />
                        </svg>
                    </li>
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/about'
                            aria-label='Jak zagłosować'
                        >
                            Jak zagłosować
                        </Link>
                    </li>
                    <li className='text-gray-300'>
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            fill='none'
                            stroke='currentColor'
                            className='w-4 h-4 current-fill'
                            viewBox='0 0 24 24'
                        >
                            <path
                                strokeLinecap='round'
                                strokeLinejoin='round'
                                strokeWidth='2'
                                d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                            />
                        </svg>
                    </li>
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/map'
                            aria-label='Kandydaci'
                        >
                            Kandydaci
                        </Link>
                    </li>
                    <li className='text-gray-300'>
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            fill='none'
                            stroke='currentColor'
                            className='w-4 h-4 current-fill'
                            viewBox='0 0 24 24'
                        >
                            <path
                                strokeLinecap='round'
                                strokeLinejoin='round'
                                strokeWidth='2'
                                d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                            />
                        </svg>
                    </li>
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/vote'
                            aria-label='Zagłosuj'
                        >
                            Zagłosuj
                        </Link>
                    </li>
                    <li className='text-gray-300'>
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            fill='none'
                            stroke='currentColor'
                            className='w-4 h-4 current-fill'
                            viewBox='0 0 24 24'
                        >
                            <path
                                strokeLinecap='round'
                                strokeLinejoin='round'
                                strokeWidth='2'
                                d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                            />
                        </svg>
                    </li>
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/stats'
                            aria-label='Aktualne statystyki'
                        >
                            Aktualne statystyki
                        </Link>
                    </li>
                    <li className='text-gray-300'>
                        <svg
                            xmlns='http://www.w3.org/2000/svg'
                            fill='none'
                            stroke='currentColor'
                            className='w-4 h-4 current-fill'
                            viewBox='0 0 24 24'
                        >
                            <path
                                strokeLinecap='round'
                                strokeLinejoin='round'
                                strokeWidth='2'
                                d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                            />
                        </svg>
                    </li>
                    <li>
                        <Link
                            className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                            href='/info'
                            aria-label='Informacje'
                        >
                            Informacje
                        </Link>
                    </li>
                    {token ? (
                        <>
                            <li className='text-gray-300'>
                                <svg
                                    xmlns='http://www.w3.org/2000/svg'
                                    fill='none'
                                    stroke='currentColor'
                                    className='w-4 h-4 current-fill'
                                    viewBox='0 0 24 24'
                                >
                                    <path
                                        strokeLinecap='round'
                                        strokeLinejoin='round'
                                        strokeWidth='2'
                                        d='M12 5v0m0 7v0m0 7v0m0-13a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2zm0 7a1 1 0 110-2 1 1 0 010 2z'
                                    />
                                </svg>
                            </li>
                            <li>
                                <Link
                                    className='text-sm font-semibold text-gray-400 hover:text-blue-600 duration-300'
                                    href='/account'
                                    aria-label='Moje konto'
                                >
                                    Moje konto
                                </Link>
                            </li>
                        </>
                    ) : null}
                </ul>
                {!token ? (
                    <Link
                        className='hidden lg:inline-block py-2 px-6 border border-blue-200 text-sm text-sky-500 font-bold rounded-xl hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-600/20 hover:text-white duration-300'
                        href='/login'
                        aria-label='Zaloguj się'
                    >
                        Zaloguj się
                    </Link>
                ) : (
                    <button
                        onClick={logout}
                        className='hidden lg:inline-block py-2 px-6 border border-blue-200 text-sm text-sky-500 font-bold rounded-xl hover:bg-blue-500 hover:shadow-lg hover:shadow-blue-600/20 hover:text-white duration-300'
                    >
                        Wyloguj
                    </button>
                )}
            </nav>
            <div
                className={`navbar-menu relative z-50 ${isMenuOpen ? '' : 'hidden'}`}
                aria-label='Menu mobilne'
            >
                <div className='navbar-backdrop fixed inset-0 bg-gray-800 opacity-25'></div>
                <nav
                    className='fixed top-0 left-0 bottom-0 flex flex-col w-5/6 max-w-sm py-6 px-6 bg-white border-r overflow-y-auto'
                    aria-label='Nawigacja mobilna'
                >
                    <div className='flex items-center mb-8'>
                        <a
                            className='mr-auto text-3xl font-bold leading-none'
                            href='/'
                            aria-label='Strona główna'
                        >
                            <span className="text-transparent bg-clip-text bg-gradient-to-r from-blue-900 to-blue-500">
                                 eVote
                            </span>
                        </a>
                        <button
                            className='navbar-close'
                            onClick={toggleMenu}
                            aria-label='Zamknij menu'
                        >
                            <svg
                                className='h-6 w-6 text-gray-400 cursor-pointer hover:text-gray-500'
                                xmlns='http://www.w3.org/2000/svg'
                                fill='none'
                                viewBox='0 0 24 24'
                                stroke='currentColor'
                            >
                                <path
                                    strokeLinecap='round'
                                    strokeLinejoin='round'
                                    strokeWidth='2'
                                    d='M6 18L18 6M6 6l12 12'
                                ></path>
                            </svg>
                        </button>
                    </div>
                    <div>
                        <ul aria-label='Elementy mobilnego menu'>
                            <li className='mb-1'>
                                <Link
                                    className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                    href='/'
                                    aria-label='Strona główna'
                                >
                                    Strona główna
                                </Link>
                            </li>
                            <li className='mb-1'>
                                <Link
                                    className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                    href='/about'
                                    aria-label='Jak zagłosować'
                                >
                                    Jak zagłosować
                                </Link>
                            </li>
                            <li className='mb-1'>
                                <Link
                                    className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                    href='/map'
                                    aria-label='Kandydaci'
                                >
                                    Kandydaci
                                </Link>
                            </li>
                            <li className='mb-1'>
                                <Link
                                    className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                    href='/vote'
                                    aria-label='Zagłosuj'
                                >
                                    Zagłosuj
                                </Link>
                            </li>
                            <li className='mb-1'>
                                <Link
                                    className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                    href='/info'
                                    aria-label='Informacje'
                                >
                                    Informacje
                                </Link>
                            </li>
                            {token ? (
                                <>
                                    <li>
                                        <Link
                                            className='block p-4 text-sm font-semibold text-gray-400 hover:bg-blue-50 hover:text-blue-600 rounded duration-300'
                                            href='/account'
                                            aria-label='Moje konto'
                                        >
                                            Moje konto
                                        </Link>
                                    </li>
                                </>
                            ) : null}
                        </ul>
                    </div>
                    <div className='mt-auto'>
                        <div className='pt-6'>
                            {!token ? (
                                <Link
                                    className='block px-4 py-3 mb-2 leading-loose text-sm text-center font-semibold border text-sky-500 border-blue-200 hover:bg-blue-500 hover:text-white hover:shadow-lg hover:shadow-blue-600/20 rounded-xl duration-300'
                                    href='/login'
                                    aria-label='Zaloguj się'
                                >
                                    Zaloguj się
                                </Link>
                            ) : (
                                <button
                                    onClick={logout}
                                    className='block px-4 py-3 mb-2 leading-loose text-sm text-center font-semibold border text-sky-500 border-blue-200 hover:bg-blue-500 hover:text-white hover:shadow-lg hover:shadow-blue-600/20 rounded-xl duration-300'
                                    aria-label='Wyloguj'
                                >
                                    Wyloguj
                                </button>
                            )}
                        </div>
                    </div>
                </nav>
            </div>
        </>
    );
}
