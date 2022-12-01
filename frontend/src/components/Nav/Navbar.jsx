import { Link, useNavigate } from "react-router-dom"

export default function Navbar() {
  const navigate = useNavigate();
  

  const user = JSON.parse(localStorage.getItem('profile'))

  function handleClick(e) {
    e.preventDefault()
    localStorage.removeItem("profile");

    // Redirection to the home page
    navigate("/")
  }


  return( 
  <nav className="bg-slate-100 flex justify-between max-w-3xl mx-auto py-5 items-center">
    <Link to="/" className="font-bold p-2 hover:text-blue-600">L'AlCOOL, c'est pas cool? </Link>
    <div className="">
      <Link to="/alcool" className="mr-5 p-2 hover:bg-blue-200 rounded-lg">Alcools</Link>
      <Link to="/store" className="mr-5 p-2 hover:bg-blue-200 rounded-lg">Magasins</Link>
      {/* {authState?.isAuthenticated ? <button onClick={logout}>Logout</button> : <button onClick={login}>Login</button>} */}

      {/* {user && <p onClick={handleClick} className="py-2 px-3 bg-blue-500 rounded-full text-white font-bold hover:bg-blue-400 inline cursor-pointer">Logout</p>} */}
      
    </div>
  </nav>
  );
}
