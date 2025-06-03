export default function modeToggler(){
    
    // configurations 
    const darkModeOn = true;
    
    // JSX elements
    const darkMode = <h1>Dark Mode is on</h1>;
    const lightMode = <h1>Light Mode is on</h1>;
    
    // event handlers
    function handleDarkModeClick() {
        darkModeOn = !darkModeOn;
        
        // debugging
        // if (darkModeOn == true){
        //     console.log("Dark mode is on");
        // } else {
        //     console.log("Light mode is on");
        // }
    }


    return (
        <div>
            {darkModeOn ? darkMode : lightMode}
            <button onClick={handleDarkModeClick}>Click Me</button>
        </div>
    );
}