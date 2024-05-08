import Navbar from '@/app/components/Navbar/Navbar';

export default function Layout({children}) {
    return (
        <>
            <Navbar/>
            <main>{children}</main>
        </>
    );
}