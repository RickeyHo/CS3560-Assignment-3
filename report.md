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

Factory Pattern:
The Factory pattern was used in implementing the version history feature of my program. Each time the 'Save to history' button is pressed, my program calls a method which uses a Factory to obtain a new Version object that stores that iteration of the writing with timestamps, and is of the correct type (draft or polished).

## OOP Pillars

Encapsulation was used throughout the program. For example, in the WritingSessions object the list containing the timestamps of all the previous saves and the hashmap storing the history is declared as private and when another object requests this list, a clone is returned in order to ensure that this list is not interferred with.

Inheritance was used in order to improve the GUI. For example, the LocalDateTimeTable used in the GUI so that the user can select a version in the version history that they want to recover, extends JTable and overrides the prepare renderer method so that I could have greater control over and improve how the date and time is displayed in the GUI.

Polymorphism was used as I overloaded the getSave() method in my WritingSessions object so that it can either take a LocalDateTime timestamps object to get the corresponding save or an int representing the index, so that I can get the ith save in the version history.

The principle of abstraction was used with the wrapper class I created for the API, which abstracted away the details of the OpenAI api that was not relevant to my program, so that I could more easily and cleanly implement the GUI.



## AI Usage (BE HONEST!)
AI was used only to help rewrite this section into the correct format. The underlying content and explanations are my own writing.

## Time Spent
Time spent: 10 hours
