import "./style.css"

export default function LoginPage() {
  return (
    <main className="flex flex-col justify-center items-center h-screen w-screen overflow-hidden">
        <div className="flex justiy-center items-center">
          <h1 className="mb-4 text-8xl text-primary">Tourism</h1>
          <ion-icon name="airplane-outline" className="text-4xl"></ion-icon>
        </div>
        <form>
          <input type="text" placeholder="email" className="pl-2 block rounded-md mb-4 border-2 w-60 border-black h-8"/>
          <input type="password" placeholder="password" className="pl-2 block rounded-md border-2 w-60 border-black h-8"/>
          <input type="submit" value="Login" className="bg-secondary cursor-pointertext-primary font-bold border-2 border-black w-60 h-12 rounded-md mt-4"/>
        </form>
        <a href="sign-up" className="underline text-primary mt-4 font-bold">Still doesn't have an account? Sign up!</a>
    </main>
  )
}
