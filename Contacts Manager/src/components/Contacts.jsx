import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./Contacts.css";

const Contacts = () => {
  const navigate = useNavigate();

  const [contacts, setContacts] = useState([]);
  const [selectedId, setSelectedId] = useState(null);
  const [showModal, setShowModal] = useState(false);
  const [showProfile, setShowProfile] = useState(false);
  const [search, setSearch] = useState("");

  const [editData, setEditData] = useState({
    name: "",
    phone: "",
  });

  // Dummy user (later backend)
  const user = {
    name: "Ashwanth",
    email: "ashwanth@gmail.com",
  };

  // Load contacts
  useEffect(() => {
    const data = JSON.parse(localStorage.getItem("contacts")) || [];
    setContacts(data);
  }, []);

  // Filter contacts
  const filtered = contacts.filter((c) =>
    c.name.toLowerCase().includes(search.toLowerCase())
  );

  // Select contact
  const handleSelect = (c) => {
    setSelectedId(c.id);
    setEditData(c);
  };

  // Delete contact
  const handleDelete = (id) => {
    const updated = contacts.filter((c) => c.id !== id);
    setContacts(updated);
    localStorage.setItem("contacts", JSON.stringify(updated));
  };

  // Save edit
  const handleSave = () => {
    const updated = contacts.map((c) =>
      c.id === selectedId ? { ...c, ...editData } : c
    );
    setContacts(updated);
    localStorage.setItem("contacts", JSON.stringify(updated));
    setShowModal(false);
  };

  // Logout
  const handleLogout = () => {
    navigate("/login");
  };

  return (
    <div>
      {/* NAVBAR */}
      <div className="navbar">
        <h2>Google Contacts</h2>

        <div className="profile">
          <img
            src="https://via.placeholder.com/40"
            alt="profile"
            onClick={() => setShowProfile(!showProfile)}
          />

          {showProfile && (
            <div className="dropdown">
              <p><strong>{user.name}</strong></p>
              <p>{user.email}</p>
              <button className="logout-btn" onClick={handleLogout}>
                Logout
              </button>
            </div>
          )}
        </div>
      </div>

      {/* SEARCH + NEW */}
      <div className="search-bar">
        <input
          placeholder="Search contacts..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />

        <button className="new-btn" onClick={() => navigate("/add-contact")}>
          + New Contact
        </button>
      </div>

      {/* CONTACT LIST */}
      <div className="list">
        {filtered.map((c) => (
          <div key={c.id} className="card">
            <div onClick={() => handleSelect(c)}>
              <div className="contact-info">
                <p><strong>Contact Name:</strong> {c.name}</p>
                <p><strong>Phone Number:</strong> {c.phone}</p>
              </div>
            </div>

            {selectedId === c.id && (
              <div className="actions">
                <button onClick={() => setShowModal(true)}>Edit</button>
                <button className="delete" onClick={() => handleDelete(c.id)}>
                  Delete
                </button>
              </div>
            )}
          </div>
        ))}
      </div>

      {/* FLOATING BUTTON */}
      <button className="fab" onClick={() => navigate("/add-contact")}>
        +
      </button>

      {/* EDIT MODAL */}
      {showModal && (
        <div className="modal">
          <div className="modal-content">
            <h3>Edit Contact</h3>

            <input
              value={editData.name}
              onChange={(e) =>
                setEditData({ ...editData, name: e.target.value })
              }
              placeholder="Name"
            />

            <input
              value={editData.phone}
              onChange={(e) =>
                setEditData({ ...editData, phone: e.target.value })
              }
              placeholder="Phone"
            />

            <div className="modal-buttons">
              <button onClick={handleSave}>Save</button>
              <button onClick={() => setShowModal(false)}>Cancel</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Contacts;