import { useEffect, useState } from 'react'
import './App.css'
import Login from "./Login";

function App() {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/usuarios')
      .then(res => res.json())
      .then(data => setUsuarios(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <>
      <div>
        <h1>Sistema SweetStock</h1>
      <Login/>
      </div>
    </>
  )
}

export default App
