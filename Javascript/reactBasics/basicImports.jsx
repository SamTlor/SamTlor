import "./App.css";
import basicImportsCard from "./basicImportsCard.js"

export default function App() {
  return (
    <div>
      <h1>Task: Add three Card elements</h1>
      <basicImportsCard h2="First card's h2" h3="First card's h3" />
      <basicImportsCard h2="Second card's h2" h3="Second card's h3" />
      <basicImportsCard h2="Third card's h2" h3="Third card's h3"/>
    </div>
  );
};