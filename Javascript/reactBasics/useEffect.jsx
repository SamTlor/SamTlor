// a built in function best suited to perform side effects of your functions
// like doing console logs, referencing a dom node, using browser api's, 
// fetching data, using local/session storage



// this will update the document title everytime the version variable changes between renders
// if you don't put the variable after the function then the function will run every render
const version = 1;
useEffect(() => {
    document.title = `Little Lemon v${version}`;
}, [version])



// if you need to clean up resources or avoid memory leaks use return
useEffect(() => {
    // main function stuff here

    return () => {
        // clean up stuff here
    }
})



// example app
// import './App.css'; 
import {useState, useEffect} from "react"; 


export default function App() { 
    const [toggle, setToggle] = useState(false);

    const clickHandler = () => {
        setToggle(!toggle);
    }

    useEffect(() => {
        document.title = toggle ? "Welcome to the page" : "Using the useEffect hook"
    });

    // in this version the document title is automatically set to Using the useEffect hook
    // the Welcome to the page! tag still appears because that changes when clickHandler runs
    useEffect(() => {
        document.title = toggle ? "Welcome to the page" : "Using the useEffect hook"
    }, []);

    return(
        <div>
            <h1>Example of the useEffect hook</h1>
            <button onClick={clickHandler}>Toggle Message</button>
            {toggle && <h2>Welcome to the page!</h2>}
        </div>
    )
}



// additional resources
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring
// https://react.dev/learn/passing-props-to-a-component#step-2-read-props-inside-the-child-component
// https://react.dev/apis/react/useState#usestate
// https://react.dev/apis/react/useEffect#useeffect