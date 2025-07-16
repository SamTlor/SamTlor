import { useState, useEffect } from "react"; 
 

// this gets a CORS error but you get it
export default function App() { 
    const [btcData, setBtcData] = useState({}); 


    
    // in order to get data from the third party a useEffect is necessary
    // uses setBtcData as soon as it can
    useEffect(() => { 
        fetch(`https://api.coindesk.com/v1/bpi/currentprice.json`) 
        .then((response) => response.json()) 
        .then((jsonData) => setBtcData(jsonData.bpi.USD)) 
        .catch((error) => console.log(error)); 
    }, []); 
    
    // until then the return will be blank
    return ( 
        <> 
            <h1>Current BTC/USD data</h1> 
            <p>Code: {btcData.code}</p> 
            <p>Symbol: {btcData.symbol}</p> 
            <p>Rate: {btcData.rate}</p> 
            <p>Description: {btcData.description}</p> 
            <p>Rate Float: {btcData.rate_float}</p> 
        </> 
    ); 
} 