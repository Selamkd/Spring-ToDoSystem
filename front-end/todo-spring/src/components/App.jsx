import "../styles/index.css";
import Header from "./Header";
import axios from "axios";
import LofiComponent from "@/components/LofiComponent";
import React, { useState, useEffect } from "react";
import SideNav from "@/components/SideNav.jsx";
function App() {
  return (
    <div className="overflow-hidden">
      <header>
        <Header />
      </header>
        <SideNav/>
    </div>
  );
}

export default App;
