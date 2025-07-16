const data = [
    {
        id: "1",
        title: "Tiramisu",
        description: "The best tiramisu in town",
        image: "https://picsum.photos/200/300/random",
        price: "$5.00"
    },
    {
        id: "2",
        title: "Lemon Ice Cream",
        describe: "Mind blowing taste",
        image: "https://picsum.photos/200/300/random",
        price: "$4.50"
    }
];

// pulling out values from the given data
const pullItems = data.map(item => {
    return{
        content: `${item.title} - ${item.description}`,
        price: item.price,
    }
});

// displaying the data
const displayItems = data.map(item => {
    const itemText = `${item.title} - ${item.price}`;
    return <li>{itemText}</li>
})

export default function App(){
    console.log(pullItems);
    return (
        <div>
            <ul>
                {displayItems}
            </ul>
        </div>
    )
}