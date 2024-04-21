import { checkEmail } from "@/app/services/emailService";
import '@testing-library/jest-dom';

describe('checkEmail', () => {
    it('returns true for a valid email', async () => {
        const email = 'mikafikapika@gmail.com';

        const result = await checkEmail(email);

        expect(result).toBe(true);
    });

    it('returns false for an invalid email', async () => {
        const email = 'plainaddress';

        const result = await checkEmail(email);

        expect(result).toBe(false);
    });
});