function Contact () {
  return (

    <section className="fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-[500px] max-w-4xl mobile:w-full mobile:px-6 p-6">
      <div className="px-4 py-6 mx-auto space-y-4">

        <div className="flex justify-between">
          <span className="font-semibold">Phone number:</span>
          <span>703-969-6032</span>
        </div>

        <div className="flex justify-between">
          <span className="font-semibold">Email:</span>
          <span>Sam.tlor1@gmail.com</span>
        </div>

        <div className="flex justify-between">
          <span className="font-semibold">LinkedIn:</span>
          <span><a href="https://www.linkedin.com/in/sam-tlor/" className="text-blue-500 underline">
            https://www.linkedin.com/in/sam-tlor/
          </a></span>
        </div>

        <div className="flex justify-between">
          <span className="font-semibold">GitHub:</span>
          <a href="https://www.linkedin.com/in/sam-tlor/" className="text-blue-500 underline">
            https://github.com/SamTlor/SamTlor
          </a>
        </div>

      </div>
    </section>)
}

export default Contact;