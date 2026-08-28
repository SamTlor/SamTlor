import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {

    // screen size
    screens: {
      'mobile': {'max': '1023px'},
      'desktop': {'min': '1024px'},
    },

    // colors and fonts
    extend: {
      colors: {
        // from my tie and a color that complements it using https://www.canva.com/colors/color-wheel/
        tie: '#9bbde7',
        textHighlight: '#e7c59b',

        // old colors
        lightcyan: '#84ffff', 
        yellow: '#fde992',
        gradientLeft: '#8e24aa',
        gradientRight: '#1e88e5',

        // new nongradient colors
        about: '#111827',
        projects: '#0b1220',
        footer: '#020617'
      },
      
      // color gradients
      backgroundImage: {
        // greetings page background diagonals
        greetings: 'linear-gradient(135deg, #0f172a 0%, #1e293b 100%)',

        cosmos: 'linear-gradient(to right, #1e293b, #334155)',
        aqua:   'linear-gradient(to right, #134e4a, #0f766e)',
        sunset: 'linear-gradient(to right, #7c2d12, #9a3412)',
      },
      backdropBlur: {
        xs: '2px',
      },
      fontFamily: {
        sans: ['Poppins', 'sans-serif'],
        display: ['Playfair Display', 'serif'],
        mono: ['Fira Code', 'monospace'],
      },
    },
  },
  plugins: [],
};
export default config;
