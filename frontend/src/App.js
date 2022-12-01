import { BrowserRouter as Router, Routes, Route, BrowserRouter } from "react-router-dom";
import { ReactKeycloakProvider } from "@react-keycloak/web";
import Secured from "./pages/Secured/Secured";
import PrivateRoute from "./pages/Secured/PrivateRoute";
import keycloak from "./keycloak";
import Navbar from "./components/Nav/Navbar";
import Login from "./pages/Login/Login";
function App() {
  return (
    <div className="bg-slate-100">
      <ReactKeycloakProvider authClient={keycloak}>
         <Login />
      <Router>
        <Routes>
        <Route
             path="*"
             element={
               <PrivateRoute>
                 <Secured />
               </PrivateRoute>
             }
           />
        </Routes>
      </Router>
      </ReactKeycloakProvider>
    </div>
  );
}

export default App;
