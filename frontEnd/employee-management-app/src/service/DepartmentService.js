import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/v1/departments';


export const listDepartments = () => axios.get(BASE_URL)

export const createDepartment = (department) => axios.post(BASE_URL, department);

export const getDepartmentById = (departmentId) => axios.get(`${BASE_URL}/${departmentId}`);

export const updateDepartment = (departmentId, department) => axios.put(`${BASE_URL}/${departmentId}`, department);

export const deleteDepartment = (departmentId) => axios.delete(`${BASE_URL}/${departmentId}`);
