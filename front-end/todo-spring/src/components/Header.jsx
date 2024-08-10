import "@/styles/App.css";
import UserAvatar from "@/components/UserAvatar";
import { useState, useEffect } from "react";
import { LuSunMoon } from "react-icons/lu";
import { BsMusicNoteList } from "react-icons/bs";
import { TbSunOff } from "react-icons/tb";
import { TbSunHigh } from "react-icons/tb";
const Header = () => {
  const [theme, setTheme] = useState("light");
  function handleThemeChange() {
    setTheme(theme == "light" ? "dark" : "light");
  }

  useEffect(() => {
    if (theme == "light") {
      document.documentElement.classList.add("dark");
    } else {
      document.documentElement.classList.remove("dark");
    }
  });

  return (
    <header className="w-screen bg-gray-100 z-10 fixed drop-shadow-lg flex justify-between px-4 py-3 dark:bg-dark-bg">
      <img src="../public/optimization.png" className="w-14 h-14" />
      <div className="flex justify-center">
        <div className="flex mt-5 mr-12">
          {theme == "light" ? (
            <TbSunHigh
              onClick={handleThemeChange}
              className="text-yellow-500 text-3xl mr-8 hover:text-yellow-400 dark:text-gray-200"
            />
          ) : (
            <TbSunOff
              onClick={handleThemeChange}
              className="text-gray-800 text-3xl mr-8 hover:text-gray-600 dark:text-gray-50"
            />
          )}

          <BsMusicNoteList className="text-gray-800 text-2xl ml-5 mt-1 hover:text-gray-600 dark:text-gray-50" />
        </div>
        <UserAvatar />
      </div>
    </header>
  );
};

export default Header;
