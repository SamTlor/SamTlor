function Contact () {
  return (

    <section className="fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-[500px] max-w-4xl mobile:w-full mobile:px-6 p-6">
      <div className="px-4 py-6 mx-auto space-y-4">

        {/* <form action="https://formsubmit.co/YOUR_EMAIL" className="space-y-8" method="POST">
          <div>
            <label htmlFor="email" className="block mb-2 text-sm font-medium text-white dark:text-gray-300">Your email</label>
            <input type="email" id="email" name="email" required className="shadow-sm bg-gray-50 border border-gray-300 text-gray-800 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 dark:shadow-sm-light" placeholder="your@mail.com" />
          </div>
          <div>
            <label htmlFor="subject" className="block mb-2 text-sm font-medium text-white dark:text-gray-300">Subject</label>
            <input type="text" id="subject" name="subject" required className="block p-3 w-full text-sm text-gray-800 bg-gray-50 rounded-lg border border-gray-300 shadow-sm focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500 dark:shadow-sm-light" placeholder="Describe your subject" />
          </div>
          <div className="sm:col-span-2">
            <label htmlFor="message" className="block mb-2 text-sm font-medium text-white dark:text-gray-400">Your message</label>
            <textarea id="message" name="message" rows={6} className="block p-2.5 w-full text-sm text-gray-800   bg-gray-50 rounded-lg shadow-sm border border-gray-300 focus:ring-primary-500 focus:border-primary-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="Leave a comment..."></textarea>
          </div>
          <button type="submit" className="py-3 px-5 text-sm font-medium text-center text-white rounded-lg bg-gray-700 sm:w-fit hover:bg-primary-800 focus:ring-4 focus:outline-none focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Send message</button>
        </form> */}

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