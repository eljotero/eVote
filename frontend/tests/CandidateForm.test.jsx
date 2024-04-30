import React from 'react';
import { render, fireEvent, waitFor } from '@testing-library/react';
import CandidateForm from '@/app/components/CandidateForm/CandidateForm';

describe('CandidateForm', () => {
    const mockCandidate = {
        candidate_id: '123',
        name: 'Test Name',
        surname: 'Test Surname',
        birthDate: new Date(),
        education: 'Test Education',
        profession: 'Test Profession',
        political_party_id: '1',
       // image: 'test.jpg',
        precinct_id: '1',
        election_id: '1'
    };

    global.fetch = jest.fn(() =>
        Promise.resolve({
            json: () => Promise.resolve([{ political_party_id: '1', name: 'Test Party' }]),
        })
    );

    it('renders correctly', () => {
        const { getByText } = render(<CandidateForm candidate={mockCandidate} />);
        expect(getByText('Test Name Test Surname')).toBeInTheDocument();
    });

    it('shows political plan when button is clicked', async () => {
        const mockCandidateWithPlan = {
            ...mockCandidate,
            info: 'Political Plan',
        };
        const { getByText } = render(<CandidateForm candidate={mockCandidateWithPlan} />);
        fireEvent.click(getByText('Pokaz plan polityczny'));
        await waitFor(() => expect(getByText('Political Plan')).toBeInTheDocument());
    });

    it('hides political plan when close button is clicked', async () => {
        const mockCandidateWithPlan = {
            ...mockCandidate,
            info: 'Political Plan',
        };
        const { getByText, queryByText } = render(<CandidateForm candidate={mockCandidateWithPlan} />);
        fireEvent.click(getByText('Pokaz plan polityczny'));
        await waitFor(() => expect(getByText('Political Plan')).toBeInTheDocument());
        fireEvent.click(getByText('Zamknij'));
        await waitFor(() => expect(queryByText('Political Plan')).not.toBeInTheDocument());
    });
});