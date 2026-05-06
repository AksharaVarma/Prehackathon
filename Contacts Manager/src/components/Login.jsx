import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "../App.css";

const Login = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
      <div className="form-box">
        <h2>Login</h2>

        <input type="email" placeholder="Email" />
        <input type="password" placeholder="Password" />

        <button onClick={() => navigate("/contacts")}>Login</button>

        <p>
          New user? <Link to="/register">Register</Link>
        </p>
      </div>
    </div>
  );
};

export default Login;