// the greatest strength of React is CONTAINMENT and SPECIALIZATION
// some components don't know what their children will be ahead of time
// sidebars and dialogue boxes will claim an area of the website as generic boxes
// one component will define the styling and pass children to itself like Alert below

// // additional resources
// https://chakra-ui.com/
// https://kentcdodds.com/blog/compound-components-with-react-hooks
// https://react.dev/reference/react/Fragment


const Button = ({ children, backgroundColor }) => {
    return <button style={{ backgroundColor }}>{children}</button>;
}

const Alert = ({ children }) => {
    return (
        <>
            <div className="Overlay" />
            <div className="Alert">{children}</div>
        </>
    )
}

const DeleteButton = () => {
    return <Button backgroundColor="red">Delete</Button>
}

export default function App() {
    return (
        <div className="App">
            <header>Little Lemon Restaurant</header>

            <Alert>
                <h4>Delete account</h4>
                <p>are you sure?</p>
                <DeleteButton />
            </Alert>
        </div>
    )
}