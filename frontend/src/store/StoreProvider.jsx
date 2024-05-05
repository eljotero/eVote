'use client';

import { Provider } from 'react-redux';
import { persistStore } from 'redux-persist';
import { store } from './store';

persistStore(store);
export default function ReduxProvider({ children }) {
  return <Provider store={store}>{children}</Provider>;
}
