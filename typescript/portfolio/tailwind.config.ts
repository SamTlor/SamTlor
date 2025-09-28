// import type { Config } from "tailwindcss";

// const config: Config = {
//   content: [
//     "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
//     "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
//     "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
//     "./src/**/*.{js,jsx,ts,tsx}",
//   ],
//   theme: {
//     screens: {
//       'mobile': {'max': '1023px'},
//       'desktop': {'min': '1024px'},
//     },
//     extend: {
//       colors: {
//         lightcyan: '#84ffff',
//         gradientLeft: '#8e24aa',
//         gradientRight: '#1e88e5',
//       },
//       animation: {
//         scalepulse: "scalepulse 8s ease-in-out infinite",
//         moveFade: "moveFade 2s linear infinite"
//       },
//       keyframes: {
//         scalepulse: {
//           '0%': { "scale": "1" },
//          '50%': { "scale": "1.05" },
//          '100%': { "scale": "1" },
//         },
//         moveFade: {
//           '0%': { 
//             opacity: "0",
//             transform: "rotate(45deg) translate(-10px, -10px)",
//           },
//           '50%': { 
//             opacity: "1",
//           },
//           '100%': {    
//             opacity: "0",
//             transform: "rotate(45deg) translate(10px, 10px)",
//           }
//         }
//       },
   
//     },
//   },
//   plugins: [],
// };
// export default config;



import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    screens: {
      'mobile': {'max': '1023px'},
      'desktop': {'min': '1024px'},
    },
    extend: {
      colors: {
        lightcyan: '#84ffff',
        gradientLeft: '#8e24aa',
        gradientRight: '#1e88e5',
        sunset: 'linear-gradient(to right, #ff7e5f, #feb47b)',
        cosmos: 'linear-gradient(to right, #8e2de2, #4a00e0)',
        aqua: 'linear-gradient(to right, #13547a, #80d0c7)',
      },
      boxShadow: {
        'glow': '0 0 20px rgba(142, 36, 170, 0.6)', // matches gradientLeft
      },
      backdropBlur: {
        xs: '2px',
      },
      fontFamily: {
        sans: ['Poppins', 'sans-serif'],
        display: ['Playfair Display', 'serif'],
        mono: ['Fira Code', 'monospace'],
      },
      animation: {
        scalepulse: "scalepulse 8s ease-in-out infinite",
        moveFade: "moveFade 2s linear infinite"
      },
      keyframes: {
        scalepulse: {
          '0%': { "scale": "1" },
         '50%': { "scale": "1.05" },
         '100%': { "scale": "1" },
        },
        moveFade: {
          '0%': { 
            opacity: "0",
            transform: "rotate(45deg) translate(-10px, -10px)",
          },
          '50%': { 
            opacity: "1",
          },
          '100%': {    
            opacity: "0",
            transform: "rotate(45deg) translate(10px, 10px)",
          }
        }
      },
   
    },
  },
  plugins: [],
};
export default config;
