import Account
    from '../src/app/(with-navigation)/account/page';
import {Provider} from "react-redux";
import {store} from "@/store/store";
import {
    fireEvent,
    getByLabelText,
    render
} from '@testing-library/react';
import axios from '../lib/axios';
import {toast} from "react-hot-toast";
import {act} from "react-dom/test-utils";

const renderAccount = () => render(
    <Provider store={store}>
        <Account/>
    </Provider>
);

const testData = {
    name: 'Jan',
    surname: 'Kowalski',
    sex: "false",
    birthDate: '1990-01-01',
    education: 'PRIMARY',
    profession: 'Informatyk',
    personalIdNumber: '90010100000',
    zip_code: '90105',
    address_line: 'ul. Testowa 1',
    city: 'Warszawa',
    cityType: 'OVER500THOUSAND',
    country: 'Poland',
    voivodeship: 'Mazowieckie'
};

const inputLabels = [
    'Email', 'Imię*', 'Nazwisko*', 'Płeć*', 'Data urodzenia*',
    'Wykształcenie*', 'Zawód*', 'Numer PESEL*', 'Kod pocztowy*',
    'Adres*', 'Miasto*', 'Typ miejscowości*', 'Kraj*', 'Województwo*'
];

const testDataArray = [
    {label: 'Imię*', value: testData.name},
    {label: 'Nazwisko*', value: testData.surname},
    {label: 'Płeć*', value: testData.sex},
    {
        label: 'Data urodzenia*',
        value: testData.birthDate
    },
    {
        label: 'Wykształcenie*',
        value: testData.education
    },
    {label: 'Zawód*', value: testData.profession},
    {
        label: 'Numer PESEL*',
        value: testData.personalIdNumber
    },
    {label: 'Kod pocztowy*', value: testData.zip_code},
    {label: 'Adres*', value: testData.address_line},
    {label: 'Miasto*', value: testData.city},
    {
        label: 'Typ miejscowości*',
        value: testData.cityType
    },
    {label: 'Kraj*', value: testData.country},
    {
        label: 'Województwo*',
        value: testData.voivodeship
    }
];

const refine = jest.fn();
const zod = {
    string: jest.fn().mockReturnThis(),
    date: jest.fn().mockReturnThis(),
    refine
}

refine.mockImplementation((data) => {
    const today = new Date();
    const birthDate = new Date(data.birthDate);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age >= 18;
});

jest.mock('lib/axios');

jest.mock('react-hot-toast', () => ({
    toast: {
        success: jest.fn(),
        error: jest.fn(),
    },
}));


describe('Account', () => {
    it('checks if fetching data works properly', () => {
        axios.get.mockResolvedValue({data: testData});
        const {getByText} = renderAccount();
        const saveButton = getByText('Zapisz');
        fireEvent.click(saveButton);
        expect(axios.get).toHaveBeenCalledTimes(1);
    });
    it('renders Account and checks if input fields and button are present', () => {
        const {getByLabelText, getByText} = renderAccount();
        inputLabels.forEach(label => {
            expect(getByLabelText(label)).toBeInTheDocument();
        });
        expect(getByText('Wygeneruj kod do głosowania')).toBeInTheDocument();
        expect(getByText('Zapisz')).toBeInTheDocument();
    });
    it('checks if input fields are working correctly', () => {
        const {getByLabelText} = renderAccount();
        testDataArray.forEach(({label, value}) => {
            const input = getByLabelText(label);
            fireEvent.change(input, {target: {value}});
            expect(input.value).toBe(value);
        });
    });
    it('checks if date validation works properly', () => {
        const today = new Date();
        const eighteenYearsAgo = new Date(today.getFullYear() - 19, today.getMonth(), today.getDate());
        const seventeenYearsAgo = new Date(today.getFullYear() - 17, today.getMonth(), today.getDate());
        const validData = {birthDate: eighteenYearsAgo.toISOString().split('T')[0]};
        const invalidData = {birthDate: seventeenYearsAgo.toISOString().split('T')[0]};

        expect(zod.date().refine(validData)).toBe(true);
        expect(zod.date().refine(invalidData)).toBe(false);
    });
    it('shows toast success if email is sent', async () => {
        axios.post.mockResolvedValue({status: 200});
        const {getByLabelText, getByText} = renderAccount();
        await act(async () => {
            fireEvent.click(getByText('Wygeneruj kod do głosowania'));
        });
        expect(toast.success).toHaveBeenCalledWith('Email wysłany pomyślnie!');
    });
    it('shows toast error if email is not sent', async () => {
        axios.post.mockRejectedValue({
            response: {
                status: 400
            }
        });
        const {getByLabelText, getByText} = renderAccount();
        await act(async () => {
            fireEvent.click(getByText('Wygeneruj kod do głosowania'));
        });
        expect(toast.error).toHaveBeenCalledWith('Email został już wysłany. Sprawdź swoją skrzynkę odbiorczą.');
    });


    it('shows toast error if backend returns 500', async () => {
        axios.post.mockRejectedValue({
            response: {
                status: 500
            }
        });
        const {getByLabelText, getByText} = renderAccount();
        await act(async () => {
            fireEvent.click(getByText('Wygeneruj kod do głosowania'));
        });
        expect(toast.error).toHaveBeenCalledWith('Błąd wysyłania emaila. Spróbuj ponownie.');
    });
});