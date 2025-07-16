// props and state are both plain javascript objects that react uses to hold information
// props are passed to the component. 
// state is managed within the component. 

// if a component's attribute needs to be changed at some point then use state. otherwise props

// if a component only uses only props or state that is not inherited from other parent components
// you can use this to make the app render faster:
// export default React.memo(component);
// this is the updated version maybe check these websites
// https://react.dev/reference/react/memo
// https://react.dev/reference/react/useMemo





// context API is a faster way to pass state to components than from parent to child
// used for data that is considered global
import { createContext, useContext, useState } from "react";

const UserContext = createContext(undefined);

export const UserProvider = ({children}) => {
    const [user] = useState({
        name: "John",
        email: "John@gmail.com",
        dob: "01/01/2001"
    })

    // the double brackets are because i'm passing an object to the component
    // this is what allows components to subscribe to context changes
    return <UserContext.Provider value={{ user }}>{children}</UserContext.Provider>
}

// this is the way that components subscribe to the context changes
// this is a custom hook that wraps the use context hook
// now to use the user variable in other files all you need to type is:
// const { user } = useUser();
// but make sure it's in a component and not in the export default function's return
export const useUser = () => useContext(UserContext);






// this is what the app file that uses this should look like:
import './App.css'; 
import {useState} from "react"; 
import { UserProvider, useUser } from './helper';


const UserInfo = () => {
    const { user } = useUser();

    return (
        <p>user: {user.name}</p>
    )
}

export default function App() {
    return (
        <UserProvider>
            <div>
                <h2>Jello World</h2>
                <UserInfo />
            </div>
        </UserProvider> 
    )
}



