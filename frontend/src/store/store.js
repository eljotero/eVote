import { configureStore } from '@reduxjs/toolkit';
import tokenReducer from './tokenSlice';

export const store = configureStore({
  reducer: {
    token: tokenReducer,
  },
});

export const RootState = store.getState;
export const AppDispatch = store.dispatch;
