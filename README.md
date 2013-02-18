[![Build Status](https://travis-ci.org/socramob/algorithms-and-data-structures.png)](https://travis-ci.org/socramob/algorithms-and-data-structures.png)
Algorithms and Data Structures
===========================================

This is a collection of implementations of standard algorithms and data structures taught at introductory CS courses.

The following principles guided our implementation:
  * Maximize comprehensibility.
  * Name as many concepts explicitly as possible.
  * Do not abbreviate variable or method names.
  * Do not use comments to explain _what_ the code does or _how_. This is better done in source code by choosing _intent-revealing names_ and appropriate structures. Use comments to explain _why_ a specific implementation was used.
  * Provide an extensive set of regression tests, preferably by employing _Test-Driven Development_.
  * Favor objects over primitive data types, e.g. use `Integer` instead of `int` and use `List` instead of bare arrays.
  * Minimize duplication.
  * Program defensively; the environment may try to corrupt our code. Prevent problems by checking parameters and giving meaningful
    exception descriptions.
  * We try to provide a self-contained code base. Because this is intended for programming novices, we strive for minimizing dependencies
    to any libraries, be it the language SDK or especially third-party libraries.
  * Maximizing comprehensibility requires trading performance and/or memory requirements sometimes.


Resources
---------

  * [Robert Sedgewick, Kevin Wayne: Algorithms, 4th Edition](http://algs4.cs.princeton.edu/home/)
