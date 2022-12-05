import axios from "axios"
import { useState } from "react"
import { useKeycloak } from "@react-keycloak/web";

export default function CardsAlcool(props) {

  const { keycloak, initialized } = useKeycloak();
  const [isModify, setIsModify] = useState(false)
  const config = axios.create({baseURL : "http://localhost:8080"})
  function supp(e) {
    const id = e.target.id
    config.delete(`/${props.type}/${id}`)
    window.location.reload();
  }

  function validate(e){
    const id = e.target.id

    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData)

    const form = {
      name: data.name,
      url: data.url,
      degrees: parseFloat(data.degrees)
    }

    config.put(`/${props.type}/${id}`, form).then((sucess)=> {
      setIsModify(false)
    })
  
  }
  return( 
    <>
    {!isModify ?
      <div className="relative max-w-sm rounded overflow-hidden shadow-lg">
        <div className="w-full h-48 overflow-hidden">
          <img className="h-full w-full bg-cover" src={props.url} alt="Sunset in the mountains"/>
        </div>

        <div className="px-6 py-4 bg-white">
          <div className="font-bold text-xl mb-2">{props.name}</div>
          <p className="text-gray-700 text-base">
            {props.degrees}° degrés
          </p>
        </div>

        
        
        {keycloak.hasRealmRole("admin") && (
          <>
          <p onClick={supp} id={props.id} className="absolute top-0 right-0 rounded-full px-3 text-white cursor-pointer py-1 m-1 bg-red-500 ">-</p>
          <p onClick={()=> setIsModify(true)} id={props.id} className=" absolute top-0 rounded-full px-3 text-white cursor-pointer py-1 m-1 bg-orange-500 ">x</p>
          </>)
        }
      </div>
    :

    <div className="relative max-w-sm rounded overflow-hidden shadow-lg bg-white">
      <form onSubmit={validate} className="flex flex-col p-5" id={props.id}>
        <input name="name" type="text" defaultValue={props.name} className="font-bold text-xl mb-2 "></input>
        <input name="url" defaultValue={props.url} className="text-gray-700 text-base" type="url"></input>
        <input name="degrees" type="text" defaultValue={props.degrees} className="mb-2 "></input>
        <button className="bg-green-400 my-2">Validate</button>
      </form>
    </div>
    }
    </>
    
  );
}
