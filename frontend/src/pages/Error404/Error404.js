import { useEffect } from "react";
import { Link } from "react-router-dom";

export default function Error404() {
  useEffect(() => {
    document.title = "Error 404";
  }, []);

  return (
    <div className="h-full flex justify-center min-h-screen items-center">
      <div className="flex flex-col items-center gap-5">
        <h1 className="text-blue-600 font-bold text-4xl uppercase">
          Error 404
        </h1>
        <p>The page you are looking for does not exist</p>
        <Link
          to="/"
          className="p-3 bg-blue-500 inline-block rounded-full text-white hover:bg-blue-400"
        >
          Go Home
        </Link>
      </div>
    </div>
  );
}
