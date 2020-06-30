# P0-TrafficAnimation

## Information

- Authors:
	- Jason Dudley
	- BSU CS 121 instructors
- Course: CS121 Section 2
- Semester: Spring 2020
- Last Version Published: February 13, 2020

## Description

This animated ocean scene features background elements and moving objects which interact depending on position.

When bait and fish cross paths, boat and fish stop travelling and confirmation is displayed.

## Compiling & Running

### Compiling

```
$ javac TrafficAnimation.java
```

### Run Compiled Class

```
$ java TrafficAnimation
```

Animation will begin immediately upon running compiled class.

## Grading Criteria Guide

- Moving Vehicle (Boat)
	- Minimum 4 shapes
		- Hull (rectangle + polygon + oval)
		- Cabin (rectangle + polygon)
		- Bridge (rectangle + polygon)
		- Angler (rectangle + oval + arc + line)
	- Scales proportionately
- Vehicle Loops
	- Boat travels slightly offscreen on both edges to prevent flash appearance
	- Fish turns around and reverses direction (offscreen)
- Avatar Observer
	- Island (arc + rectangle + oval)
	- Fish (polygon + line)
- Minimum 5 Methods
	- DrawArc
	- DrawLine
	- DrawRect
	- FillArc
	- FillOval
	- FillPolygon
	- FillRect
- Text Displayed
	- Boat name (scaled)
- Minimum 3 Colors
	- Custom water color
	- Custom water accent
	- Custom island color
	- Custom beach color
	- Custom palm trunk
	- Custom palm fronds
	- Custom fish color
	- Custom fish accent
- Resizing Handled Appropriately

## Sources Used

Project based upon existing code created by Boise State University's CS 121 instructors.
