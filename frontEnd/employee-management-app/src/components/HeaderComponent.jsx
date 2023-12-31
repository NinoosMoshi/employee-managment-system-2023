import {NavLink} from 'react-router-dom'

const HeaderComponent = () => {
  return (
    <div>
      <header>
        {/* <nav className='navbar navbar-dark bg-dark'>
          <a className='navbar-brand' href='#'>Employee Management System</a>
        </nav> */}

<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">Employee Management System</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNav">
      <ul className="navbar-nav">
        <li className="nav-item">
          <NavLink to='/employees' className='nav-link'>Employees</NavLink>
        </li>
        <li className="nav-item">
          <NavLink to='/departments' className='nav-link'>Departments</NavLink>
        </li>
      </ul>
    </div>
  </div>
</nav>



      </header>
    </div>
  )
}

export default HeaderComponent