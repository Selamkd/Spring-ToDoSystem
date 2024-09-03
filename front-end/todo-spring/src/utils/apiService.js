import axios from "axios";
export async function fetchMusicTracks() {
  try {
    const response = await axios.get("http://localhost:8080/api/tracks");
    if (response.status !== 200) {
      throw new Error("Failed to fetch track links from the server");
    }
    return response.data;
  } catch (e) {
    console.error("Failed to fetch track links from the server" + e);
  }
}
