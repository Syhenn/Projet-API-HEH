import { useEffect, useState } from "react";
import axios from "axios";
import AlcoolGroup from "../../components/Cards/AlcoolGroup";
import Footer from "../../components/Footer/Footer";
import Navbar from "../../components/Nav/Navbar";

export default function Alcool() {
  const [dataBeer, setDataBeer] = useState([]);
  const [dataWine, setDataWine] = useState([]);

  useEffect(() => {
    document.title = "Alcools";
    const config = axios.create({ baseURL: "http://localhost:8080" });

    config.get("/beer").then((result) => {
      setDataBeer(result.data);
    });

    config.get("/wine").then((result) => {
      setDataWine(result.data);
    });
  }, []);

  return (
    <div>
      <Navbar />
      {dataBeer && <AlcoolGroup type="beer" name="Bières" data={dataBeer} />}
      {dataWine && <AlcoolGroup type="wine" name="Vins" data={dataWine} />}
      <Footer />
    </div>
  );
}
