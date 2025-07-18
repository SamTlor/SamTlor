// Task 1
// WRITE YOUR CODE HERE - Create the logDairy function and use a for...of loop to log each item in the dairy array
var dairy = ['cheese', 'sour cream', 'milk', 'yogurt', 'ice cream', 'milkshake'];
function logDairy() {
    for (i of dairy) {
        console.log(i);
    }
}
logDairy();



// Task 2
// WRITE YOUR CODE HERE - Create the birdCan function and use a for...of loop to log bird object's own properties
const animal = {  
    canJump: true  
};  

const bird = Object.create(animal);  
bird.canFly = true;  
bird.hasFeathers = true;
function birdCan(){
  for (ability of Object.keys(bird)) {
      console.log(`${ability}: ${bird[ability]}`)
  }
}
birdCan();



// Task 3
// WRITE YOUR CODE HERE - Create the animalCan function and use a for...in loop to log all bird properties, including inherited ones
function animalCan() {
    for (ability in bird) {
        console.log(`${ability}: ${bird[ability]}`);
    }
}
animalCan();