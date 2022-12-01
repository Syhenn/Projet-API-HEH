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

        
        <div className="flex justify-center items-center bg-white p-5 flex-col gap-2">
          <div className="flex justify-center">
              <svg aria-hidden="true" className="w-5 h-5 text-yellow-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>First star</title><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
              <svg aria-hidden="true" className="w-5 h-5 text-yellow-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>Second star</title><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
              <svg aria-hidden="true" className="w-5 h-5 text-yellow-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>Third star</title><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
              <svg aria-hidden="true" className="w-5 h-5 text-yellow-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>Fourth star</title><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
              <svg aria-hidden="true" className="w-5 h-5 text-gray-300 dark:text-gray-500" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>Fifth star</title><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
            </div>
            <p className="text-sm font-medium text-gray-900  hover:no-underline">10 reviews</p>
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
