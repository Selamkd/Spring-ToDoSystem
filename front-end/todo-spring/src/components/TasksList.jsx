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
} from '@/components/ui/card';

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
      <Card className="w-[90%] mt-7">
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

              const formattedDate = createdAt
                .toLocaleDateString()
                .replace(/\//g, '-');

              return (
                <Accordion type="single" collapsible key={index}>
                  <AccordionItem value={`item-${index}`}>
                    <AccordionTrigger className="flex justify-between gap-8">
                      <li>
                        <Checkbox className="mr-3 mt-3" />
                        {task.title}
                      </li>
                      <Badge className="text-gray-500" variant="outline">
                        {task.status}
                      </Badge>
                      <span className="text-muted-foreground">
                        {formattedDate}
                      </span>
                    </AccordionTrigger>
                    <AccordionContent>
                      <li className="flex justify-start  text-muted-foreground">
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
