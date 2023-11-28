"use client"
import "./style.css"

import instance from "@/services/api"
import moment from "moment"
import { useRouter } from "next/navigation"
import { useEffect, useState } from "react"
import { toast } from "react-toastify"

export default function Page({ params }) {
    
    const [packageDetails, setPackageDetails] = useState(null);
    const [selectedAvailability, setSelectedAvailability] = useState(-1);
    const { replace } = useRouter();

    const userDetails = JSON.parse(localStorage.getItem("userDetails"));

    useEffect(() => {
        instance.get("/packages/" + params.id)
        .then(response => {
            console.log(response.data)
            setPackageDetails(response.data)
        })
        .catch(e => console.log(e));
    }, [])

    const handleChange = (event) => {
        setSelectedAvailability(event.target.value);
        console.log(event.target.value);
    }

    const onSubmit = (event) => {
        event.preventDefault()
        if(selectedAvailability === -1) {
            toast.error("Select an availability");
            return;
        }

        instance.post(
            "/reservations",
            {
                "iniDate": packageDetails.availabilities[selectedAvailability].iniDate,
                "endDate": packageDetails.availabilities[selectedAvailability].endDate,
                "travelPackageId": params.id
            },
            {
                headers: {
                    "Authorization": "Bearer " + userDetails.token
                }
            }
        ).then(() => {
            toast.success("Reserva criada com sucesso.");
            replace("/main");
        })
        .catch(error => console.log(error))
    }

    const dates = {}

    return (
        <main className="flex justify-center items-center flex-col h-screen w-screen overflow-scroll">
            <h1 className={"text-5xl text-darkblue font-bold m-2 mb-4 " + (packageDetails?.packetType === "PREMIUM" && "text-yellow-400")}>
                {packageDetails?.packetType === "PREMIUM" ? "Premium Package Details" : "Travel Package Details"}
            </h1>
            <div className="flex">
                <div className="flex justify-center items-center flex-col">
                    <h2 className="text-4xl text-darkblue font-bold m-2 mb-4">Destiny</h2>
                    <h2 className="text-2xl text-primary font-bold m-2 mb-4">{packageDetails?.destiny.name}</h2>
                    <img src={packageDetails?.destiny.image}></img>
                </div>
                <div className="ml-12 flex items-center flex-col">
                    <h2 className="text-4xl text-darkblue font-bold m-2 mb-4">Hotel</h2>
                    <h3 className="text-2xl text-secondary font-bold m-2 mb-4">{packageDetails?.hotel.name}</h3>
                    <h3 className="text-2xl text-secondary font-bold m-2 mb-4">Address: {packageDetails?.hotel.address}</h3>
                    <h3 className="text-2xl text-secondary font-bold m-2 mb-4">Stars: {packageDetails?.hotel.stars}/5</h3>
                </div>  
            </div>
            <h2 className="text-4xl text-darkblue font-bold m-2 mb-4 mt-12">Activities</h2>
            <div className="flex">
                {packageDetails?.activities.map((activity) => {
                    return (
                        <div className="m-8">
                            <h3 className="text-2xl text-secondary font-bold m-2 mb-4">{activity.name}</h3>
                            <h3 className="text-2xl text-secondary font-bold m-2 mb-4">{activity.category}</h3>
                            <h3 className="text-2xl text-secondary font-bold m-2 mb-4">On day {activity.day + 1}</h3>
                        </div>
                    )
                })}
            </div>
            <h2 className="text-4xl text-darkblue font-bold m-2 mb-4 mt-12">Travel time span</h2>
            <form onSubmit={onSubmit} className="flex flex-col items-center">
                <select required onChange={handleChange}>
                    <option default value={-1}>Select the time span</option>
                    {packageDetails?.availabilities.map((availability, index) => {
                        const timespan = moment(availability.iniDate).format("DD/MM/YYYY") + moment(availability.endDate).format("DD/MM/YYYY");
                        if(timespan in dates)
                            return <></>
                        
                        dates[timespan] = "";
                        return <option value={index}>{moment(availability.iniDate).format("DD/MM/YYYY")} - {moment(availability.endDate).format("DD/MM/YYYY")} : {availability.available} available</option>
                    }
                    )}
                </select>
                <h3 className="text-2xl text-secondary font-bold m-8">U$ {packageDetails?.price} </h3>
                <input type="submit" value="Reserve" className="bg-primary cursor-pointer text-secondary font-bold border-2 border-black min-w-60 min-h-12 w-60 h-12 rounded-md mt-4"/>
            </form>
        </main>
    )
}