import { useState } from 'react';
import '../styles/App.css';
import Header from './Header';
import InputForm from './InputForm';
import TaskList from './TasksList';
function App() {
  return (
    <div>
      <Header />
      <section className="flex flex-row">
        <InputForm />
        <TaskList />
      </section>
    </div>
  );
}

export default App;
