import './App.css'; 
import {useState} from "react"; 
 

 
export default function App() { 
    
    // state variables
    const [firstName, setFirstName] = useState(""); 
    const [lastName, setLastName] = useState(""); 
    const [email, setEmail] = useState(""); 
    const [password, setPassword] = useState({ 
        value: "", 
        isTouched: false, 
    }); 
    const [role, setRole] = useState("role"); 



    // helper functions
    const PasswordErrorMessage = () => { 
        return ( 
            <p className="FieldError">Password should have at least 8 characters</p> 
        ); 
    }; 

    const validateEmail = (email) => {
        return String(email)
            .toLowerCase()
            .match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
    };

    const getIsFormValid = () => { 
        return ( 
            firstName && 
            validateEmail(email) && 
            password.value.length >= 8 && 
            role !== "role" 
        ); 
    }; 
    
    const clearForm = () => { 
        setFirstName(""); 
        setLastName(""); 
        setEmail(""); 
        setPassword({ 
            value: "", 
            isTouched: false, 
        }); 
        setRole("role"); 
    }; 
    
    const handleSubmit = (e) => { 
        e.preventDefault(); 
        alert("Account created!"); 
        clearForm(); 
    }; 
 


    // return body ending
    return ( 
        <div className="App"> 
            <form onSubmit={handleSubmit}> 
            <fieldset> 
                <h2>Sign Up</h2> 

                {/* first name */}
                <div className="Field"> 
                    <label> 
                        First name <sup>*</sup> 
                    </label> 
                    <input 
                        value={firstName} 
                        onChange={(e) => { 
                        setFirstName(e.target.value); 
                        }} 
                        placeholder="First name" 
                    /> 
                </div> 

                {/* last name */}
                <div className="Field"> 
                    <label>Last name</label> 
                    <input 
                        value={lastName} 
                        onChange={(e) => { 
                        setLastName(e.target.value); 
                        }} 
                        placeholder="Last name" 
                    /> 
                </div> 

                {/* email */}
                <div className="Field"> 
                    <label> 
                        Email address <sup>*</sup> 
                    </label> 
                    <input 
                        value={email} 
                        onChange={(e) => { 
                            setEmail(e.target.value); 
                        }} 
                        placeholder="Email address" 
                    /> 
                </div> 

                {/* password */}
                <div className="Field"> 
                    <label> 
                        Password <sup>*</sup> 
                    </label> 
                    <input 
                        value={password.value} 
                        type="password" 
                        onChange={(e) => { 
                            setPassword({ ...password, value: e.target.value }); 
                        }} 

                        // on blur says if an input has been interacted with at least once
                        onBlur={() => { 
                            setPassword({ ...password, isTouched: true }); 
                        }} 
                        placeholder="Password" 
                    /> 
                    {password.isTouched && password.value.length < 8 ? ( 
                        <PasswordErrorMessage /> 
                    ) : null} 
                </div>

                {/* role */}
                <div className="Field"> 
                    <label> 
                        Role <sup>*</sup> 
                    </label> 

                    {/* select tags NEED the value prop */}
                    <select value={role} onChange={(e) => setRole(e.target.value)}> 
                        <option value="role">Role</option> 
                        <option value="individual">Individual</option> 
                        <option value="business">Business</option> 
                    </select> 
                </div> 

                {/* submit button */}
                <button type="submit" disabled={!getIsFormValid()}> 
                    Create account 
                </button> 
            </fieldset> 
            </form> 
        </div> 
    ); 
}  