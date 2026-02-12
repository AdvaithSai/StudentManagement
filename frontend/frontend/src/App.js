import React, { useState, useEffect } from "react";
import "./App.css";

function App() {

  const baseURL = "http://localhost:8080/students";

  const [students,setStudents]=useState([]);
  const [form,setForm]=useState({
    name:"",
    age:"",
    course:"",
    studentType:"FULL_TIME"
  });
  const [searchId,setSearchId]=useState("");

  // Load all
  const loadStudents=()=>{
    fetch(baseURL)
      .then(r=>r.json())
      .then(setStudents);
  };

  useEffect(()=>{loadStudents();},[]);

  const handleChange=e=>{
    setForm({...form,[e.target.name]:e.target.value});
  };

  // Add student
  const addStudent=()=>{
    fetch(baseURL,{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(form)
    }).then(()=>{
      loadStudents();
      setForm({
        name:"",
        age:"",
        course:"",
        studentType:"FULL_TIME"
      });
    });
  };

  // Delete
  const deleteStudent=id=>{
    fetch(`${baseURL}/${id}`,{method:"DELETE"})
      .then(loadStudents);
  };

  // View one
  const viewStudent=()=>{
    fetch(`${baseURL}/${searchId}`)
      .then(r=>r.json())
      .then(d=>setStudents(d?[d]:[]));
  };

  // Sorting
  const sortByAge=()=>{
    fetch(`${baseURL}/sort/age`)
      .then(r=>r.json())
      .then(setStudents);
  };

  const sortByName=()=>{
    fetch(`${baseURL}/sort/name`)
      .then(r=>r.json())
      .then(setStudents);
  };

  // Filter by type
  const filterType=(type)=>{
    fetch(`${baseURL}/type/${type}`)
      .then(r=>r.json())
      .then(setStudents);
  };

  return(
    <div className="container">

      <h1>🎓 Student Management</h1>

      {/* ADD STUDENT */}
      <div className="card">
        <h3>Add Student</h3>

        <input name="name" placeholder="Name"
          value={form.name} onChange={handleChange}/>

        <input name="age" placeholder="Age"
          value={form.age} onChange={handleChange}/>

        <input name="course" placeholder="Course"
          value={form.course} onChange={handleChange}/>

        {/* TYPE DROPDOWN */}
        <select name="studentType"
          value={form.studentType}
          onChange={handleChange}>

          <option value="FULL_TIME">Full-Time</option>
          <option value="PART_TIME">Part-Time</option>
        </select>

        <button className="btn add" onClick={addStudent}>
          Add Student
        </button>
      </div>

      {/* SEARCH */}
      <div className="card">
        <h3>Search by ID</h3>
        <input placeholder="Student ID"
          value={searchId}
          onChange={e=>setSearchId(e.target.value)}/>
        <button className="btn" onClick={viewStudent}>View</button>
        <button className="btn" onClick={loadStudents}>View All</button>
      </div>

      {/* SORT */}
      <div className="card">
        <h3>Sort</h3>
        <button className="btn" onClick={sortByAge}>Sort by Age</button>
        <button className="btn" onClick={sortByName}>Sort by Name</button>
      </div>

      {/* FILTER */}
      <div className="card">
        <h3>Filter by Type</h3>
        <button className="btn"
          onClick={()=>filterType("FULL_TIME")}>
          Full-Time
        </button>

        <button className="btn"
          onClick={()=>filterType("PART_TIME")}>
          Part-Time
        </button>
      </div>

      {/* LIST */}
      <div className="list">
        {students.map(s=>(
          <div key={s.id} className="studentCard">
            <div>
              <strong>{s.name}</strong>
              <p>ID: {s.id}</p>
              <p>Age: {s.age}</p>
              <p>Course: {s.course}</p>
              <p>
                Type:
                <span className={
                  s.studentType==="FULL_TIME"
                  ? "tag full"
                  : "tag part"
                }>
                  {s.studentType}
                </span>
              </p>
            </div>

            <button className="btn delete"
              onClick={()=>deleteStudent(s.id)}>
              Delete
            </button>
          </div>
        ))}
      </div>

    </div>
  );
}

export default App;
