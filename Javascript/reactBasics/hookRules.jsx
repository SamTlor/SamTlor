// you can only call hooks from a component function
// you can only call hooks at the top level. Not in an if statement or something similar
//      use the if statement inside the useEffect instead
// you can make multiple state or effect hooks but only in the same sequence


// fetch is a way to access browser functionality that is outside of JavaScript
// it will finish this code whenever the api returns which will almost certainly be after second thing
console.log("first thing")
fetch('https://randomuser.me/api/?results=1')
    .then(response => response.json())
    .then(data => console.log(data))
console.log("Second thing")


// // additional resources
// https://legacy.reactjs.org/docs/hooks-rules.html
// https://developer.mozilla.org/en-US/docs/Learn_web_development/Extensions/Async_JS/Promises
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/async_function