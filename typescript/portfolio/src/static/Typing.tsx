import { TypeAnimation } from 'react-type-animation';

function Typing() {

  // Same substring at the start will only be typed out once, initially
  return (
    <span className='text-textHighlight'>
      <TypeAnimation
        sequence={
          [
            'R', 'Pandas', 'SQL', 'Postgres', 'Python', 'Docker', 'Power BI', 'Tableau', 'Excel', 'Git', 'Linux', 'AWS', 'C++', 'JAVA','C','Rust','C#','Visual Basic','Typescript','Tailwind CSS','React.js', 'JavaScript','PHP','HTML','CSS','Flask',
          ].flatMap(item => [item, 500])
        }
        wrapper="span"
        speed={10}
        preRenderFirstString={true}
        style={{ marginLeft: '5px', fontSize: '1em', textAlign: 'left',
          fontWeight: 'bold', display: 'inline-block', width: '38.5%'}}
        repeat={Infinity}
      />
    </span>
  );
};

export default Typing;