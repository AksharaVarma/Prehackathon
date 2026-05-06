import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../App.css";

const AddContact = () => {
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");

  const handleSave = () => {
    const newContact = {
      id: Date.now(),
      name,
      phone,
    };

    const existing = JSON.parse(localStorage.getItem("contacts")) || [];
    localStorage.setItem("contacts", JSON.stringify([...existing, newContact]));

    navigate("/contacts");
  };

  return (
    <div className="container">
      <div className="form-box">
        <h2>Add Contact</h2>

        <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Name" />
        <input value={phone} onChange={(e) => setPhone(e.target.value)} placeholder="Mobile Number" />

        <button onClick={handleSave}>Save</button>
      </div>
    </div>
  );
};

export default AddContact;