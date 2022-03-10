# CS5004
## Assignment 6: Easy Animator, Part 1 (of 3)
### Felix Nampanya, Carlos Munoz

**Objective:**

This application will show animations generated manually or using any other program, unrelated to the main application.
It is build using the MVC model on Java programming language.

**Description**

We dived the model in three parts. The animation model will use two different objects to hande the animations information: one with the shapes that will be rendered in the canvas, the other with the motion attributes: move, change color, show and re-escale the figure by a fixed factor or to a defined width and height for every figure.


**Implementation**

The model is based on three main packages:

- The **shape** package, which implements simple geometric figures as objects. This figures are the basis for our animation model. Every figure has the following characteristics:
1. *id* the string containing the id name of the shape object
2. *x* coordinate of the reference point of the shape
3. *y* coordinate of the reference point of the shape
4. *width* width of the figure
5. *height* height of the figure
6. *color* color of the figure using Java's Color ENUM.

- The **motion** package, which implements all the actions that a figure or shape might perform. This motion actions are subject to time parameters which signal the starting and ending time of the effect. These actions modify directly the shape objects. Every motion object has the following characteristics:
1. *shapeId* of the target shape or figure
2. *startTime* the time to begin applying the motion action
3. *endTime* the time to end applying the motion action

- The **model** package, which implements the Animated Model. This package stores the shape and motion objects in two separate ListArray objects. The model have a method *getDeclarativeAnimation* which returns a string with the description of the animation.



