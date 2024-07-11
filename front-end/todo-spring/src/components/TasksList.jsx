import React, { useState, useEffect } from 'react';
import axios from 'axios';
// import { Button } from './ui/button.jsx';
// import { DatePickerWithRange } from './CalendarComponent.jsx';
function TaskList() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/tasks')
      .then((response) => {
        setTasks(response.data);
      })
      .catch((error) => {
        console.error('Error fetching tasks', error);
      });
  }, []);

  return (
    <div className="flex flex-col ">
      <section>
        <DatePickerWithRange />
      </section>

      <ul>
        {tasks.map((task, index) => (
          <>
            <li key={index}>{task.title}</li>
            <li key={index++}>{task.status}</li>
          </>
        ))}
      </ul>
    </div>
  );
}

export default TaskList;
