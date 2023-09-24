"use client"

import { useState } from "react"
import "./style.css"
import instance from "@/services/api"

import { toast } from "react-toastify"

export default function SignUpPage() {

  const httpClient = instance;
  
  const [formValue, setFormValue] = useState({
    "name": "",
    "email": "",
    "password": "",
    "confirmPassword": ""
  })

  const handleChange = (event) => {
    setFormValue({...formValue, [event.target.name]: event.target.value});
  }

  const validateData = () => {
    if(formValue.confirmPassword != formValue.password)
      throw "The passwords doesn't match!";

    	const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
      const isInvalidEmail = !emailRegex.test(formValue.email);
      if (isInvalidEmail) 
        throw "Insert a valid email";
  }

  const handleSubmit = (event) => { 
    event.preventDefault();
    try {
      validateData();
    } catch(error) {
      toast.error(error);
      return;
    }

    instance.post("/auth/register", formValue)
      .then(() => toast.success('Registered successfully!'))
      .catch((e) => toast.error('There is already an user registered with this email.'));
  }

  return (
    <>
    <main className="flex flex-col justify-center items-center h-screen w-screen overflow-hidden">
        <div className="flex justify-center items-center">
          <h1 className="mb-4 text-8xl text-primary">Tourism</h1>
          <ion-icon name="airplane-outline" className="text-4xl"></ion-icon>
        </div>
        <form onSubmit={handleSubmit}>
          <input type="text" required onChange={handleChange} value={formValue.name} name="name" placeholder="Name" className="pl-2 block rounded-md mb-4 border-2 w-60 border-black h-8"/>
          <input type="text" required onChange={handleChange} value={formValue.email} name="email" placeholder="Email" className="pl-2 block rounded-md mb-4 border-2 w-60 border-black h-8"/>
          <input type="password" required onChange={handleChange} placeholder="Password" value={formValue.password} name="password" className="pl-2 block rounded-md border-2 mb-4 w-60 border-black h-8"/>
          <input type="password" required onChange={handleChange} placeholder="Confirm password" value={formValue.confirmPassword} name="confirmPassword" className="pl-2 block rounded-md border-2 w-60 border-black h-8"/>
          <input type="submit" value="Sign-up" className="bg-secondary cursor-pointer text-primary font-bold border-2 border-black w-60 h-12 rounded-md mt-4"/>
        </form>
        <a href="/" className="underline text-primary mt-4 font-bold">Already have an account? Log in!</a>
    </main>
    </>
  )
}
