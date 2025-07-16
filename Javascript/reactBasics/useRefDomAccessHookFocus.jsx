import { useRef } from "react";

export default function App() {

    const formInputRef = useRef(null);

    const focusInput = () => {
        formInputRef.current.focus();
    }

    return(
        <>
            <h1>using useRef to access underlying DOM</h1>
            <input ref={formInputRef} type="text" />
            <button onClick={focusInput}>
                Focus input
            </button>
        </>
    );
}


// additional resources
// https://react.dev/reference/react/useRef