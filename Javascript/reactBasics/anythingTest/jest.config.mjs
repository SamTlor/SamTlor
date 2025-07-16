import { fileURLToPath } from 'url';
import { dirname, resolve } from 'path';

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

export default {
    // simulates the browser
    testEnvironment: 'jest-environment-jsdom', 

    // makes sure that things like toBeInTheDocument() work
    setupFilesAfterEnv: ['./jest.setup.js'],
    
    // allows Jest to understand JSX via Babel
    transform: {
        '^.+\\.jsx?$': 'babel-jest', 
    },

    // allows jest to not break when it sees css files
    moduleNameMapper: {
        '\\.css$': resolve(__dirname, './__mocks__/styleMock.js'),
    }
};