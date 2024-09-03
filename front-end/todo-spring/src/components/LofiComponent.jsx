import { Slider } from "@/components/ui/slider";
import { Button } from "@/components/ui/button";
import { BsRewind } from "react-icons/bs";
import { IoPlayOutline } from "react-icons/io5";
import { IoPauseOutline } from "react-icons/io5";
import { BsFastForward } from "react-icons/bs";
import { useState, useRef } from "react";

import "@/styles/App.css";
import "@/styles/index.css";
function LofiComponent() {
  const [isPlaying, setIsPlaying] = useState(false);

  const audioRef = useRef(null);

  function handlePlayPause() {
    if (isPlaying) {
      audioRef.current.pause();
    } else {
      audioRef.current.play();
    }
    setIsPlaying(!isPlaying);
  }

  function handleSliderChange(value) {
    const newTime = (value / 100) * audioRef.current.buffered.end(0);
    audioRef.current.currentTime = newTime;
  }
  return (
    <div className="bg-white rounded-lg my-4 shadow-lg overflow-hidden w-full max-w-xs  dark:bg-dark-bg absolute right-9 top-20 ">
      <audio
        ref={audioRef}
        src="https://live.proradiosonline.com/listen/lofi_radio/aac"
      />
      <div className="flex justify-between">
        <span className="text-muted-foreground text-sm px-2 py-2 roboto dark:text-foreground-muted">
          Lofi beats to relax/study to
        </span>
        <span className="text-muted-foreground text-1xl px-2 py-2 roboto dark:text-foreground-muted">
          🌆
        </span>
      </div>
      <div className="p-1 flex items-center justify-between">
        <div className="flex items-center gap-2">
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
            onClick={() => (audioRef.current.currentTime -= 10)}
          >
            <BsRewind className="w-5 h-5" />
          </Button>
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
            onClick={handlePlayPause}
          >
            {isPlaying ? (
              <IoPauseOutline className="w-6 h-6" />
            ) : (
              <IoPlayOutline className="w-6 h-6" />
            )}
          </Button>
          <Button
            variant="ghost"
            size="icon"
            className="w-8 h-8 dark:text-gray-200"
            onClick={() => (audioRef.current.currentTime += 10)}
          >
            <BsFastForward className="w-6 h-6" />
          </Button>
        </div>
        <div className="flex items-center gap-2 w-full px-4">
          <Slider
            className="w-full"
            max={100}
            step={1}
            value={[80]}
            onValueChange={handleSliderChange}
          />
        </div>
        <div className="text-sm text-muted-foreground flex justify-start px-2">
          <span></span>
        </div>
      </div>
    </div>
  );
}
export default LofiComponent;
