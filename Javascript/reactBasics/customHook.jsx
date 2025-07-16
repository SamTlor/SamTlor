// why make custom hooks:
// Reusability:If you want to use the same useEffect logic in multiple components, this avoids copy-pasting code
// Abstraction & Readability: component stays clean and focused on rendering, custom hook handles side effects
// Testability: Custom hooks are easier to unit test in isolation if needed



import { useState } from "react";
import useConsoleLog from "./useConsoleLog";

export default function App() {
    const [count, setCount] = useState(0);

    // useConsoleLog runs every time because whenever setCount runs the whole 
    // component rerenders and this function is called
    // this works exactly the same a useEffect but it's a function that can be called
    useConsoleLog(count);

    function increment() {
        setCount(prevCount => prevCount + 1);
    }

    return (
        <div>
            <h1>Count: {count}</h1>
            <button onClick={increment}>Plus 1</button>
        </div>
    );
}



// this should go in a separate file called useConsoleLog or whatever
import { useEffect } from "react";

export default function useConsoleLog(varName) {
    useEffect(() => {
        console.log(varName);
    }, [varName]);
}



// additional resources
// https://react.dev/learn/reusing-logic-with-custom-hooks