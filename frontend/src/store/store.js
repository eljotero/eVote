import { configureStore } from '@reduxjs/toolkit';
import tokenReducer from './tokenSlice';
import idReducer from './idSlice';

export const store = configureStore({
  reducer: {
    token: tokenReducer,
    id: idReducer,
  },
});

export const RootState = store.getState;
export const AppDispatch = store.dispatch;
