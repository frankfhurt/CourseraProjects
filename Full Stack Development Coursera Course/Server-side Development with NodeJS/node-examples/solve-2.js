var rect = require('./rectangleCallback');

rect(l, b, function(err, rectangle) {
    if (err) {
        console.log(err);
    } else {
         console.log("The area of a rectangle of dimensions length = " + l + " and breadth = " + b + " is "
         + rectangle.area(l, b));
         console.log("The perimeter of a rectangle of dimensions length = " + l + " and breadth = " + b + " is "
         + rectangle.perimeter(l, b));
    }
});

rect(2, 5);