import React, { useState } from 'react';
import { Calculator } from './components/Calculator/Calculator';

function App() {
  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-4">
      <Calculator />
    </div>
  );
}

export default App;