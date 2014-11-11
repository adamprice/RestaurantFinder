1. How long did you spend on the coding test? What would you add to your solution if you had more time? If you didn't spend much time on the coding test then use this as an opportunity to explain what you would add.
--
The test took me about 4 hours to complete. 

The absolute first thing I'd do is add unit tests. Normally I try and practise test driven development, where I write the tests first and then get them to pass when writing the application code. I would also have preferred to use a dependency injection framework like Dagger, to make testing easier in the long term.

I'd have also liked to add some additional features. Currently when entering the outcode, it checks the input for a letter, letter, number or letter, letter, number, number sequence. It would be better if the applicaton could query a postcode database and only accept valid outcodes. This could offer the opportunity to offer suggestions to the user while they're entering their outcode. Also, it would be interesting to attempt automatically filling the outcode input field with the current outcode the user is in using GPS or from the user's own contact details if present on their device.

I believe there's also potential to implement a form of local caching. The application could cache results for a given outcode for a certain time. This might reduce load on the server if users regularly search for the same outcode and there's a low rate of change in the results.

2. What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that shows how you've used it.
--
As I mainly develop for Android, the latest version of Java (mostly) supported on Android is Java 7. The new feature in Java 7 that I've used the most is the ability to switch on a String.

I've recently been working on a custom protocol for communication between an Android application and a handheld device. The protocol commands are based on 4 character sequences such as "WFDB". When receiving data over a Bluetooth serial port connection and the command is parsed, it's been much cleaner using a switch than a number of if-else statements.

Here's an example:

    String command = message[0];
    
    switch (command) {
        case "WFAA": 
            doSomethingRelatedToWFAA();
		    break;
        case "WFAB": 
    	    doSomethingRelatedToWFAB();
		    break;
    }
	
3. How would you track down a performance issue in an application? Have you ever had to do this?
--
For Android, my first approach would be to use either a method profiling tool or take a heap dump and analyse it, normally Eclipse Memory Analyser, depending on the situation.

I don't have much experience diagnosing a performance issue due to inefficient code, but I do have some experience in searching for and diagnosing memory leaks. I recently encountered an issue with an Android application that I've been working on where data being received and parsed over Bluetooth wasn't being cleared properly. Unfortunately, it took a long time for the problem to manifest itself (at least 24 hours continuous use), which made it an annoying problem to fix.
	
4. How would you improve the JUST EAT APIs that you just used?
--
It would be good if you could be more specific when you're requesting restaurant data. This could potentially make communication with the Just-Eat server more efficient. For example, if the user knew what kind of food they wanted, you could supply a cusine type when requesting and then only return restaurants that match that cuisine type. As another example, a user might only want to see restaurants that currently have deals on or deliver, so these could also be useful parameters to set in a request.

Potentially, it could also support giving multiple parameters at once and maybe even AND/OR logic.
	
5. Please describe yourself using JSON.
--
    {
      "Name": "Adam Price",
      "Occupation": "Software Engineer",
      "Education" : {
	      "University" : { 
		      "Name" : "Cardiff University",
		      "Degree" : "BSc Computer Science"
	      },
	      "Secondary school" : { 
		      "Name" : "Ysgol Gyfun Cwm Rhymni",
		      "ALevelCount" : 4, 
		      "GCSECount" : 12 
	      }
      },
      "Instruments": [
          "Guitar",
          "Drums"
      ],
      "Likes" : [
	      "Superhero movies",
	      "House music",
	      "Computer games"
      ],
      "Dislikes" : [
	      "Baked beans"
      ],
      "JustEatUser" : true
    }