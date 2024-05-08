import { Inter } from 'next/font/google';
import { Toaster } from "react-hot-toast";
import './globals.css';
import Navbar from '@/app/components/Navbar/Navbar';
import StoreProvider from '../store/StoreProvider';

const inter = Inter({ subsets: ['latin'] });

export const metadata = {
  title: 'eVote',
  description: 'Aplikacja do głosowania w wyborach online',
};

export default function RootLayout({ children }) {
  return (
    <StoreProvider>
      <html lang='pl'>
        <body className={inter.className}>
          <Navbar />
          <Toaster position="top-center" />
          {children}
        </body>
      </html>
    </StoreProvider>
  );
}
