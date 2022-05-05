# Music Visualiser Project

Name: Karla Marta Lozer, Kah Siong Chong, Joshua Al Rasbi

Student Number: C20302353, D20123833, C20356061


# Description of the assignment

The assignment is a visual representation of sound, consisting of shapes such as circles, lines, rectangular and items such as robots, drums, speakers, stage... Those objects and shapes react to music that is playing, they are responsive to sound. To analyse sound we used minim library. From there we were able to make shapes responsive to things such as amplitude, frequency bands, size of audio buffer...

# Instructions

- Fork this repository
-
- Clone it

- Run the main.java file in the ie.tudublin package

- Check control section from this description to find out more about controls

# How it works

When the program is run menu will be displayed. There is a choice of 5 songs: "Homies In Paris", "Hero Planet", "Tequila Shots", "All the Things", "Masquerade" displayed on the menu. Users can navigate through them by pressing the right arrow on their keyboard to go to the next song, or by pressing the left arrow to go to the previous song. When the user is happy with their choice there is a start button which has to be pressed for the game to start. The stage will be displayed with drums. Those drums will generate sound depending on the button pressed. Press "a" to generate sound for the first drum (hat), "s" for the second one (kick) and "d" for (snare). Users can then press Menu to go back to the menu or Quit to exit the program. 

Sounds mainly react to the Amplitude which is then mapped depending on the shape we want to create. Music and sound effects are stored in two different arrays and then changed depending on users' choices and buttons pressed. This is all stored in GameOfNode class. Inheritance is used to call functions like startMinim() and other functions from the Visual class. We also used a lerped buffer to get the spectrum to change according to the amplitudes of the song.


# What I am most proud of in the assignment

Scanning Laser Eye

This laser scans the stage for intervals of 10 seconds, stops for 5 and then starts again. This is the formula for laserTimer = millis() / 1000.0f % 15. For the laser to work we used two for loops. One for checking if the timer is less or equal to 10 and greater or equal to 0. Another for loop is used to draw the lines ( laser effect ) by mapping i from it's current range of 0 to buffer size to our new rage which is from 0 to the width of our screen. 

```Java
 laserTimer = gon.millis() / 1000.0f % 15;

        gon.stroke(255, 255, 255);
        gon.strokeWeight(0.5f);
        if (laserTimer >= 0 && laserTimer <= 10)
        {
            laserY = PApplet.map(laserTimer % 10, 0, 10, 0, gon.height);
            for (int i = 0; i < gon.ab.size(); i += 5)
            {
                laserX = PApplet.map(i, 0, gon.ab.size(), 0, gon.width);
                gon.line(halfW, halfH / 2, laserX, laserY);
            }
        }

```

![Image 05-05-2022 at 20 33](https://user-images.githubusercontent.com/95685389/167012866-1a27d8c7-8a8b-4d54-8fcf-da7760f58c33.jpg)


Drums Which Make Sound

When one of our 3 drums is pressed by pressing either "a", "s" or "d" it will make a sound. This sound is wav file which is read from the data folder. Depending on the button press different wave file will be loaded and therefore make different sounds. If "a" is pressed hitEffect will be set to ( boolean to check) if the button is pressed and drumHit() function from the Drum class will be called. This is where our sound will be played which is stored in a file.

```Java
 public void drumHit() {
        gon.loadAudio(soundPath);
        gon.ap1 = gon.getAudioPlayer();
        gon.ap1.play();
        gon.ab = gon.ap1.mix;
        gon.ap1.rewind();

        hitEffect = true;
        brightness = 255;
    }

```
![image_50359041](https://user-images.githubusercontent.com/95685389/167012833-b4db23ec-bc82-4bbe-baf2-fead94caa969.JPG)

Because hitEffect is set to true other functions will be called to draw stars, lines and make echo effect.

Other Things We Are Proud Of :
- better understanding of sound and differences between things such as frequence, amplitude, FFT, frequence bands

- creating shapes using beginShape(), endShape() and vertex() methods.

- using sin(), cos() to get the right angle

- use of render methods 



# Controls

MENU CONTROLS :

Left Arrow - go to the previous song

Right Arrow - go to the next song

Press Start - start the game

<img width="1112" alt="Screenshot 2022-05-05 at 22 05 42" src="https://user-images.githubusercontent.com/95685389/167026041-566f4ff5-79e7-4927-8f5b-74d9ad8a8286.png">


GAME CONTROL :

"a" - hat sound will be played

"s" - kick sound will be played

"d" - snare sound will be played

Press Quit - exit program

Press Menu - go back to the menu


```Java
 if (displayMenu) {
            if (keyCode == LEFT) {
                if (currSong == 0) {
                    currSong = songsName.length - 1;
                } else {
                    currSong--;
                }
                changeMusic();
            } else if (keyCode == RIGHT) {
                if (currSong == songsName.length - 1) {
                    currSong = 0;
                } else {
                    currSong++;
                }
                changeMusic();
            } else if (keyCode == ENTER) {
                displayMenu = false;
            }
        } else {
            if (key == 'a') {
                hat.drumHit();
            } else if (key == 's') {
                kick.drumHit();
            } else if (key == 'd') {
                snare.drumHit();
            }
        }
		
```
# Link To Our Youtube Video

https://github.com/DrBanksy/MusicVisuals

# Reference

Spirals and Lines were created with reference to this github account:
https://github.com/DrBanksy/MusicVisuals


