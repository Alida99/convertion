This is a program that takes: a base between 2 and 64 inclusively and a number of positions (any arbitrary 64-bit integer; it could be 400,000,000,000) And outputs a count from 0 to the maximum value that can be supported given the number of specified positions. 
The program takes command line options like this: ./counter -b 52 -p 25. -b stand for the base and -p for the position. 
Eventually, it also accepts a third option “-i” that means increment.

If for instance, the program is passed “-i 5”, it should increment in steps of 5 instead of in steps of 1.
Examples : 
    1- ./counter -b 52 -p 25 -i 5 would output

        0000000000000000000000000
        0000000000000000000000005
        000000000000000000000000a
        000000000000000000000000f
        ....
        PPPPPPPPPPPPPPPPPPPPPPPPP
        
   2- ./counter 52 25 would output
   
        0000000000000000000000000
        0000000000000000000000001
        0000000000000000000000002
        0000000000000000000000003
        ....
        PPPPPPPPPPPPPPPPPPPPPPPPP
        
One can notice that:

Base 2 uses the symbols 0 and 1
Base 3 uses the symbols 0, 1, 2
…
Base 10 uses 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
Base 11 uses 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a
Notice that the case is important here. “a” and “A” are not the same
Base 12 uses 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b
…
Base 15 uses 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f
…
Base 27 uses 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, …, q
Base 60 uses 0, 1, …, 9, a, b, c, …, z, A, B, C, …, X
Base 64 uses 0, 1, …, 9, a, b, c, …, z, A, B, C, …, X, Y, Z, @, /



******************************************************************************************


# Instructions to compile and run the project

### First of all clone the git repository
***

## Compilation
1. Enter in the folder that contain Counter.Java
2. Open in the terminal
3. Type the following command line: 
    
    _javac Counter.java_

Everything will works well and you could execute

## Running 
1. Type the following command line any arguments you want:

    _java Counter arg arg_
2. For example: 

    -_java Counter 9 16 2_

    -_java Counter -p 9 -b 16 -i 2_

    * Spaces are importants
    * If you type 2 or 3 arguments, you have to follow this order : base, position, iteration. Obviously, in this case, you can enter only 2 arguments as base and position.
    * You are free to add options like -i, -p, -b respectively as iterator, position and base.
        
        * If you choose this case, to avoid any confusion, you have to specify options for each arguments.
    
    * Once again, it's obvious that you can only enter base and position options witch are required. Also, it's not a problem if you swap the options.


    ### ****Have fun converting your numbers !!****
