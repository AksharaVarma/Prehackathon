import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "../App.css";

const Register = () => {
  const navigate = useNavigate();

  return (
    <div className="container">
      <div className="form-box">
        <h2>Register</h2>

        <input type="text" placeholder="Name" />
        <input type="email" placeholder="Email" />
        <input type="password" placeholder="Password" />

        <button onClick={() => navigate("/login")}>Register</button>

        <p>
          Already have an account? <Link to="/login">Login</Link>
        </p>
      </div>
    </div>
  );
};

export default Register;