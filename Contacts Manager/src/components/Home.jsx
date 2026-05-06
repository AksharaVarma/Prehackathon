import React from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div className="home-content">
        <h4>Welcome to Contacts App</h4>
        <p>Manage your contacts easily.</p>

        <div className="home-buttons">
          <button onClick={() => navigate("/login")} className="btn login-btn">
  Login
</button>

<button onClick={() => navigate("/register")} className="btn register-btn">
  Register
</button>
        </div>
      </div>
    </div>
  );
};

export default Home;