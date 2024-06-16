import Navbar from '@/app/components/Navbar/Navbar';

export default function Layout({children}) {
    return (
        <>
            <Navbar/>
            <main style={{overflow: 'auto', height: '100%'}}>{children}</main>
        </>
    );
}