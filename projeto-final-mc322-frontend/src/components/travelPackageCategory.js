import { useRouter } from "next/navigation";

export default function TravelPackageCategory({ categoryName, packages }) {
    
    const { replace } = useRouter();

    const imgClass = [
        "border-solid border-yellow-400 border-4",
        "border-solid border-black border-2"
    ]
    return (
        <div className="ml-4">
            <h2 className="text-2xl text-darkblue font-bold m-2 mb-4">{categoryName}</h2>
            <div className="flex">
            {packages.map(pack => {
                const { isPremium } = pack;
                return (
                    <div key={pack.id} onClick={() => replace('/package/' + pack.id)} className="mouse-pointer w-fit flex align-center flex-col text-center justify-center mr-12">
                        <div className="img-container">
                            {isPremium && <p className="text-yellow-400 font-bold">PREMIUM</p>}
                            {isPremium && <img className="star" src="/star.png"></img>}
                            <img className={"destiny " + (isPremium ? imgClass[0] : imgClass[1])} src={pack.destinyImage}></img>
                        </div>
                        <h3 className="mb-2 mt-4">{pack.destinyName}</h3>
                        <h3>U$ {pack.price}</h3>
                    </div>
                )
            })}
            </div>
        </div>
    )
}