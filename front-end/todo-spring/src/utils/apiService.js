import axios from "axios";
export function fetchMusicTracks() {
  try {
    const response = axios.get("https://localhost:8000/api/tracks");

    if (!response.status !== 200) {
      throw new Error("Failed to fetch track links from the server");
    }
    return response.data;
  } catch (e) {
    console.error("Failed to fetch track links from the server" + e);
  }
}
