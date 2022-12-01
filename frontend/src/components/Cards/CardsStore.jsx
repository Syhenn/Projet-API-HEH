import axios from "axios";
import { useState } from "react";
import { useKeycloak } from "@react-keycloak/web";

export default function CardsStore(props) {
  const { keycloak, initialized } = useKeycloak();
  const config = axios.create({baseURL : "http://localhost:8080"})
  config.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
  config.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
  const [isModify, setIsModify] = useState(false)

  function supp(e) {
    const id = e.target.id
    config.delete(`/store/${id}`).then(()=> {
      window.location.reload();
    })
    
  }

  function validate(e) {
    const id = e.target.id

    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData)

    const form = {
      name: data.name,
      address: data.address
    }


    config.put(`/store/${id}`, form).then((sucess)=> {
      setIsModify(false)
    }).catch((err)=>console.log(err))
  }

  return( 
    <>
    {!isModify ?
    <div className="w-full rounded overflow-hidden shadow-lg flex justify-between items-center bg-white">
      <div className="px-6 py-4 bg-white">
        <div className="font-bold text-xl mb-2">{props.name}</div>
        <p className="text-gray-700 text-base">
          {props.adresse}
        </p>
      </div>
      <div>
      {keycloak.hasRealmRole("admin") && (
        <>
        <p onClick={supp} id={props.id} className="rounded-full px-3 text-white cursor-pointer py-1 m-4 bg-red-500 ">-</p>
        <p onClick={()=> setIsModify(true)} id={props.id} className="rounded-full px-3 text-white cursor-pointer py-1 m-4 bg-orange-500 ">x</p>
        </>)
      }
      </div>
    </div>
    : 
    <div className="w-full rounded overflow-hidden shadow-lg flex justify-between items-center bg-white">
      <div className="px-6 py-4 bg-white w-full">
        <form onSubmit={validate} className="flex flex-col" id={props.id}>
          <input name="name" type="text" defaultValue={props.name} className="font-bold text-xl mb-2 "></input>
          <input name="address" defaultValue={props.adresse} className="text-gray-700 text-base" type="text"></input>
          <button className="bg-green-400 my-2">Validate</button>
        </form>
        
      </div>
    </div>
    }
  </>
  );
  
}
