import { useState } from "react"
import Social from "./components/Social"
import { getShortUrl } from "./services/getShortUrl"
import { ShortedLink } from "./components/ShortedLink"

function App() {

  const [ url, setUrl ] = useState("")
  const [ shortCode, setShortCode ] = useState("")
  const [errorUrl, setErrorUrl] = useState("")

  function isValidUrl(urlStr) {
    try {
      new URL(urlStr)
      return true
    } catch(error) {
      return false
    }
  }

  const handleChange = (event) => {
    setUrl(event.target.value)
  }
  
  const handleSubmit = async (event) => {
    event.preventDefault()

    if(!isValidUrl(url)) {
      setErrorUrl("EL formato del enlace no es válido. Por favor, introduce un enlace correcto.")
      return
    }

    const shortCodeFromData = await getShortUrl(url)
    setShortCode(shortCodeFromData)
  }

  const handleResetShortCode = () => {
    setShortCode("")
    setErrorUrl("")
  }

  return (
    <main className="w-full h-screen bg-[#121212] flex items-center pt-48 flex-col">
      <Social />
      <h2 className="text-[#D9D9D9] text-2xl mt-7 font-semibold">LinkMinify</h2>
      <h1 className="text-6xl mt-10 font-bold text-transparent text-center bg-clip-text bg-gradient-to-r sm:ml-16 sm:mr-16 from-[#06F52C] to-[#03FFC3]">Acortador de links</h1>
      {shortCode === "" ? 
        (
          <form onSubmit={(event) => handleSubmit(event)} method="POST" className="w-full flex h-1/3  items-center flex-col justify-center">
            <input onChange={(event) => handleChange(event)} className={`w-6/12 h-11 bg-transparent focus:outline-none text-white border-solid border rounded-md ${errorUrl !== "" ? 'border-red-600' : 'border-[#AAAAAA]'} pl-5 pb-1`} type="text" placeholder="Pega aquí tu enlace largo..."/>
            <button type="submit" className='flex bg-gradient-to-r from-[#06F52C] to-[#03FFC3] text-ellipsis items-center justify-center gap-3 text-[#353535] cursor-pointer rounded-full text-md mt-16 w-44 uppercase font-bold tracking-wider p-3 px-5 transition ease-in-out delay-100 hover:-translate-y-1'>ACORTAR</button>
            {errorUrl !== "" && (
              <p className="text-red-600 font-bold absolute text-center">{errorUrl}</p>
            )}
          </form>
        ) : (
          <section className="w-full flex h-1/3 flex-col items-center justify-center">
            <ShortedLink shortCode={shortCode}/>
            <button type="submit" onClick={() => handleResetShortCode()} className="flex bg-gradient-to-r from-[#06F52C] to-[#03FFC3] items-center justify-center gap-3 text-[#353535] cursor-pointer rounded-full text-md mt-11 w-44 uppercase font-bold tracking-wider p-3 px-5 transition ease-in-out delay-100 hover:-translate-y-1">ACORTAR OTRO</button>
          </section>
        )}
      <p className="text-[#D9D9D9] text-center md:m-16 sm:ml-16 sm:mr-16">
        Acortador de enlaces completamente gratis, sin publicidad. Pega el enlace, dale a “ACORTAR” y listo.
      </p>
    </main>
  )
}

export default App
