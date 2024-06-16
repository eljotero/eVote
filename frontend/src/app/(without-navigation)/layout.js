
export default function Layout({children}) {
    return (
        <>
            <main style={{overflow: 'auto', height: '100%'}}>{children}</main>
        </>
    );
}