import { RiHome6Fill } from "react-icons/ri";
import { PiListHeartFill } from "react-icons/pi";
import { RxColorWheel } from "react-icons/rx";
import { FaUserAstronaut } from "react-icons/fa";
function SideNav() {
  return (
    <nav className=" flex flex-col items-center w-1/5 h-screen white">
      <h2 className="py-4 px-4 text-start w-full inter-reg tracking-wider  text-2xl"></h2>
      <p className="pt-4 pb-3 px-2 text-start w-full hanken-thin text-gray-700 tracking-widest uppercase text-sm">
        Menu
      </p>
      <ul className="list-items text-start px-4 w-full hanken-thin text-gray-700 tracking-wide  text-md ">
        <li className="list-flex py-3 px-2">
          <RiHome6Fill /> Dashboard
        </li>
        <li className="list-flex py-3 px-2">
          <PiListHeartFill /> My Tasks
        </li>
        <li className="list-flex py-3 px-2">
          <RxColorWheel /> Wheel of tasks
        </li>
        <li className="list-flex py-3 px-2">
          <FaUserAstronaut /> Profile
        </li>
      </ul>
    </nav>
  );
}
export default SideNav;
