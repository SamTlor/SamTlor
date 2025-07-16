// it's like a super power useState function
// useState is better for primitive data types like strings, numbers and booleans
// it has an initial state AND a reducer function
// the reducer function takes in state and 

import { useReducer } from "react";

const reducer = (state, action) => {
    console.log(action);
    if (action.type === 'buy_ingredients') return {money: state.money - 10};
    if (action.type === 'sell_a_meal') return {money: state.money + 10};
    if (action.type === 'celebrity_visit') return {money: state.money + 5000};
    return state;
}

export default function App() {
    const initialState = {money: 100}
    const [state, dispatch] = useReducer(reducer, initialState);

    return(
        <div className="App">
            <h1>Wallet: {state.money}</h1>
            <div>
                <button onClick={() => dispatch({type: 'buy_ingredients'})}>Shopping for veggies!</button>
                <button onClick={() => dispatch({type: 'sell_a_meal'})}>Serve a meal!</button>
                <button onClick={() => dispatch({type: 'celebrity_visit'})}>Celebrity visit!</button>
            </div>
        </div>
    );
}


// additional resources
// https://react.dev/reference/react/useReducer