import CandidateForm from '@/app/components/CandidateForm/CandidateForm';
import { act, fireEvent, render, waitFor } from '@testing-library/react';

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
    election_id: '1',
  };

  global.fetch = jest.fn(() =>
    Promise.resolve({
      json: () =>
        Promise.resolve([{ political_party_id: '1', name: 'Test Party' }]),
    })
  );

  it('renders correctly', async () => {
    let getByText;
    await act(async () => {
      const result = render(<CandidateForm candidate={mockCandidate} />);
      getByText = result.getByText;
    });
    expect(getByText('Test Name Test Surname')).toBeInTheDocument();
  });

  it('shows political plan when button is clicked', async () => {
    const mockCandidateWithPlan = {
      ...mockCandidate,
      info: 'Political Plan',
    };
    let getByText;
    await act(async () => {
      const result = render(
        <CandidateForm candidate={mockCandidateWithPlan} />
      );
      getByText = result.getByText;
    });
    fireEvent.click(getByText('Pokaż plan polityczny'));
    await waitFor(() =>
      expect(getByText('Political Plan')).toBeInTheDocument()
    );
  });

  it('hides political plan when close button is clicked', async () => {
    const mockCandidateWithPlan = {
      ...mockCandidate,
      info: 'Political Plan',
    };
    const { getByText, queryByText } = render(
      <CandidateForm candidate={mockCandidateWithPlan} />
    );
    fireEvent.click(getByText('Pokaż plan polityczny'));
    await waitFor(() =>
      expect(getByText('Political Plan')).toBeInTheDocument()
    );
    fireEvent.click(getByText('Zamknij'));
    await waitFor(() =>
      expect(queryByText('Political Plan')).not.toBeInTheDocument()
    );
  });
});
