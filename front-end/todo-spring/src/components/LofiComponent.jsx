import axios from "axios";
import React, { useState, useEffect } from "react";

function LofiComponent() {
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/tasks")
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching tasks", error);
      });
  }, []);
  return (
    <div>
      <h1>lofiCompnent</h1>
    </div>
  );
}
export default LofiComponent;
