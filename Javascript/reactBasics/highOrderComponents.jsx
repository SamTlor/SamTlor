import { useState, useEffect } from "react";

// functions that are very reusable 
// they can take in data and a function to return a wrapped component
// rules:
//      never mutate a component inside the HOC
const HOC = (WrappedComponent) => {
    // Don't do this and mutate the original component
    WrappedComponent = () => {
    };
}

//      pass unrelated props through to the wrapped component
const withMousePositionExample = (WrappedComponent) => {
    const injectedProp = {mousePosition: {x: 10, y: 10}};

    return (originalProps) => {
        return <WrappedComponent injectedProp={injectedProp} {...originalProps} />;
    };
};

//      maximize composability
//          Sometimes, HOCs can accept additional arguments that act as extra configuration determining the type 
//          of enhancement the component receives.

//      don't use HOCs inside other components
const Component = (props) => {
    // This is wrong. Never do this
    const EnhancedComponent = HOC(WrappedComponent);
    return <EnhancedComponent />;
};
const EnhancedComponent = HOC(WrappedComponent);
const RealComponent = (props) => {
    // This is the correct way
    return <EnhancedComponent />;
};

// additional resources
// https://react.dev/learn/manipulating-the-dom-with-refs









// it is a naming convention to use "with" in front of function name when creating a HOC
// WrappedComponent is PanelMouseLogger or PointMouseLogger
const withMousePosition = (WrappedComponent) => {

    // props would be "color" if i ever did something like: <PointMouseTracker color="red" />
    return (props) => {
        const [mousePosition, setMousePosition] = useState({x: 0, y: 0});
        useEffect(() =>{
            const handleMousePositionChange = (e) => {
                setMousePosition({
                    x: e.clientX,
                    y: e.clientY
                })
            }

            // this event listener will be turned on every time the component is rendered
            // whenever it stops being rendered it will remove it 
            window.addEventListener("mousemove", handleMousePositionChange);
            return () => {
                window.removeEventListener("mousemove", handleMousePositionChange);
            }
        }, []);

        return(
            <WrappedComponent {...props} mousePosition={mousePosition} />
        );
    }
}

const PanelMouseLogger = ({ mousePosition, color }) => {
    if(!mousePosition){
        return null
    } 
    return (
        <div className="BasicTracker">
            <p style={{color:color}}>Mouse Position:</p>
            <div className="Row">
                <span>x: {mousePosition.x}</span>
                <span>y: {mousePosition.y}</span>
            </div>
        </div>
    );
}

const PointMouseLogger = ({ mousePosition }) => {
    if(!mousePosition){
        return null
    } 
    return(
        <p>({mousePosition.x}, {mousePosition.y})</p>
    );
}








// there's also the render version of the above
// it does the same thing but slightly simplified
// it's much more common in modern react
const MousePositionRenderVersion = ({ render }) => {
    const [mousePosition, setMousePosition] = useState({
        x: 0,
        y: 0,
    });

    useEffect(() => {
        const handleMousePositionChange = (e) => {
            setMousePosition({
                x: e.clientX,
                y: e.clientY
            })
        };

        window.addEventListener("mousemove", handleMousePositionChange);
        return () => {
            window.removeEventListener("mousemove", handleMousePositionChange);
        };
    }, []);

    return render({ mousePosition });
};

const PanelMouseLoggerRenderVersion = ({ color }) => {
    return (
        <div className="BasicTracker">
            <p style={{ color: color }}>Mouse position:</p>
            <MousePositionRenderVersion
                render={({ mousePosition }) => (
                    <div className="Row">
                        <span>x: {mousePosition.x}</span>
                        <span>y: {mousePosition.y}</span>
                    </div>
                )}
            />
        </div>
    );
};

const PointMouseLoggerRenderVersion = () => {
    return (
        <MousePositionRenderVersion
            render={({ mousePosition }) => (
                <p>({mousePosition.x}, {mousePosition.y})</p>
            )}
        />
    );
};



export default function App() {
    const PanelMouseTracker = withMousePosition(PanelMouseLogger);
    const PointMouseTracker = withMousePosition(PointMouseLogger);
    
    return(
        <div className="App">
            <header className="Header">Little lemon</header>
            <PanelMouseTracker color="red"/>
            <PointMouseTracker />


            <PanelMouseLoggerRenderVersion color="red" />
            <PointMouseLoggerRenderVersion />
        </div>
    );
}






// // ADDITIONAL RESOURCES
// https://github.com/downshift-js/downshift
// https://legacy.reactjs.org/docs/render-props.html
// https://legacy.reactjs.org/docs/higher-order-components.html
// https://legacy.reactjs.org/docs/forwarding-refs.html#forwarding-refs-in-higher-order-components