// forEach: first parameter is the element (i, elem, fruit of fruits, etc) the second is the index
const fruits = ['kiwi','mango','apple','pear'];
function appendIndex(fruit, index) {
    console.log(`${index}. ${fruit}`);
}
fruits.forEach(appendIndex);

console.log();
fruits.forEach( function(veggie, index) {
    console.log(`${index}. ${veggie}`);
});

console.log();
fruits.forEach((fruit, index) => {
    console.log(`${index}. ${fruit}`);
})



// filter: returns an array that removes elements from an array
console.log();
const nums = [0,10,20,30,40,50];
const bigNums = nums.filter( function(num) {
    return num > 20;
})
console.log(bigNums);



// map: returns an array that modifies elements from an array
console.log();
const newNums = [0,10,20,30,40,50];
const modNums = newNums.map( function(num) {
    return num / 10
})
console.log(modNums);