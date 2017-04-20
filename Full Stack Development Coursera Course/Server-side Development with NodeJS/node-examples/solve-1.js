var rectSolver = require('./rectangleSolver');

// function solveRect(l, b) {
//     console.log("Solving for rectangle with l = " + l + " and b = " + b);

//     if (l < 0 || b < 0) {
//         console.log("Rectangle dimensions sloud be greater then zero: l = " + l + ", and b = " + b);
//     } else {
//         console.log("The area of a rectangle of dimensions length = " + l + " and breadth = " + b + " is "
//         + rect.area(l, b));
//         console.log("The perimeter of a rectangle of dimensions length = " + l + " and breadth = " + b + " is "
//         + rect.perimeter(l, b));
//     }
// };

rectSolver.solve(2, 4);
rectSolver.solve(3, 5);
rectSolver.solve(-3, 5);
