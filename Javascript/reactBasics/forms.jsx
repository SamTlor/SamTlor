// https://formik.org/ 
// is the most popular open source form library for React. It saves you lots of time when building forms and offers a declarative, intuitive and adoptable paradigm. 

// https://github.com/jquense/yup
// is an open-source library that integrates perfectly with Formik. It allows you to set all your form validation rules declaratively.

// https://github.com/react-hook-form/react-hook-form
// is another popular library to easily manage your form state and validation rules.



// imports
import { useRef } from 'react';
import { useState } from "react";



// uncontrolled inputs
// the value of the form is only accessable once the form is submitted
const UncontrolledForm = () => { 
    const genericInputRef = useRef(null); 
    
    const handleSubmitGeneric = () => { 
        const inputValue = genericInputRef.current.value; 
        // Do something with the value 
    } 

    return ( 
        <form onSubmit={handleSubmitGeneric}> 
            <input ref={genericInputRef} type="text" /> 
        </form> 
    );
}; 

// input type = "file" is always uncontrolled because it is read only
const UncontrolledFormFile = () => {
    const fileInputRef = useRef(null); 
    
    const handleSubmitFile = (e) => {
        e.preventDefault();
        const files = fileInputRef.current.files;
        // Do something with the files here
    }
    
    return(
        <form onSubmit={handleSubmitFile}> 
            <input ref={fileInputRef} type="file" /> 
        </form> 
    );
}



// controlled inputs
// every time the user types a new character 
const ControlledForm = () => { 
    const [value, setValue] = useState(""); 

    const handleChange = (e) => { 
        setValue(e.target.value) 
    } 

    return ( 
        <form> 
            <input 
            value={value} 
            onChange={handleChange} 
            type="text" 
            /> 
        </form> 
    ); 
}; 

const ControlledFormSlider = () => {

    const [sliderValue, setScore] = useState("10");

    return (
        <form>
            <fieldset>
                <h2>Form title</h2>
                <div className="Field">
                    <label>Value: {sliderValue}</label>
                    <input 
                        type="range" 
                        min="0" 
                        max="10" 
                        value={sliderValue} 
                        onChange={e => setScore(e.target.value)} 
                    />
                </div>
            </fieldset>
        </form>
    )
}


export default function App(){
    return (
        <div>
            <UncontrolledForm />
            <UncontrolledFormFile />
            <ControlledForm />
            <ControlledFormSlider />
        </div>
    )
}