import Navbar from '@/app/components/Navbar/Navbar';

export default function Layout({children}) {
    return (
        <>
            <Navbar/>
            <main style={{height: '100%' }}>{children}</main>
        </>
    );
}