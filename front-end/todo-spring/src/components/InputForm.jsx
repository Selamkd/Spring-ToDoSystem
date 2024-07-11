import { Button } from './ui/button.jsx';
import { Input } from './ui/input.jsx';
import { Label } from './ui/label.jsx';
import { FaPencilAlt } from 'react-icons/fa';
import StatusPicker from './StatusPicker.jsx';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from './ui/card.jsx';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from './ui/select.jsx';

const InputForm = () => {
  return (
    <>
      <Card className="w-[80%] mt-7">
        <CardHeader>
          <div className="p-1">
            <CardTitle className="pb-1">Add a new task</CardTitle>
            <CardDescription>Add tasks for today</CardDescription>
          </div>
          <div className="ml-2">
            <FaPencilAlt className="ml-2 top-5" />
          </div>
        </CardHeader>

        <CardContent>
          <form>
            <div className="grid w-full items-center gap-5">
              <div className="flex flex-col space-y-2.5">
                <Label htmlFor="name">Title</Label>
                <Input id="name" placeholder="Add title" />
              </div>
              <div className="flex flex-col space-y-1.5">
                <Label htmlFor="name">Description</Label>
                <Input id="name" placeholder="Optional" />
              </div>
              <div className="flex flex-col space-y-1.5">
                <StatusPicker />
              </div>
            </div>
          </form>
        </CardContent>
        <CardFooter className="flex justify-between">
          <button className="text-red-700 ml-2 hover:text-red-400 ">
            Cancel
          </button>
          <Button variant="secondary">Add</Button>
        </CardFooter>
      </Card>
    </>
  );
};

export default InputForm;
