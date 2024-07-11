import '../styles/index.css';
import Header from './Header';
import InputForm from './InputForm';
import TaskList from './TasksList';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { ThemeProvider } from './theme-provider.jsx';
import { columns } from '../components/columns.jsx';
import DataTable from '../components/data-table.jsx';
function TestCss() {
  return (
    <div className="flex flex-col h-screen">
      <section>
        <h1>Hello</h1>
      </section>

      <section className="grid grid-cols-2 py-10 ml-5">
        <div className="flex flex-col p-4 justify-start items-start">
          <h2>Hello</h2>
        </div>
        <div className="flex flex-col items-end p-4  ">
          <h3>Hello</h3>
        </div>
      </section>
    </div>
  );
}

export default TestCss;
