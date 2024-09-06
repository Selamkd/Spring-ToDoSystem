import "@/styles/App.css";
import "@/styles/index.css";
import UserAvatar from "@/components/UserAvatar";
import { useState, useEffect } from "react";
import { SiItunes } from "react-icons/si";
import { TbSunOff } from "react-icons/tb";
import { TbSunHigh } from "react-icons/tb";
import LofiComponent from "@/components/LofiComponent";

const Header = () => {
  const [theme, setTheme] = useState("light");
  const [openDialog, setOpenDialog] = useState(false);
  function handleThemeChange() {
    setTheme(theme === "light" ? "dark" : "light");
  }
  function handleOpenDialog() {
    setOpenDialog(!openDialog);
  }

  useEffect(() => {
    if (theme === "light") {
      document.documentElement.classList.remove("dark");
    } else {
      document.documentElement.classList.add("dark");
    }
  });

  return (
    <header className="w-screen z-10 border-2 border-gray-200 dark:border-dark-bg flex justify-between px-4 py-3 dark:bg-dark-bg">
      <img src="/optimization.png" className="w-14 h-14" alt="logo" />

      <div className="flex justify-center">
        <div className="flex mt-2 mr-12">
          {theme === "light" ? (
            <TbSunOff
              onClick={handleThemeChange}
              className="text-gray-800 text-5xl mr-8 hover:text-gray-600 dark:text-gray-200 bg-gray-100 rounded-3xl p-3"
            />
          ) : (
            <TbSunHigh
              onClick={handleThemeChange}
              className="text-gray-800 text-5xl mr-8 hover:text-gray-700 dark:text-gray-50  bg-gray-700 rounded-3xl p-3"
            />
          )}
          {theme === "light" ? (
            <SiItunes
              onClick={handleOpenDialog}
              className="text-gray-800 text-5xl ml-3  hover:text-gray-700 dark:text-gray-50 bg-gray-100 rounded-3xl p-3"
            />
          ) : (
            <SiItunes
              onClick={handleOpenDialog}
              className="text-gray-800 text-5xl ml-3  hover:text-gray-700 dark:text-gray-50 bg-gray-700 rounded-3xl p-3"
            />
          )}

          {openDialog ? (
            <div className="bg-gray-200 h-[60%] ">
              <LofiComponent />
            </div>
          ) : null}
        </div>
        <UserAvatar />
      </div>
    </header>
  );
};

export default Header;
