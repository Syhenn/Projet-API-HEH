import { Link } from "react-router-dom"

export default function More(props) {
  return( 
    <div className="bg-white p-3 flex justify-center items-center rounded-lg">
      <p>Vous souhaitez en voir plus ? </p>
      <Link
        to={props.to}
        className="inline-block p-2 hover:bg-blue-500 bg-blue-600 text-white ml-5 rounded-lg"
      >
        {" "}
        Cliquez ici !
      </Link>
    </div>
  );
}
