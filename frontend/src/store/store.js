import { configureStore } from '@reduxjs/toolkit';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
import tokenReducer from './tokenSlice';
import votingTokenReducer from './votingTokenSlice';
import idReducer from './idSlice';

const tokenPersistConfig = {
  key: 'token',
  storage,
};

const idPersistConfig = {
  key: 'id',
  storage,
};

const votingTokenPersistConfig = {
  key: 'votingToken',
  storage,
};

const persistedTokenReducer = persistReducer(tokenPersistConfig, tokenReducer);
const persistedIdReducer = persistReducer(idPersistConfig, idReducer);
const persistedVotingTokenReducer = persistReducer(votingTokenPersistConfig, votingTokenReducer);

export const store = configureStore({
  reducer: {
    token: persistedTokenReducer,
    id: persistedIdReducer,
    votingToken: persistedVotingTokenReducer,
  },
});

export const RootState = store.getState;
export const AppDispatch = store.dispatch;