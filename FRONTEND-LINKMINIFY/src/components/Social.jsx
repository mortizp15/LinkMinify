import { FaLinkedin } from "react-icons/fa";
import { FaGithubSquare } from "react-icons/fa";

const Social = () => {
  return (
    <section className="flex w-40 h-8 justify-center gap-7">
      <a className="tracking-wider transition ease-in-out delay-100 hover:-translate-y-1" href="https://www.linkedin.com/in/manuel-ortiz-4ba1442a1/" target="_blank">
        <FaLinkedin style={{
            color: "white",
            fontSize: "30px"
        }}/>
      </a>
      <a className="tracking-wider transition ease-in-out delay-100 hover:-translate-y-1" href="https://github.com/mortizp15" target="_blank">
        <FaGithubSquare style={{
            color: "white",
            fontSize: "30px"
        }}/>
      </a>
    </section>
  )
}

export default Social
