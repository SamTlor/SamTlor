// cloneElement allows a parent component to modify, add to, and extend the functionality of children properties

// Children.map is very similar to the normal map function
// it envokes a function on every child contained in its first variable
// you can add things like className, onClick calls or any other prop

import { Children, cloneElement } from "react"

const Row = ({ children, spacing }) => {
    const childStyle = {
        marginLeft: `${spacing}px`,
    }

    return (
        <div className="Row">
            {Children.map(children, (child, index) => {
                return cloneElement(child, {
                    style: {
                        ...child.props.style,
                        ...(index > 0 ? childStyle : {})
                    }
                })
            })}
        </div>
    )
}

export default function App() {
    return (
        <div className="App">
            <Row spacing = {32}>
                <p>Pizza Margarita</p>
                <p>2</p>
                <p>30$</p>
                <p>18:30</p>
                <p>John</p>
            </Row>
        </div>
    )
}