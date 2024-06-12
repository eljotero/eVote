import { configureStore } from '@reduxjs/toolkit';
import tokenReducer from './tokenSlice';
import votingTokenReducer from './votingTokenSlice';
import idReducer from './idSlice';

export const store = configureStore({
  reducer: {
    token: tokenReducer,
    votingToken: votingTokenReducer,
    id: idReducer,
  },
});

export const RootState = store.getState;
export const AppDispatch = store.dispatch;
