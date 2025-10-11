## Reflection
### Yang's reflection:
	1. I didn't check each method before moving to next one. Instead, I just pushed all the file to github and let Linpei check all of them, which later on we found out that it's a very ineffiencient and chaotic workflow.
	2. I didn't read document carefully, that caused a lot of error.
	3. We didn't utilize the interface well.
	4. determineStrength() and differentConsecutiveTypes() both look confusing, although they are the improved/remastered version. 
	5. extraOccurrence() was using O(n^2) method and also had a confusing logic, so now we reimplemented with frequency table and introduced constants to enhance readability.
	6. consecutiveSameChar() should have better approach: instead of checking how many 3 streaks of same char, check the length of consecutive same char should be a better solution, but I don't know how to do that in a O(n) way, I still keeped this confusing version.
	7. Some issue on collaboration, the testing code in Driver and implementation of interface should be done simultaneously.

---
### Linpei's reflection
	1. I think for the helper method length(), I should’ve checked the larger numbers first so that it’ll be more simple compared to what we have right now.
	2. With the helper method upperAndLowerCase(), I added a isLetter() before any other condition because with the code we had before, a number can also return false to isUpperCase() or isLowerCase(), by adding the isLetter() first eliminates the possibility of having a number or special character.