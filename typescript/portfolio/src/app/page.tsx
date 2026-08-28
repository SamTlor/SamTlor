import About from "@/component/layout/About";
import Footer from "@/component/layout/Footer";
import Hello from "@/component/layout/Hello";
import Navbar from "@/component/layout/Navbar";
import Projects from "@/component/layout/Projects";
import './globals.css';
import BurgerMenu from "@/component/menu/BurgerMenu";
import { GlobalStateProvider } from "@/contexts/GlobalStateContext";
import Modal from "@/component/layout/Modal";

import { getProjects } from "./utils";


export default function Home() {
  return (
    <GlobalStateProvider >
      <Navbar />
      <Modal />
      <BurgerMenu />
      <Hello />
      <About />
      <Projects />
      <Footer />
    </GlobalStateProvider>
  );
}
