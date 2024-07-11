import React from 'react';
import ReactDOM from 'react-dom/client';

import TestCss from './components/TestCss.jsx';
import '../src/styles/index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <TestCss />
  </React.StrictMode>
);
