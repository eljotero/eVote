import axios from 'axios';
import {toast} from "react-hot-toast";

export async function checkEmail(email) {
    try {
        const response = await axios.get(`https://disify.com/api/email/${email}`);
        if (response.data.format === true && response.data.disposable === false) {
            return true;
        } else {
            return false;
        }
    } catch (error) {
        toast.error('Wystąpił błąd związany z Disify API.');
    }
}
