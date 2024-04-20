'use client'

import React from 'react';
import Link from 'next/link';
import {usePathname} from "next/navigation";
import {FaBars, FaTimes} from "react-icons/fa";

export default function Navbar() {
    const paths = ['/'];
    const currentPath = usePathname();

    if (!paths.includes(currentPath)) {
        return null;
    }

    return (
        <nav>
            <ul>
                <li><Link href='/'>Home</Link></li>
                <li><Link href='/login'>Login</Link></li>
            </ul>
        </nav>
    );
}
