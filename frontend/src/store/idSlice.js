import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  value: '',
};

export const idSlice = createSlice({
  name: 'id',
  initialState,
  reducers: {
    setID: (state, action) => {
      state.value = action.payload;
    },
    clearID: (state) => {
      state.value = '';
    },
  },
});

export const { setID, clearID } = idSlice.actions;

export default idSlice.reducer;
