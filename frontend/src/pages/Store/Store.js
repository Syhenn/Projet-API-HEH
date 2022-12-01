import axios from "axios";
import { useEffect, useState } from "react";
import StoreGroup from "../../components/Cards/StoreGroup";
import Footer from "../../components/Footer/Footer";
import Navbar from "../../components/Nav/Navbar";

export default function Store() {
  const [dataStore, setDataStore] = useState([]);

  useEffect(() => {
    document.title = "Magasins";

    const config = axios.create({ baseURL: "http://localhost:8080" });

    config.get("/store").then((result) => {
      setDataStore(result.data);
    });
  }, []);

  return (
    <div>
      <Navbar />
      {dataStore && <StoreGroup name="Magasins" data={dataStore} />}
      <Footer />
    </div>
  );
}
