import Navbar from '@/app/components/Navbar/Navbar';

export default function Layout({children}) {
    return (
        <>
            <Navbar/>
            <div style={{height: '100%' }}>{children}</div>
        </>
    );
}