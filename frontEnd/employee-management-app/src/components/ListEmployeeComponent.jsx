import { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../service/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

  const [employees, setEmployees] = useState([])
  const navigator = useNavigate();

  useEffect(() =>{
    getAllEmplyees();
  }, [])

  function getAllEmplyees(){
    listEmployees().then(response =>{
      setEmployees(response.data)
    }).catch(error =>{
      console.log(error)
    })
  }
  

  function addNewEmployee(){
    navigator("/add-employee")
  }

  function updateEmployee(id){
    navigator(`/edit-employee/${id}`)
  }

  function removeEmployee(id){
    deleteEmployee(id).then(() =>{
      getAllEmplyees();
    }).catch(error =>{
      console.log(error)
    })
  }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>

        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>

        <table className='table table-striped table-bordered'>

            <thead>
              <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
               {
                 employees.map(temp =>
                       <tr key={temp.id}>
                          <td>{temp.id}</td>
                          <td>{temp.firstName}</td>
                          <td>{temp.lastName}</td>
                          <td>{temp.email}</td>
                          <td>
                            <button className='btn btn-info' onClick={() => updateEmployee(temp.id)}>Update</button>
                            <button style={{marginLeft:'10px'}} className='btn btn-danger' onClick={() => removeEmployee(temp.id)}>Delete</button>
                          </td>
                       </tr>
                    )

               }
            </tbody>

        </table>
    </div>
  )
}

export default ListEmployeeComponent