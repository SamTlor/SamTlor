// usually the parent component is stateful and the 
// child component is stateless
// the parent passes the state down to the child


import { useState } from 'react';

export default function InputComponent() { 
    // here we use useState to change the inputText variable
    const [inputText, setText] = useState('hello'); 

    function handleChange(e) { 
    	setText(e.target.value); 
    } 

    return ( 
      	<> 
			<input value={inputText} onChange={handleChange} /> 
			<p>You typed: {inputText}</p> 

			<button onClick={() => setText('hello')}> Reset </button> 
		</> 
    ); 
} 





// ADVANCED USE
// if you want to use state on an object 
// it can become inefficient to update an entire object
// so we use this:

export default function App() { 
	const [greeting, setGreeting] = useState({ 
		greet: "Hello, World",
		location: "here"
	}); 
	console.log(greeting, setGreeting); 
	
	function updateGreeting() { 
		// this creates a copy of the old state variable 
		// but changes the location variable
		// and then it uses the setGreeting function 
		setGreeting({...greeting, location: "world-wide web"}); 
	} 
	
	return ( 
		<div> 
		<h1>greeting: {greeting.greet} </h1>
		<h1>location: {greeting.location}</h1> 
		<button onClick={updateGreeting}>Update greeting</button> 
		</div> 
	); 
}