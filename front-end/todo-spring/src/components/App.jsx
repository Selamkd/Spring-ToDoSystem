import { useState } from 'react';
import '../styles/App.css';
import Header from './Header';
import InputForm from './InputForm';
import TaskList from './TasksList';
function App() {
  return (
    <>
      <Header />
      <section className="grid grid-cols-2 py-10">
        <div className="flex flex-col p-4">
          <InputForm />
        </div>
        <div className="flex flex-col items-end p-4">
          <TaskList />
        </div>
      </section>
    </>
  );
}

export default App;
