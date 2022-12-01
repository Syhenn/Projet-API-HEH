import React from 'react';
import { BrowserRouter as Router, Routes, Route, BrowserRouter } from "react-router-dom";
import Store from '../Store/Store';
import Alcool from '../Alcool/Alcool';
import Error404 from '../Error404/Error404';
import Home from '../Home/Home';
const Secured = () => {

 return (
  <div>
      <Routes>
        <Route path="/" element={< Home/>} />
        <Route path="/alcool" element={<Alcool />} />
        <Route path="/store" element={<Store />} />
        <Route path="*" element={<Error404 />} />
      </Routes>

</div>
 );
};

export default Secured;