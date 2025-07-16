import { createContext, useContext, useState } from "react";

const ThemeContext = createContext(undefined);

export const ThemeProvider = ({ children }) => {
    const [theme, setTheme] = useState("light");

    return (
        <ThemeContext value={{
            theme,
            toggleTheme: () => setTheme(theme === "light" ? "dark" : "light")
        }}>
            {children}
        </ThemeContext>
    );
};

export const useTheme = () => useContext(ThemeContext);







// this is the file that would utilize the light/dark mode context
import "./Styles.css";
import { useTheme } from "../ThemeContext";

const Switch = () => {
  const { theme, toggletheme } = useTheme();
  return (
    <label className="switch">
      <input
        type="checkbox"
        checked={theme === "light"}
        onClick={toggletheme}
      />
      <span className="slider round" />
    </label>
  );
};

export default Switch;
