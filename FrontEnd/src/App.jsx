import { useEffect, useState } from 'react'
import './App.css'
import Login from "./Login";

function App() {
  const [usuarioLogeado, setUsuarioLogeado] = useState(null);

  const handleLoginSuccess = (userData) => {
    setUsuarioLogeado(userData); // Guarda ID, nombre, rol
  };

  return (
    <div>
      <h1>Sistema SweetStock</h1>

      {!usuarioLogeado ? (
        <Login onLoginSuccess={handleLoginSuccess} />
      ) : (
        <div>
          <h2>Bienvenido {usuarioLogeado.nombre}</h2>
          <p>Rol: {usuarioLogeado.rol}</p>

          {usuarioLogeado.rol === "ADMIN" && <p>✅ Vista de administrador</p>}
          {usuarioLogeado.rol === "ALMACENERO" && <p>📦 Vista de almacén</p>}
          {usuarioLogeado.rol === "VENDEDOR" && <p>🛒 Vista de ventas</p>}
        </div>
      )}
    </div>
  );
}

export default App
