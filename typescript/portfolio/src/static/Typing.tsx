import { TypeAnimation } from 'react-type-animation';

function Typing() {

  // Same substring at the start will only be typed out once, initially
  return (
    <TypeAnimation
      sequence={
        [
          'Next.js','Typescript','Tailwind CSS','React.js','Python','JAVA','C','Rust','C#','Visual Basic','C++',
          'SQL','Postgres','JavaScript','PHP','HTML','CSS','Flask','Docker','Lisp'
        ].flatMap(item => [item, 500])
      }
      wrapper="span"
      speed={10}
      preRenderFirstString={true}
      style={{ marginLeft: '5px', fontSize: '1em', textAlign: 'left', color: "#ffcba4", 
        fontWeight: 'bold', display: 'inline-block', width: '38.5%'}}
      repeat={Infinity}
    />
  );
};

export default Typing;