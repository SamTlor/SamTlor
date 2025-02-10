import Image from 'next/image';

function SocialMedia ({size} : {size: number}) {
  return (
    <div className="flex justify-center gap-2 pb-4"  style={{ pointerEvents: 'auto' }}>
      <a className="bg-black bg-opacity-50 p-4 rounded-full transition-all hover:scale-110 scale-100" href="https://www.linkedin.com/in/sam-tlor/"><Image src="/icons/linkedin.svg" alt="Icon" width={size} height={size} /></a>
      <a className="bg-black bg-opacity-50 p-4 rounded-full transition-all hover:scale-110 scale-100" href="https://github.com/SamTlor/SamTlor"><Image src="/icons/github.svg" alt="Icon" width={size} height={size} /></a>
      <a className="bg-black bg-opacity-50 p-4 rounded-full transition-all hover:scale-110 scale-100" href="/data/Sam_Taylor_Resume6.pdf"><Image src="/icons/resumeIcon.svg" alt="Icon" width={size} height={size} /></a>
    </div>
  )
}

export default SocialMedia;