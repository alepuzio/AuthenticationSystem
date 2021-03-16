# CONTRIBUTING

 - Download the project as described in [README.md](http://www.github.com/alepuzio/MMS/README.md);
 - If the code is yet downloaded, update the project using the command _git pull_;
 - Run the code to ensure that the pushed code works with no error;
 - Study the actual code;

## ASK ONE NEW FUNCTIONALITY

 - Open a new issue, describing the problem or the new functionality. If it's possible, use the format _AS ... I WOULD ... TO OBTAIN..._;
 - Run _git pull_ to synchronize your local copy to remote repository
 - Open a new local branch;
 - Follow strictly the bullet points in section _RULES TO WRITE CODE_: I can refuse a pull request if the code is not colliant my these rules;
 - Commit when you want,
 - Push only if the unit tests run fine, the othe contributer must ot run the code without any error after _git pull_;
 - Send the pull request waiting for me I authorize the merge in _master_ branch 

## RULES TO WRITE CODE

 - Follow the philosophy of [Elegant Object](https://www.elegantobjects.org/);
 - The assignment operator _=_ and the end of instruction _;_ must have one empty space before and one empty space after (no value or variabile concateined).
  For example: _a = 10_ , _; b < 123;_ are allowed, but _a= 10_ and _;b <123;_ are not;
 - Follow the TDD approach: before the tests, after the code;
 - Use composition over inheritance;



