import Avatar, { genConfig } from "react-nice-avatar";
const config = genConfig();

function UserAvatar() {
  return (
    <div className="flex fle-col">
      <div className="flex flex-col">
        <Avatar style={{ width: "4rem", height: "4rem" }} {...config} />
      </div>
      <div className=" ml-2 justify-center flex flex-col">
        <p className="text-gray-600 dark:text-gray-200 text-sm">Selam A.</p>
        <p className="text-gray-600 dark:text-gray-200 text-sm">Developer</p>
      </div>
    </div>
  );
}

export default UserAvatar;
