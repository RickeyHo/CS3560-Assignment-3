# Project Report

## Challenges I Faced
Challenge: Implementing version history with O(1) access  
One challenge I faced was figuring out how to implement a version history feature for my program while ensuring that accessing any particular iteration would run in O(1) time. To accomplish this, I used a HashMap to store all versions, with each version keyed by the time it was saved. This makes access instantaneous.  
To maintain a chronological record for the user, I also stored all saved timestamps in an ArrayList so the user can navigate the timeline of available iterations.

## Design Pattern Justifications
Singleton Pattern:  
I implemented the Singleton pattern for the simplified wrapper class I created for the OpenAI API. Since I only ever want a single instance of this wrapper, I declared it as an enumeration, which guarantees that it behaves as a proper singleton in Java.

Observer Pattern:  
The Observer pattern was already naturally incorporated through the Swing GUI, specifically through the ActionListener class operating on the main event thread. This allowed the interface to respond to user actions in an event-driven way.

## AI Usage (BE HONEST!)
AI was used only to help rewrite this section into the correct format. The underlying content and explanations are my own writing.

## Time Spent
Time spent: 3 hours
