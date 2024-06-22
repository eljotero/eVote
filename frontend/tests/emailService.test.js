import { checkEmail } from "@/app/services/emailService";
import '@testing-library/jest-dom';
import axios from "../lib/axios";
import {toast} from "react-hot-toast";

jest.mock('lib/axios');
jest.mock('react-hot-toast', () => ({
    toast: {
        error: jest.fn(),
    },
}));

describe('checkEmail', () => {
    afterEach(() => {
        jest.clearAllMocks();
    });


    it('returns true for a valid email', async () => {
        axios.get.mockResolvedValue({ data: { format: true, disposable: false } });

        const email = 'mikafikapika@gmail.com';
        const result = await checkEmail(email);
        expect(result).toBe(true);
    });

    it('returns false for an invalid email', async () => {
        // Mock axios.get implementation for an invalid email
        axios.get.mockRejectedValue(new Error('Invalid email'));

        const email = 'plainaddress';
        const result = await checkEmail(email);
        expect(result).toBe(false);
    });

    it('returns false for a disposable email', async () => {
        axios.get.mockResolvedValue({ data: { format: true, disposable: true } });

        const email = 'gkwqisekcbrsuctggi@cazlq.com';
        const result = await checkEmail(email);
        expect(result).toBe(false);
    });
});