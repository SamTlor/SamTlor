// Deploy to GitHub Pages:

// After building your site, commit and push the generated dist folder to the gh-pages branch:

//     Install gh-pages as a dev dependency:

//     bash

// npm install gh-pages --save-dev

// Add a deploy script in package.json:

// json

// "scripts": {
//   "build": "vite build",
//   "deploy": "gh-pages -d dist"
// }

// Run the deployment:

// bash

//         npm run deploy

// This will deploy your website to https://<your-username>.github.io/<repository-name>/.