
# Toy Robot Operation

## Instruction Note
- Command: `PLACE`, `MOVE`, `LEFT`, `RIGHT`, `REPORT`
- Facing/Direction: `NORTH`, `SOUTH`, `EAST`, `WEST`
- 2 Dimensional on square table 5x5 units: MIN_POSITION = 0, MAX_POSITION = 4 <br>
- Y represent `SOUTH`-`NORTH`
- X represent `WEST`-`EAST`
- origin(0,0) most corner be `SOUTH`,`WEST`
- max(4,4) most corner be `NORTH`,`EAST`  
- |------------------------------------> Y (NORTH) <br>
  | (0,0) | (0,1) | (0,2) | (0,3) | (0,4) <br>
  | (1,0) | (1,1) | (1,2) | (1,3) | (1,4) <br>
  | (2,0) | (2,1) | (2,2) | (2,3) | (2,4) <br>
  | (3,0) | (3,1) | (3,2) | (3,3) | (3,4) <br>
  | (4,0) | (4,1) | (4,2) | (4,3) | (4,4) <br>
  | <br>
  V <br>
  X (EAST)

## Required Tools
- Install Visual Studio code go to https://code.visualstudio.com/download <br>
- Open browser https://code.visualstudio.com/docs/java/java-tutorial <br>
- Click `Install the Extension Pack for Java` or Search from side bar in vs code with `vscjava.vscode-java-pack` 
- `Reload` tools after installed.

## Instruction Running Application
### Test sets
- Provide data 2 tests
  - exercise1: src/main/resources/static/exercise1.txt
  - exercise2: src/main/resources/static/exercise2.txt

### Localhost
#### Windows OS
1. Install JDK17 
- go to https://www.oracle.com/java/technologies/downloads/#jdk17-windows 
- select MSI installer 
- install jdk to local machine or following https://www3.cs.stonybrook.edu/~amione/CSE114_Course/materials/resources/InstallingJava17.pdf
- verify command line `$ java --version`
2. Install gradle
- go to https://gradle.org/releases/ click Download: `binary-only` or `complete` , preferred `binary-only` <br>
- Created `C:\Gradle` <br>
- Unpack download **gradle-8.7.zip** file to `C:\Gradle` <br> 
- In File Explorer right-click on the This PC, then click `Properties` -> `Advanced System Settings` -> `Environmental Variables`.
- Under `System Variables` select `Path`, then click **Edit**. Add an entry for `C:\Gradle\gradle-8.7\bin`. Click **OK** to save.
- verify command line `$ gradle -v`
3. Test App
- unit test app `$ gradlew clean test` 
- generate coveraged unit test `$ gradlew clean jacocoTestReport` output will generated in build/reports/jacoco/test/html/index.html you can open on your browser
4. Start application
- build app `$ gradlew build`
- run app with exercise1 `$ java -jar ./build/libs/robot-operation-1.0.0.jar --app.file.input=src/main/resources/static/exercise1.txt`
- run app with exercise2 `$ java -jar ./build/libs/robot-operation-1.0.0.jar --app.file.input=src/main/resources/static/exercise2.txt`

#### Mac OS
1. Install JDK17
- go to https://www.oracle.com/java/technologies/downloads/#jdk17-mac 
- select DMG installer
- install jdk to local machine or following https://www3.cs.stonybrook.edu/~amione/CSE114_Course/materials/resources/InstallingJava17.pdf
- verify `$ java --version`
2. Install gradle via command `$ brew install gradle`
- export PATH=$PATH:/opt/gradle/gradle-8.7/bin
- verify `$ gradle -v`
3. Test App
- unit test app `$ gradle clean test` 
- generate coveraged unit test `$ gradle clean jacocoTestReport` output will generated in build/reports/jacoco/test/html/index.html you can open on your browser
4. Start application
- build app `$ gradle build`
- run app with exercise1 `$ java -jar ./build/libs/robot-operation-1.0.0.jar --app.file.input=src/main/resources/static/exercise1.txt`
- run app with exercise2 `$ java -jar ./build/libs/robot-operation-1.0.0.jar --app.file.input=src/main/resources/static/exercise2.txt`
