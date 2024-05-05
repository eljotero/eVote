import { Inter } from 'next/font/google';
import './globals.css';
import Navbar from '@/app/components/Navbar/Navbar';
import StoreProvider from '../store/StoreProvider';

const inter = Inter({ subsets: ['latin'] });

export const metadata = {
  title: 'eVote',
  description: 'A simple voting app',
};

export default function RootLayout({ children }) {
  return (
    <StoreProvider>
      <html lang='en'>
        <body className={inter.className}>
          <Navbar />
          {children}
        </body>
      </html>
    </StoreProvider>
  );
}
