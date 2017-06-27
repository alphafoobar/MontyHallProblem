[![Build Status](https://travis-ci.org/alphafoobar/MontyHallProblem.svg?branch=master)](https://travis-ci.org/alphafoobar/MontyHallProblem) [![codecov](https://codecov.io/gh/alphafoobar/MontyHallProblem/branch/master/graph/badge.svg)](https://codecov.io/gh/alphafoobar/MontyHallProblem)

# Monty Hall Problem

This simple application is an exploration into a solution to the [Monty Hall problem](http://montyhallproblem.com/).
Though the application explores the Monty Hall problem, this fork attempts to illustrate how 
improving the readability of the code base can make the solution easier to understand. Even with 
minimal commenting.

The main class is `MontyHallProblem` and can be run without providing arguments.

## Running this application from the command line

```bash
mvn exec:java -Dexec.mainClass="MontyHallProblem"
```

## Running alternatively sized execution

You must edit the constants in the `MontyHallProblem` class:
  1. `NUMBER_OF_TRIALS`:  A larger number provides a higher confidence in the statistical result.  
  2. `NUMBER_OF_DOORS`:  3 is the most common, but any number will work.

## What does this program do?
1. Loops through the specified number of trials.
   1. Creates a structure representing the doors, where only one hides a **car**.
   2. A random door is selected by the contestant as their original choice.
   3. A random door that is a goat is revealed to the contestant.
   4. A random door is selected by the contestant as their _switch_ selection.
   5. A running count of choice outcomes is kept.
2. Finally a summary of the outcomes is printed.

# Background to this implementation
*From the June 2015 [Philly Java Users Group](https://www.meetup.com/PhillyJUG/) Meeting.* 

> We had a side discussion on code commenting a few people wanted the discussion documented for future reference. 

[@mgeiser](https://github.com/mgeiser) added the slide deck and created this example repo.
* _The slides of interest regarding commenting are the last 5 slides of the deck._
* An alternative school of thought is found with [software artisanship](ARTISANAL_COMMENTS.md).

## Further reading
1. http://montyhallproblem.com/
2. http://en.wikipedia.org/wiki/Monty_Hall_problem
