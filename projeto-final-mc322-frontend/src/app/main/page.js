"use client"

import { useState } from "react"
import "./style.css"

export default function LoginPage() {

    const userDetails = JSON.parse(localStorage.getItem("userDetails"))
    
    return (
        <main className="flex flex-col h-screen w-screen overflow-hidden">
            <header className="flex p-4 border-b-2 border-b-black border-solid">
                <div className="text-primary font-bold">
                    <h2>Hello, <span className="text-secondary">{userDetails.name}!</span></h2>
                    <h3>We selected the best offers for you</h3>
                </div>
            </header>
            <div className="flex mt-4 align-center justify-center">
                <h1 className="mb-4 text-4xl text-primary font-bold">Travel Packages</h1>
            </div>
            <div className="ml-4">
                <h2 className="text-2xl text-darkblue font-bold m-2 mb-4">Aventura</h2>
                <div className="flex">
                    <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                        <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                        <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                        <h3>R$ 3200.00</h3>
                    </div>
                    <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                        <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                        <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                        <h3>R$ 3200.00</h3>
                    </div>
                    <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                        <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                        <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                        <h3>R$ 3200.00</h3>
                    </div>
                    <div className="w-fit flex align-center flex-col text-center justify-center">
                        <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                        <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                        <h3>R$ 3200.00</h3>
                    </div>
                </div>
                <div className="ml-4 mt-4">
                <h2 className="text-2xl text-darkblue font-bold m-2 mb-4">Premium</h2>
                    <div className="flex">
                        <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                            <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                            <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                            <h3>R$ 3200.00</h3>
                        </div>
                        <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                            <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                            <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                            <h3>R$ 3200.00</h3>
                        </div>
                        <div className="w-fit flex align-center flex-col text-center justify-center mr-12">
                            <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                            <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                            <h3>R$ 3200.00</h3>
                        </div>
                        <div className="w-fit flex align-center flex-col text-center justify-center">
                            <img src="https://ichef.bbci.co.uk/news/800/cpsprodpb/cffb/live/f5d7e3a0-b770-11ed-89f4-f3657d2bfa3b.jpg"></img>
                            <h3 className="mb-2 mt-4">Ilhas Maldivas</h3>
                            <h3>R$ 3200.00</h3>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    )
}
