import React from "react";
import { useKeycloak } from "@react-keycloak/web";

const Login = () => {
 const { keycloak, initialized } = useKeycloak();

 return (
   <div>
        
        {!keycloak.authenticated && (
          <>
          <h1>Tu n'es pas connecté</h1>
          <button
            type="button"
            className="text-blue-800"
            onClick={() => keycloak.login()}
          >
            Se connecter ou s'enregistrer ici
          </button></>
        )}
   </div>
 );
};

export default Login;