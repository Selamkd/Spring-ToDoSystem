import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DatePicker from '../components/DatePicker';
import { Checkbox } from '@/components/ui/checkbox';
import { Badge } from '@/components/ui/badge';
import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from '@/components/ui/accordion';
import {
  Card,
  CardHeader,
  CardTitle,
  CardDescription,
  CardContent,
  CardFooter,
} from '@/components/ui/card'; // Adjust import according to your setup

function TaskList() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/tasks')
      .then((response) => {
        console.log(response.data);
        setTasks(response.data);
      })
      .catch((error) => {
        console.error('Error fetching tasks', error);
      });
  }, []);

  return (
    <div className="w-full flex justify-center">
      <Card className="w-[80%] mt-7">
        <CardHeader>
          <div className="p-1 display flex justify-between">
            <div>
              <CardTitle className="pb-1">Hi there 👋🏾</CardTitle>
              <CardDescription>
                Here is a list of your tasks for this week!
              </CardDescription>
            </div>

            <DatePicker />
          </div>
        </CardHeader>
        <CardContent>
          <ul>
            {tasks.map((task, index) => {
              // Ensure createdAt is a Date object
              const createdAt = new Date(task.createdAt);
              const humanReadableDate = createdAt
                .toLocaleDateString()
                .replace(/\//g, '-');
              const humanReadableTime = createdAt.toLocaleTimeString();

              return (
                <Accordion type="single" collapsible key={index}>
                  <AccordionItem value={`item-${index}`}>
                    <AccordionTrigger className="flex justify-between gap-8">
                      <Checkbox />
                      <li>{task.title}</li>
                      <Badge className="text-gray-500" variant="outline">
                        {task.status}
                      </Badge>
                      <span className="text-gray-500">{humanReadableDate}</span>
                    </AccordionTrigger>
                    <AccordionContent>
                      <li className="flex justify-start ml-16">
                        {task.description}
                      </li>
                    </AccordionContent>
                  </AccordionItem>
                </Accordion>
              );
            })}
          </ul>
        </CardContent>
        <CardFooter className="flex justify-between"></CardFooter>
      </Card>
    </div>
  );
}

export default TaskList;
