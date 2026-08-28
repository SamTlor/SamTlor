import ContactBtn from './ContactBtn';
import MenuItem from './MenuItem';

function Menu (){

    return (<>
        <MenuItem title={"Hello"}/>
        <MenuItem title={"About"}/>
        <MenuItem title={"Projects"}/>
        <ContactBtn title={'Contact Me'} />
        </>);
}

export default Menu;