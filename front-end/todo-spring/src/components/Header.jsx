import "@/styles/App.css";
import UserAvatar from "@/components/UserAvatar";
import { useState, useEffect } from "react";
import { BsMusicNoteList } from "react-icons/bs";
import { TbSunOff } from "react-icons/tb";
import { TbSunHigh } from "react-icons/tb";
import LofiComponent from "@/components/LofiComponent";
const Header = () => {
  const [theme, setTheme] = useState("light");
  const [openDialog, setOpenDialog] = useState(false);
  function handleThemeChange() {
    setTheme(theme == "light" ? "dark" : "light");
  }
  function handleOpenDialog() {
    setOpenDialog(!openDialog);
  }

  useEffect(() => {
    if (theme == "light") {
      document.documentElement.classList.remove("dark");
    } else {
      document.documentElement.classList.add("dark");
    }
  });

  return (
    <header className="w-screen bg-gray-100 z-10 border-2 border-gray-200 dark:border-dark-bg flex justify-between px-4 py-3 dark:bg-dark-bg">
      <img src="../public/optimization.png" className="w-14 h-14" />

      <div className="flex justify-center">
        <div className="flex mt-5 mr-12">
          {theme == "light" ? (
            <TbSunOff
              onClick={handleThemeChange}
              className="text-gray-800 text-3xl mr-8 hover:text-gray-600 dark:text-gray-200"
            />
          ) : (
            <TbSunHigh
              onClick={handleThemeChange}
              className="text-gray-800 text-3xl mr-8 hover:text-gray-600 dark:text-gray-50"
            />
          )}

          <BsMusicNoteList
            onclick={handleOpenDialog}
            className="text-gray-800 text-2xl ml-5 mt-1 hover:text-gray-600 dark:text-gray-50"
          />
        </div>
        <UserAvatar />
      </div>
    </header>
  );
};

export default Header;
