Cole Vick

Animator:
This Animator model only has three public methods. 
The first (printInstructions) displays a high level definition of a given model if it’s been instantiated. 
The second (startAnimation) starts the animation given a valid list of shapes, list of commands on
those shapes, and a time multiplier.
The third (move) will eventually be called from the controller and will take a given command and a
time. The Command will call its own method to create where the given shape of the command
ought to be at the given time.


Shapes:
There are only two shapes: Rectangle and Oval. They have x and y coordinates, color, a name, and
the time they appear and disappear. These shapes can move to different coordinates, change
colors, and scale larger or smaller. These are called commands.


Commands: 
There are three commands: Change, Move, and Scale. They have a shape to operate on, start and
end times and then change has an end goal color and move and scale have two end goal double
(coordinates and width and height respectively). The commands get called with a given time and
calculate where in the current command the shape should be put.


Invariants:
The shapes get treated as constants even though they mutate throughout the program. 
Also, I’m counting on getting a list of shapes and list of commands for this program to run.
Cannot create different shapes other than rectangles and ovals.
Commands always operate on a shape.
Commands get called in successive order. (t=0->t=1->t=2…… not t=1->t=30->t=12)


Choice:
I chose this implementation because I felt it lent itself well to the problem. I can easily add
 shapes and commands whenever I need to by extending their respective abstract classes and
 implementing the details. I can easily start the animation with just a list of shapes, list of
 commands and a time multiplier. I can write succinct code that operates on an entire list of
 abstracted objects and worry about the implementation in the background when I get to it (this
 came in very handy when printing out the string representation). The ugliest design is probably
 in the AShape with respect to all the getters and setter, but I felt this was necessary because
 of how much I’m mutating the objects while the program is running. Testing this implementation
 was also fairly easy because I could use the main model to test some of the private methods in
 the Abstract classes. Also, this design cuts down on a lot of duplicated code that might be
 generated in others.