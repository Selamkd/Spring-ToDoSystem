import "../styles/index.css";
import Header from "./Header";
import axios from "axios";
import LofiComponent from "@/components/LofiComponent";
import React, { useState, useEffect } from "react";

function App() {
  return (
    <div className="">
      <header>
        <Header />
      </header>

      <div className="bg-gray-200 h-[60%] ">
        <LofiComponent />
      </div>
    </div>
  );
}

export default App;
