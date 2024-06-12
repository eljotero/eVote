import { configureStore } from '@reduxjs/toolkit';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
import tokenReducer from './tokenSlice';
import idReducer from './idSlice';

const persistConfig = {
  key: 'root',
  storage,
};

const persistedTokenReducer = persistReducer(persistConfig, tokenReducer);
const persistedIdReducer = persistReducer(persistConfig, idReducer);

export const store = configureStore({
  reducer: {
    token: persistedTokenReducer,
    id: persistedIdReducer,
  },
});

export const RootState = store.getState;
export const AppDispatch = store.dispatch;
