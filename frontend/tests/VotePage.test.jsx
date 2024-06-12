import {toast} from "react-hot-toast";
import '@testing-library/jest-dom';
import axios from 'lib/axios';
import {Provider} from "react-redux";
import Vote from "@/app/(with-navigation)/vote/page";
import {fireEvent, render} from "@testing-library/react";
import {store} from "@/store/store";
import {act} from "react-dom/test-utils";

jest.mock('lib/axios');
jest.mock('react-hot-toast', () => ({
    toast: {
        error: jest.fn(),
        success: jest.fn(),
    },
}));

describe('Vote', () => {
    afterEach(() => {
        jest.clearAllMocks();
    });

    it('renders Vote component and checks initial elements', () => {
        const {getByText} = render(
            <Provider store={store}>
                <Vote/>
            </Provider>
        );

        const heading = getByText(/Najbliższe wybory:/);
        expect(heading).toBeInTheDocument();
    });

    it('toggles the voting code form', () => {
        const { getByText, queryByPlaceholderText } = render(
            <Provider store={store}>
                <Vote />
            </Provider>
        );

        const voteButton = getByText('Zagłosuj');
        fireEvent.click(voteButton);

        const codeInput = queryByPlaceholderText('Twój kod');
        expect(codeInput).toBeInTheDocument();

        fireEvent.click(voteButton);
        expect(queryByPlaceholderText('Twój kod')).not.toBeInTheDocument();
    });

    it('shows an error when submitting an empty voting code', async () => {
        const { getByText, getByPlaceholderText } = render(
            <Provider store={store}>
                <Vote />
            </Provider>
        );

        const voteButton = getByText('Zagłosuj');
        fireEvent.click(voteButton);

        const submitButton = getByText('Wyślij');
        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(toast.error).toHaveBeenCalledWith('Błąd głosowania. Wymagane jest podanie kodu.');
    });

    it('submits a valid voting code and handles success', async () => {
        axios.post.mockResolvedValue({ data: 'newVotingToken' });

        const { getByText, getByPlaceholderText } = render(
            <Provider store={store}>
                <Vote />
            </Provider>
        );

        const voteButton = getByText('Zagłosuj');
        fireEvent.click(voteButton);

        const codeInput = getByPlaceholderText('Twój kod');
        fireEvent.change(codeInput, { target: { value: 'validCode' } });

        const submitButton = getByText('Wyślij');
        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(axios.post).toHaveBeenCalledWith(`vote/${store.getState().id.value}`, { code: 'validCode' }, expect.any(Object));
        expect(toast.success).toHaveBeenCalledWith('Głosowanie zostało zautoryzowane.');
    });

    it('submits a valid voting code and handles error', async () => {
        axios.post.mockRejectedValue(new Error('Authorization failed'));

        const { getByText, getByPlaceholderText } = render(
            <Provider store={store}>
                <Vote />
            </Provider>
        );

        const voteButton = getByText('Zagłosuj');
        fireEvent.click(voteButton);

        const codeInput = getByPlaceholderText('Twój kod');
        fireEvent.change(codeInput, { target: { value: 'validCode' } });

        const submitButton = getByText('Wyślij');
        await act(async () => {
            fireEvent.click(submitButton);
        });

        expect(axios.post).toHaveBeenCalledWith(`vote/${store.getState().id.value}`, { code: 'validCode' }, expect.any(Object));
        expect(toast.error).toHaveBeenCalledWith('Nie udało się zautoryzować głosowania.');
    });

    it('fetches and displays upcoming elections', async () => {
        axios.get.mockResolvedValue({
            data: [
                { startDate: '2024-12-25T00:00:00Z', election_name: 'Election 1' },
                { startDate: '2025-01-01T00:00:00Z', election_name: 'Election 2' },
            ],
        });

        const { getByText } = render(
            <Provider store={store}>
                <Vote />
            </Provider>
        );

        await act(async () => {
            // Let useEffect run
        });

        expect(getByText(/Najbliższe wybory: Election 1, Election 2/)).toBeInTheDocument();
    });
});