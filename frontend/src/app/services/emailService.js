import axios from 'axios';

export async function checkEmail(email) {
    try {
        const response = await axios.get(`https://disify.com/api/email/${email}`);
        // Checking if email has valid format and is not disposable
        if (response.data.format === true && response.data.disposable === false) {
            return true;
        } else {
            return false;
        }
    } catch (error) {
        console.error('An error with Disify API occurred', error);
    }
}
