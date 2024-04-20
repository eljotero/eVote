import axios from 'axios';

export async function checkEmail(email) {
    try {
        const response = await axios.get(`https://disify.com/api/email/${email}`);

        if (response.data.format === true) {
            console.log('E-mail address is valid.');
            return true;
        } else {
            console.log('E-mail address is not valid.');
            return false;
        }
    } catch (error) {
        console.error('An error occured', error);
    }
}
