import axios from 'axios'


const BASE_URL = 'http://localhost:8080/api/v1/employees';

export const listEmployees = () => axios.get(BASE_URL);

export const createEmployee = (employee) => axios.post(BASE_URL,employee);

export const getEmployee = (employeeId) => axios.get(`${BASE_URL}/${employeeId}`);

export const updateEmployee = (employeeId,employee) => axios.put(`${BASE_URL}/${employeeId}`, employee);

export const deleteEmployee = (employeeId) => axios.delete(`${BASE_URL}/${employeeId}`);

