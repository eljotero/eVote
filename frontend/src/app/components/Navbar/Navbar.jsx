'use client'

import React from 'react';
import Link from 'next/link';
import {usePathname} from "next/navigation";
import { FaVoteYea } from "react-icons/fa";

export default function Navbar() {
    const paths = ['/'];
    const currentPath = usePathname();

    // a simple solution to display navbar only on specific pages - will work for now
    if (!paths.includes(currentPath)) {
        return null;
    }

    return (
        <nav>
            <div className="max-w-screen-xl flex flex-wrap justify-between items-center mx-auto px-10 py-2 ">
                <h1 className="text-xl font-bold">
                    <Link href="/">
                        <FaVoteYea/>
                        eVote
                    </Link>
                </h1>
                <div className="flex items-center">
                    <ul className="flex items-center space-x-6 font-semibold">
                        <li>
                            <Link className="nav-link" href="/login">Login</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}
