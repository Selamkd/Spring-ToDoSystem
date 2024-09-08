import { RiHome6Fill } from "react-icons/ri";
import { PiListHeartFill } from "react-icons/pi";
import { RxColorWheel } from "react-icons/rx";
import { FaUserAstronaut } from "react-icons/fa";
function SideNav() {
  return (
    <nav className=" flex flex-col items-center w-1/5 h-screen white dark:bg-dark-card ">
      <h2 className="py-4 px-4 text-start w-full inter-reg tracking-wider  text-2xl"></h2>
      <p className="pt-4 pb-3 px-2 text-start w-full gruppo-regular text-gray-900 tracking-widest uppercase text-md dark:text-gray-300">
        Menu
      </p>
      <ul className="list-items text-start px-4 w-full gruppo-regular text-gray-900 tracking-wide text-md dark:text-gray-300">
        <li className="list-flex py-3 px-2 dark:hover:bg-white  dark:hover:text-gray-900 ">
          <RiHome6Fill /> Dashboard
        </li>
        <li className="list-flex py-3 px-2 dark:hover:bg-white  dark:hover:text-gray-900">
          <PiListHeartFill /> My Tasks
        </li>
        <li className="list-flex py-3 px-2 dark:hover:bg-white  dark:hover:text-gray-900">
          <RxColorWheel /> Wheel of tasks
        </li>
        <li className="list-flex py-3 px-2 dark:hover:bg-white  dark:hover:text-gray-900">
          <FaUserAstronaut /> Profile
        </li>
      </ul>
    </nav>
  );
}
export default SideNav;
