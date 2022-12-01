import { useEffect } from "react";

import { Link } from "react-router-dom";

export default function Login() {
  useEffect(() => {
    document.title = "Login";
  }, []);

  return (
    <div className="h-screen w-screen flex items-center justify-center">
      <div className="w-96">
        <h2 className="text-2xl text-center mb-10 font-bold">Login</h2>
        <form className="flex flex-col gap-2">
          <div>
            <label htmlFor="username">Username</label>
            <input
              id="username"
              type="text"
              className="w-full rounded-md p-1 focus:outline-none pl-2"
            />
          </div>

          <div>
            <label htmlFor="password">Password</label>
            <input
              id="password"
              type="password"
              className="w-full rounded-md p-1 focus:outline-none pl-2"
            />
          </div>

          <button className="p-2 text-center w-full bg-blue-500 hover:bg-blue-400 rounded-full font-bold text-white mt-3">
            Login
          </button>
        </form>

        <Link to="/" className="text-center block p-2 hover:text-blue-700">
          Back Home
        </Link>
      </div>
    </div>
  );
}
