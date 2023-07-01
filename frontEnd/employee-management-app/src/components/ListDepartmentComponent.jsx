import { useEffect, useState } from "react"
import { deleteDepartment, listDepartments } from "../service/DepartmentService";
import { Link, useNavigate } from "react-router-dom";


const ListDepartmentComponent = () => {


    
    const [departments, setDepartments] = useState([]);
    const navigator = useNavigate();
    

    useEffect(() =>{
      getAllDepartments()
    },[])


    function getAllDepartments(){
        listDepartments().then(response =>{
            setDepartments(response.data)
        }).catch(error =>{
            console.log(error)
        })
    }


    function updateDepartment(id){
      navigator(`/edit-department/${id}`)
    }

    function removeDepartment(id){
       deleteDepartment(id).then(() =>{
        getAllDepartments();
       }).catch(error => {
        console.log(error)
       })
    }

   


  return (
    <div className='container'>
        <h2 className='text-center'>List of Departments</h2>

        <Link to='/add-department' className="btn btn-primary mb-2">Add Department</Link>

        <table className='table table-striped table-bordered'>

            <thead>
              <tr>
                <th>Id</th>
                <th>department Name</th>
                <th>department Description</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
               {
                 departments.map(temp =>
                       <tr key={temp.id}>
                          <td>{temp.id}</td>
                          <td>{temp.departmentName}</td>
                          <td>{temp.departmentDescription}</td>
                          <td>
                            <button className='btn btn-info' onClick={() => updateDepartment(temp.id)} >Update</button>
                            <button style={{marginLeft:'10px'}} className='btn btn-danger' onClick={() => removeDepartment(temp.id)} >Delete</button>
                          </td>
                       </tr>
                    )

               }
            </tbody>

        </table>
    </div>
  )
}

export default ListDepartmentComponent