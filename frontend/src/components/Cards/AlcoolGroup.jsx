// import axios from "axios"

import axios from "axios";
import { useState } from "react";
import CardsAlcool from "./CardsAlcool";
import { useKeycloak } from "@react-keycloak/web";

export default function AlcoolGroup(props) {
  const config = axios.create({baseURL: "http://localhost:8080"})
  const alcool = props.data;
  const [isAdd, setIsAdd] = useState(false)
  const { keycloak, initialized } = useKeycloak();
  function handleSubmit(e) {
    
    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData)

    let form = {
      name: data.name,
      url:data.url,
      degrees: parseFloat(data.degrees)
    }

    config.post(props.type , form)
  }

  return( 
    <div className="max-w-5xl mx-auto mt-10">
      <div className="flex justify-between">
        <h2 className="font-bold text-blue-600 text-2xl">{props.name}</h2>
        {keycloak.hasRealmRole("admin") && (
        <>
        <p onClick={()=> setIsAdd(true)} className="ml-5 py-1 px-3 rounded-full bg-blue-400 block text-xl cursor-pointer">+</p>
        </>)
        }
      </div>
      <div className="flex gap-5 mt-5 ml-5 flex-wrap">
        {isAdd && 
          <form onSubmit={handleSubmit} className="flex flex-col gap-5 w-100 p-6 bg-blue-200 rounded-lg">
            <input name="name" type="text" placeholder="Name" className="p-1 rounded-lg"></input>
            <input name="url" type="url" placeholder="URL" className="p-1 rounded-lg"></input>
            <input name="degrees" type="text" placeholder="Degrees" className="p-1 rounded-lg"></input>
            <button type="submit" className="">Add</button>
          </form>
        }
        {alcool.map((alcool) =>(
          <CardsAlcool 
            key={alcool.id}
            type={props.type}
            id={alcool.id}
            name={alcool.name}
            url={alcool.url}
            degrees={alcool.degrees}
          />
        ))}
      </div>
    </div>
  );
}
