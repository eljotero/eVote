/** @type {import('next').NextConfig} */
const nextConfig = {
    images: {
        domains: ['storage.googleapis.com', 'firebasestorage.googleapis.com'],
    },
    reactStrictMode: false,
};

export default nextConfig;
