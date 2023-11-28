"use client"

import React, { useState } from "react"
import "./style.css"
import { useRouter } from "next/navigation"
import instance from "@/services/api";
import TravelPackageCategory from "@/components/travelPackageCategory";

export default function LoginPage() {

    const { replace } = useRouter();

    const [userDetails, setUserDetails] = React.useState({});
    const [allPackages, setAllPackages] = React.useState({});


    const getPackages = async () => {
        const packagesByCategory = {};
        let response = await instance.get('/premiumPackages');
        console.log("Ó:")
        console.log(response)
        response.data.map(each => {
            if(!(each.destinyCategory in packagesByCategory))
                packagesByCategory[each.destinyCategory] = []
            each.isPremium = true;
            packagesByCategory[each.destinyCategory].push(each)
        })

        response = await instance.get('/packages')
        response.data.map(each => {
            if(!(each.destinyCategory in packagesByCategory))
                packagesByCategory[each.destinyCategory] = []
            each.isPremium = false;
            packagesByCategory[each.destinyCategory].push(each)
        })
        setAllPackages(packagesByCategory);
    }

    React.useEffect( () => {
        const userInfo = JSON.parse(localStorage.getItem("userDetails"))
        console.log(userInfo)
        if(!userInfo)
            replace('/')
        setUserDetails(userInfo);
    
        getPackages();
    }, [])

    
    return (
        <main className="flex flex-col h-screen w-screen overflow-scroll">
            <header className="flex p-4 border-b-2 border-b-black border-solid">
                <div className="text-primary font-bold">
                    <h2>Hello, <span className="text-secondary">{userDetails.name}!</span></h2>
                    <h3>We selected the best offers for you</h3>
                </div>
            </header>
            <div className="flex mt-4 align-center justify-center">
                <h1 className="mb-4 text-4xl text-primary font-bold">Travel Packages</h1>
            </div>
            {Object.keys(allPackages).map(category => <TravelPackageCategory key={category} categoryName={category} packages={allPackages[category]}></TravelPackageCategory>)}
        </main>
    )
}
