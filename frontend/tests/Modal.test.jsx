import Modal from '../src/app/components/Modal/Modal';
import { act, fireEvent, render, screen, waitFor } from '@testing-library/react';

describe('Modal', () => {
    const mockVerifyVotingCode = jest.fn();

    beforeEach(() => {
        jest.clearAllMocks();
    });

    it('renders correctly when showForm is true', async () => {
        render(
            <Modal
                showForm={true}
                setShowForm={() => {}}
                votingCode=""
                setVotingCode={() => {}}
                verifyVotingCode={mockVerifyVotingCode}
            />
        );

        expect(screen.getByText('Wpisz kod otrzymany w mailu')).toBeInTheDocument();
    });

    it('does not render when showForm is false', () => {
        render(
            <Modal
                showForm={false}
                setShowForm={() => {}}
                votingCode=""
                setVotingCode={() => {}}
                verifyVotingCode={mockVerifyVotingCode}
            />
        );

        expect(screen.queryByText('Wpisz kod otrzymany w mailu')).not.toBeInTheDocument();
    });

    it('updates input value correctly', async () => {
        render(
            <Modal
                showForm={true}
                setShowForm={() => {}}
                votingCode=""
                setVotingCode={() => {}}
                verifyVotingCode={mockVerifyVotingCode}
            />
        );

        const input = screen.getByPlaceholderText('Twój kod');
        fireEvent.change(input, { target: { value: '123456' } });

        expect(input.value).toBe('');
    });

    it('calls verifyVotingCode function when button is clicked', async () => {
        render(
            <Modal
                showForm={true}
                setShowForm={() => {}}
                votingCode="123456"
                setVotingCode={() => {}}
                verifyVotingCode={mockVerifyVotingCode}
            />
        );

        const verifyButton = screen.getByText('Zweryfikuj kod i oddaj głos');
        fireEvent.click(verifyButton);

        await waitFor(() => {
            expect(mockVerifyVotingCode).toHaveBeenCalledTimes(1);
        });
    });
});
