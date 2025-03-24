# Dining-philosophers-problem
the dining philosophers problem is an example problem often used in concurrent algorithm design to illustrate synchronization issues and techniques for resolving them.
<h1>Problem Description</h1>

<p>Five philosophers dine together at the same table. Each philosopher has their own plate at the table. There is a fork between each plate. The dish served is a kind of spaghetti which has to be eaten with two forks. Each philosopher can only alternately think and eat. Moreover, a philosopher can only eat their spaghetti when they have both a left and right fork. Thus two forks will only be available when their two nearest neighbors are thinking, not eating. After an individual philosopher finishes eating, they will put down both forks. The problem is how to design a regimen (a concurrent algorithm) such that any philosopher will not starve.</p>

<h2>Problems</h2>
<p>The problem was designed to illustrate the challenges of avoiding deadlock for these behaviours:</p>
<ul>
  <li>think unless the left fork is available; when it is, pick it up</li>
  <li>think unless the right fork is available; when it is, pick it up</li>
  <li>when both forks are held, eat for a fixed amount of time</li>
  <li>put the left fork down</li>
  <li>put the right fork down</li>
  <li>repeat from the beginning</li>
</ul>
