
import axios from 'axios';

const baseUrl = '/api/candidates';

export const getAllCandidates = async () => {
    try {
        const response = await axios.get(baseUrl);
        return response.data;
    } catch (error) {
        console.error('Error fetching candidates:', error);
        return [];
    }
};

