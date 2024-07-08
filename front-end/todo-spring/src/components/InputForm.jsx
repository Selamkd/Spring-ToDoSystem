import React from 'react';
import '../styles/App.css';
const InputForm = () => {
  return (
    <section className="ml-3">
      <p>Add a new task</p>
      <form className="flex flex-col">
        <label>
          {' '}
          Task title :
          <input />
        </label>
        <label>
          {' '}
          Task description :
          <input />
        </label>
        <label>
          {' '}
          Task status :
          <select />
        </label>
      </form>
    </section>
  );
};

export default InputForm;
