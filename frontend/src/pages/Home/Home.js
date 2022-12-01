import { useEffect, useState } from "react";
import axios from "axios";
import AlcoolGroup from "../../components/Cards/AlcoolGroup";
import CardsStore from "../../components/Cards/CardsStore";
import Footer from "../../components/Footer/Footer";
import More from "../../components/Home/More";
import Navbar from "../../components/Nav/Navbar";

export default function Home() {
  const [dataBeer, setDataBeer] = useState([]);
  const [dataWine, setDataWine] = useState([]);
  const [dataStore, setDataStore] = useState([]);

  useEffect(() => {
    document.title = "Home";

    const config = axios.create({ baseURL: "http://localhost:8080" });

    config.get("/beer?limit=2").then((result) => {
      setDataBeer(result.data);
    });

    config.get("/wine?limit=2").then((result) => {
      setDataWine(result.data);
    });

    config.get("/store?limit=2").then((result) => {
      setDataStore(result.data);
    });
  }, []);

  return (
    <div>
      <Navbar />
      <header className="text-center my-10">
        <h1 className="text-xl font-semibold">
          L'alcool, c'est pas <span className="text-blue-600">COOL </span>?
          <p className="text-4xl font-bold">
            {" "}
            Alors pourquoi il y a le mot
            <span className="text-blue-600"> "COOL"</span> dans AL
            <span className="text-blue-600">COOL</span> ?
          </p>
        </h1>
      </header>
      <main className="max-w-4xl mx-auto">
        <div className="p-2  bg-red-500 text-white text-lg uppercase font-bold rounded-lg">
          attention l'abus d'alcool est dangereux pour la santé !
        </div>

        <div className="mt-10">
          <h3 className="text-blue-600 font-bold text-xl">
            Découvrez nos alcools
          </h3>
          <div className="flex flex-col items-center gap-5">
            <div className="flex justify-between w-full">
              {dataBeer && <AlcoolGroup name="Bières" data={dataBeer} />}
              {dataWine && <AlcoolGroup name="Vins" data={dataWine} />}
            </div>
            <More to="/alcool" />
          </div>
        </div>

        <div className="mt-10">
          <h3 className="text-blue-600 font-bold text-xl">
            Découvrez nos magasins
          </h3>
          <div className="flex gap-5 mt-5 flex-wrap flex-col items-center">
            {dataStore &&
              dataStore.map((store) => (
                <CardsStore
                  key={store.id}
                  id={store.id}
                  name={store.name}
                  adresse={store.address}
                />
              ))}
            <More to="/store" />
          </div>
        </div>
      </main>
      <Footer />
    </div>
  );
}
