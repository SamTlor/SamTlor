// spread can be used for many things such as copying an object
const order = {
    id: 1,
    username: "sam",
    item: "pizza",
    price: "$30"
};

const amendedOrder = {
    ...order,
    item: "sandwich"
}

// if there are lots of props for a component you can store them in an object and use the spread operator
return <Order {...order} />