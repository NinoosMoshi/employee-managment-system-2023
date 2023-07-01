import { useEffect, useState } from "react"
import { createDepartment, getDepartmentById, updateDepartment } from "../service/DepartmentService";
import { useNavigate, useParams } from "react-router-dom";


const DepartmentComponent = () => {


  const [departmentName, setDepartmentName] = useState('');
  const [departmentDescription, setDepartmentDescription] = useState('');

  const navigator = useNavigate();
  const {id} = useParams()

  useEffect(() =>{
    if(id){
      getDepartmentById(id).then(response =>{
      setDepartmentName(response.data.departmentName);
      setDepartmentDescription(response.data.departmentDescription);
    }).catch(error =>{
      console.log(error)
    })
    }
    
  },[id])



  function saveOrUpdateDepartment(e){
    e.preventDefault();
    const department = {departmentName, departmentDescription};

    if(id){
      updateDepartment(id, department).then(response => {
        console.log(response);
        navigator("/departments")
      }).catch(error =>{
        console.log(error)
      })
    }else{
      createDepartment(department).then(response =>{
        console.log(response.data)
        navigator("/departments")
      }).catch(error =>{
        console.log(error)
      })
    }
    
  }

  function pageTitle(){
    if(id){
      return <h2 className="text-center">update Departments</h2>
    }
    else{
      return <h2 className="text-center">Add Departments</h2>
    }
  }


  return (
    <div className="container">
        <br /> <br />
       <div className="row">
         <div className="card col-md-6 offset-md-3 offset-md-3">
           {
            pageTitle()
           }
           <div className="card-bod">
              <form>

                  <div className="form-group mb-2">
                    <label className="form-label">Department Name:</label>
                    {/* <input className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}  */}
                    <input className="form-control"
                    type="text" placeholder="Enter Department Name" 
                    name="departmentName" value={departmentName} onChange={(e) => setDepartmentName(e.target.value)}
                    />
                    {/* {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>} */}
                  </div>  


                  <div className="form-group mb-2">
                    <label className="form-label">Department Description:</label>
                    <input className="form-control"
                    type="text" placeholder="Enter Department Description" 
                    name="departmentDescription" value={departmentDescription} onChange={(e) => setDepartmentDescription(e.target.value)}
                    />
                    {/* {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>} */}
                  </div> 

                

                  <button className="btn btn-success" onClick={saveOrUpdateDepartment}>Submit</button>

              </form>
           </div>
         </div>
       </div>
    </div>
  )
}

export default DepartmentComponent