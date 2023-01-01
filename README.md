# SpeakingClock
Wisdom Leaf task.

## Instruction to run the SpeakingClock

To clone the repo to your local use command "git clone https://github.com/ShreedharYashoda/SpeakingClock.git"

Move to home folder of the project and run "mvn spring-boot:run" (Assuming openjdk and maven installed on system)

Then application SpeakingClock would be running on your system, on port 1111

At endpoint "/v1/timeFormatter/getTimeInWords" you can use SpeakingClock by providing time in numbers as path param "timeInDigits" like in example

For 01:56 response would be "It's one fifty six"

<img width="1086" alt="image" src="https://user-images.githubusercontent.com/43503503/210175412-ec29172d-208f-4713-a946-887e6503b8b9.png">

For 00:56 response would be "It's midnight past fifty six"

<img width="1086" alt="image" src="https://user-images.githubusercontent.com/43503503/210175476-ae1ba8e2-3b33-46ad-b9a1-d7c050e9b8ea.png">




