import '../styles/index.css';
import Header from './Header';
import InputForm from './InputForm';
import TaskList from './TasksList';
import axios from 'axios';
import React, { useState, useEffect } from 'react';

function App() {
  return (
    <div className="flex flex-col h-screen">
      <section>
        <Header />
      </section>

      <section className="grid grid-cols-2 py-10 ml-5 h-screen">
        <div className="flex flex-col p-4 justify-start items-start pr-6 mr-5">
          <TaskList />
        </div>
        <div className="flex flex-col justify-start items-center p-4 mt-2">
          <InputForm />
        </div>
      </section>
    </div>
  );
}

export default App;
