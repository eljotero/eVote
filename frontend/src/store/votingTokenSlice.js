// votingTokenSlice.js
import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    value: '',
};

export const votingTokenSlice = createSlice({
    name: 'votingToken',
    initialState,
    reducers: {
        setVotingToken: (state, action) => {
            state.value = action.payload;
        },
        clearVotingToken: (state) => {
            state.value = '';
        },
    },
});

export const { setVotingToken, clearVotingToken } = votingTokenSlice.actions;

export default votingTokenSlice.reducer;