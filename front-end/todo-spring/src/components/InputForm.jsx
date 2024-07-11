import { Button } from './ui/button.jsx';
import { Input } from './ui/input.jsx';
import { Label } from './ui/label.jsx';
import { FaPencilAlt } from 'react-icons/fa';
import StatusPicker from './StatusPicker.jsx';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from './ui/card.jsx';
import { set } from 'date-fns';

const InputForm = () => {
  const [taskTitle, setTaskTitle] = useState('');
  const [taskDescription, setTaskDescription] = useState('');
  const [taskStatus, setTaskStatus] = useState('To-do');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const taskData = {
      title: taskTitle,
      description: taskDescription,
      status: taskStatus,
    };
    try {
      const response = await axios.post(
        'http://localhost:8080/api/task',
        taskData
      );
      console.log('Task created', response.data);
      setTaskTitle('');
      setTaskDescription('');
      setTaskStatus('to-do');
    } catch (error) {
      console.error('Error creating task', error);
    }
  };

  return (
    <>
      <Card className="w-[70%] mt-8">
        <CardHeader className="flex justify-between">
          <div className="p-1">
            <CardTitle className="pb-1">Add a new task</CardTitle>
            <CardDescription>Add tasks for today</CardDescription>
          </div>
          <div className="ml-2 ">
            <FaPencilAlt className="ml-2 top-5" />
          </div>
        </CardHeader>

        <CardContent>
          <form onSubmit={handleSubmit}>
            <div className="grid w-full items-center gap-5">
              <div className="flex flex-col space-y-2.5">
                <Label htmlFor="title">Title</Label>
                <Input
                  id="title"
                  placeholder="Add title"
                  value={taskTitle}
                  onChange={(e) => setTaskTitle(e.target.value)}
                />
              </div>
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="description">Description</Label>
                <Input
                  id="description"
                  placeholder="Optional"
                  value={taskDescription}
                  onChange={(e) => setTaskDescription(e.target.value)}
                />
              </div>
              <div className="flex flex-col space-y-1.5">
                <StatusPicker
                  value={taskStatus}
                  onChange={(value) => setTaskStatus(value)}
                />
              </div>
            </div>
          </form>
        </CardContent>
        <CardFooter className="flex justify-between">
          <Button
            variant="secondary"
            className="text-red-700 ml-2 border border-zinc-500 hover:text-red-400 "
            onClick={() => {
              setTaskTitle('');
              setTaskDescription('');
              setTaskStatus('To-do');
            }}
          >
            Cancel
          </Button>
          <Button onClick={handleSubmit} variant="default">
            Add
          </Button>
        </CardFooter>
      </Card>
    </>
  );
};

export default InputForm;
