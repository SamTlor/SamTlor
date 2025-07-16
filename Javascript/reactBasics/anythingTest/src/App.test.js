// this is a separate App.test.js file
import { render, screen } from "@testing-library/react"
import App from "./App"



test("Renders a link that points to the little lemon webpage", () => {
    render(<App />);
    const linkElement = screen.getByText("Little Lemon Restaurant");
    expect(linkElement).toBeInTheDocument();
})