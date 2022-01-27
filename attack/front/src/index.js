import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import TopHeader from './TopHeader';

ReactDOM.render(
  <React.StrictMode>
    <TopHeader />
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
