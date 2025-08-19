// Jest is a JavaScript test runner that lets you access an artificial DOM, it provides an approximation 
// of how the browser works. While jsdom is only an approximation of how the browser works, it is often 
// good enough for testing React components. 

// Add Jest with:
// npm install --save-dev jest babel-jest @babel/core @babel/preset-env @babel/preset-react @testing-library/react @testing-library/jest-dom
// npm install --save-dev @babel/core @babel/preset-env @babel/preset-react babel-jest
// npm install --save-dev jest-environment-jsdom

// Create a Babel config file called .babelrc that looks like this:
//      {
//        "presets": [
//          ["@babel/preset-env", { "targets": { "node": "current" } }],
//          ["@babel/preset-react", { "runtime": "automatic" }]
//        ]
//      }
// or a babel.config.js file that looks like this:
//      module.exports = {
//        presets: ['@babel/preset-env', '@babel/preset-react'],
//      };
// 
// Then create a Jest config file called jest.config.js that looks like this:
//      import { fileURLToPath } from 'url';
//      import { dirname, resolve } from 'path';
//      const __filename = fileURLToPath(import.meta.url);
//      const __dirname = dirname(__filename);
//      export default {
//          // simulates the browser
//          testEnvironment: 'jest-environment-jsdom', 
//          // makes sure that things like toBeInTheDocument() work
//          setupFilesAfterEnv: ['./jest.setup.js'],
//          // allows Jest to understand JSX via Babel
//          transform: {
//              '^.+\\.jsx?$': 'babel-jest', 
//          },
//          // allows jest to not break when it sees css files
//          moduleNameMapper: {
//              '\\.css$': resolve(__dirname, './__mocks__/styleMock.js'),
//          }
//      };
// 
// Update package.json scripts to make sure it has:
//      "scripts": {
//        "test": "jest"
//      }
// then run:
//      npm test



// React Testing Library is a set of utilities that let you test React components without relying on their 
// implementation details. React Testing Library is designed to fulfill all testing best practices out of 
// the box, so that you are able to focus on the business logic your tests need to run assertions on.  



import "./App.css";
export default function App() {
    return (
        <div className="App">
            <a href="https://littlelemon.com" className="App-link">
                Little Orange Restaurant
            </a>
        </div>
    )
}


// this would be a separate file called something like App.test.js
import { fireEvent, render, screen } from "@testing-library/react"
import App from "./App"

// test comes from jest. it doesn't need to be imported because this is a test file
// expect is also a global import
// toBeInTheDocument is NOT a built in jest function so it needs to be imported 
// at the top of every test file or a separate file called with "setupFilesAfterEnv in jest config
// import '@testing-library/jest-dom';
test("Renders a link that points to the little lemon webpage", () => {
    render(<App />);

    // this tests if "Little Lemon Restaurant" is on the screen
    const linkElement = screen.getByText("Little Lemon Restaurant");
    expect(linkElement).toBeInTheDocument();
});



// fireEvent is how you simulate clicks or inputs
describe("Feedback Form", () => {
    test("User is able to submit the form if the score is lower than 5 and additional feedback is provided", () => {
        const score = "3";
        const comment = "The pizza crust was too thick";
        const handleSubmit = jest.fn();
        render(<FeedbackForm onSubmit={handleSubmit} />);

        // /Score:/ is a regex 
        const rangeInput = screen.getByLabelText(/Score:/);
        fireEvent.change(rangeInput, { target: { value: score } });

        const textInput = screen.getByLabelText(/Comments:/);
        fireEvent.change(textInput, { target: { value: comment } });

        const submitButton = screen.getByRole("button");
        fireEvent.click(submitButton);
        expect(handleSubmit).toHaveBeenCalledWith({
            score,
            comment,
        });
    });
});



// ADDITIONAL RESOURCES
// https://testing-library.com/docs/react-testing-library/intro/
// https://jestjs.io/docs/getting-started
// https://martinfowler.com/articles/practical-test-pyramid.html