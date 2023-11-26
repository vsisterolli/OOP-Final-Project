"use client"

import { useState } from "react"
import "./style.css"
import instance from "@/services/api"

import { ToastContainer, toast } from "react-toastify"
import { useRouter } from "next/navigation"

export default function LoginPage() {

  const httpClient = instance;
  const { replace } = useRouter()
  
  const [formValue, setFormValue] = useState({
    "email": "",
    "password": "",
  })

  const handleChange = (event) => {
    setFormValue({...formValue, [event.target.name]: event.target.value});
  }

  const handleSubmit = (event) => { 
    event.preventDefault();

    toast("Logging in...")
    instance.post("/auth/login", formValue)
      .then((response) => {
        localStorage.setItem("userDetails", JSON.stringify(response.data));
        replace("/main")
        toast.success('Logged in successfully!')
      })
      .catch((e) => toast.error('Invalid user information.'));
  }
  return (
    <main className="flex flex-col justify-center items-center h-screen w-screen overflow-hidden">
        <div className="flex justiy-center items-center">
          <h1 className="mb-4 text-8xl text-primary">Tourism</h1>
          <ion-icon name="airplane-outline" className="text-4xl"></ion-icon>
        </div>
        <form onSubmit={handleSubmit}>
          <input onChange={handleChange} type="text" name="email" value={formValue.email} placeholder="email" className="pl-2 block rounded-md mb-4 border-2 w-60 border-black h-8"/>
          <input onChange={handleChange} type="password" name="password" value={formValue.password} placeholder="password" className="pl-2 block rounded-md border-2 w-60 border-black h-8"/>
          <input onChange={handleChange} type="submit" value="Login" className="bg-secondary cursor-pointertext-primary font-bold border-2 border-black w-60 h-12 rounded-md mt-4"/>
        </form>
        <a href="sign-up" className="underline text-primary mt-4 font-bold">Still doesn't have an account? Sign up!</a>
    </main>
  )
}
