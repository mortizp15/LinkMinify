import { useEffect, useState } from "react"
import { FaRegCopy } from "react-icons/fa";

export const ShortedLink = ({ shortCode }) => {

    const [theShortCode, setTheShortCode] = useState(shortCode)
    const [copySuccess, setCopySuccess] = useState('Copiar')

    useEffect(() => {
        setTheShortCode(shortCode)
    }, [shortCode])

    const handleCopy = async (text) => {
        const url = ``
        try {
            await navigator.clipboard.writeText(url)
            setCopySuccess("¡Copiado!")
        } catch (err) {
            setCopySuccess("Error")
        }
    }

  return (
    <section className="w-full flex h-1/3 items-center justify-center">
        <div className="p-2 w-64 mr-14 text-white text-center rounded-md">
            <input type="text" id="shortedLink" className="font-semibold bg-transparent text-xl w-72 focus:outline-none" value={``} disabled />
        </div>
        <button onClick={() => handleCopy(shortCode)} className="bg-[#E0E0E0] p-2 ml-7 h-10 rounded-md flex gap-2 items-center transition-all border-2 hover:bg-transparent hover:text-white">
            <p className="font-semibold">{copySuccess}</p>
            <FaRegCopy style={{
                fontSize: '1.125rem',
                lineHeight: '1.75rem'
            }}/>
        </button>
    </section>
  )
}
