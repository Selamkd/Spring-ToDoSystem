import { Slider } from "@/components/ui/slider";
import { Button } from "@/components/ui/button";
import { BsRewind } from "react-icons/bs";
import { IoPlayOutline } from "react-icons/io5";
import { BsFastForward } from "react-icons/bs";
import "@/styles/App.css";
import "@/styles/index.css";
function LofiComponent() {
  return (
    <div className="bg-white rounded-lg my-3 mx-4 shadow-lg overflow-hidden w-full max-w-sm dark:bg-dark-bg top-[10%] right-[10%] absolute">
      <div className="flex justify-between">
        <span className="text-muted-foreground text-sm px-2 py-2 roboto dark:text-foreground-muted">
          Lofi beats for study
        </span>
        <span className="text-muted-foreground text-sm px-2 py-2 roboto dark:text-foreground-muted">
          Meow Bands
        </span>
      </div>
      <div className="p-1 flex items-center justify-between">
        <div className="flex items-center gap-2">
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
          >
            <BsRewind className="w-5 h-5" />
          </Button>
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
          >
            <IoPlayOutline className="w-6 h-6" />
          </Button>
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
          >
            <BsFastForward className="w-6 h-6" />
          </Button>
        </div>
        <div className="flex items-center gap-2 w-full px-4">
          <Slider className="w-full " defaultValue={[33]} max={100} step={1} />
        </div>
        <div className="text-sm text-muted-foreground flex justify-start px-2">
          <span> 1:23 4:56</span>
        </div>
      </div>
    </div>
  );
}
export default LofiComponent;
