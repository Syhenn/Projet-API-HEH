import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Alcool from "./pages/Alcool/Alcool";
import Error404 from "./pages/Error404/Error404";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import Store from "./pages/Store/Store";

function App() {
  return (
    <div className="bg-slate-100">
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/alcool" element={<Alcool />} />
          <Route path="/store" element={<Store />} />
          <Route path="*" element={<Error404 />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
