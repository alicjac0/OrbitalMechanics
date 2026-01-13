# Orbital Mechanics Simulation

This project is a simple **2D Newtonian gravity simulation** written in Java using JavaFX for visualization.
It numerically simulates gravitational interactions between multiple bodies using basic vector mechanics.
Body size is proportional to the square root of its mass,
allowing visual distinction between massive and light bodies.

This version visualizes the **3-body problem**, showing the chaotic orbits of three bodies under mutual gravitational forces.

**Built with JavaFX in Java 19.**

## Features
- Newtonian gravitational force
- Multiple interacting bodies
- Visualization using JavaFX
- Demonstration of unstable and chaotic behavior

## About the Three-Body Problem

The simulation demonstrates a key property of the three-body problem:
*Although the equations of motion are deterministic,
there is no general analytical solution for three interacting bodies.*

In certain configurations, the system may appear stable at first, forming temporary orbits.
Over time, small numerical errors and mutual gravitational interactions accumulate,
leading to instability, orbital decay, or collisions.


## How to Run

1. Clone the repository
2. Make sure Java 19 and JavaFX SDK 19 are installed
3. Run the `Main` class to launch the simulation

