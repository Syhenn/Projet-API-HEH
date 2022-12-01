import axios from "axios";
import { useState } from "react";
import CardsStore from "./CardsStore";


export default function StoreGroup(props) {
  const config = axios.create({baseURL : "http://localhost:8080"})
  const store = props.data;
  const [isAdd, setIsAdd] = useState(false);

  function handleSubmit(e) {

    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData)

    const form = {
      name: data.name,
      address: data.address
    }
      

    config.post("/store", form)
  }

  return( 
    <div className="max-w-5xl mx-auto mt-10">
      <div className="flex justify-between">
        <h2 className="font-bold text-blue-600 text-2xl">{props.name}</h2>
        <p onClick={()=> setIsAdd(true)} className="ml-5 py-1 px-3 rounded-full bg-blue-400 block text-xl cursor-pointer">+</p>
      </div>
      <div className="flex flex-col gap-5 mt-5 ml-5 flex-wrap">
        {isAdd && 
          <form onSubmit={handleSubmit} className="flex flex-col gap-5 w-100 p-6 bg-blue-200 rounded-lg">
            <input name="name"type="text" placeholder="Name" className="p-1 rounded-lg"></input>
            <input name="address" type="text" placeholder="Addresse" className="p-1 rounded-lg"></input>
            <button type="submit" className="">Add</button>
          </form>
        }
        {store.map((store) => (
          <CardsStore
            key={store.id}
            id={store.id}
            name={store.name}
            adresse={store.address}
          />
        ))}
      </div>
    </div>
  );
}
