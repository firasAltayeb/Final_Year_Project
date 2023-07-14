# Final-Year-Project

In order to download the Windows executables file please follow one of these links,

https://drive.google.com/open?id=0B7a2PtVOj_8mWFJ2bFNRcTZKTlU
https://www.dropbox.com/s/1r6fovdhtdcwsi6/desktop-1.0.jar?dl=0

In order to compile the Desktop version of the project you will first need to download the assets folder from one of the following links:

https://drive.google.com/open?id=0B7a2PtVOj_8mVzhtTnZjS2IwVDA
https://www.dropbox.com/s/nt7tpeci7daxbkh/desktop.zip?dl=0

After downloading the desktop directory from one of the above links, you will need to drag the assets folder which is inside the desktop directory to the path;

FinalKanjiQuest_Desktop/core

The result of doing so should be;

FinalKanjiQuest_Desktop/core/assets

After doing the above, while using Android Studio, you will need to click "Edit Configuration" and then click the plus icon and add an "Application".  In the "Main class" space choose;

 "com.mygdx.game.desktop.DesktopLauncher"

For your "Working Directory" choose

../Final_Year_Project/FinalKanjiQuest_Desktop/core/assets"

For the "Use classpath of module" choose

desktop

After following the above steps, click apply. You will be able to run the app normally.

In order to create a desktop executables file, run the following command in the included
Android studio terminal

./gradlew desktop:dist



In order to download the Android executables file please follow one of these links,

https://drive.google.com/open?id=0B7a2PtVOj_8mNkNmSC1vMVJMLU0
https://www.dropbox.com/s/9ih0ndov7beqpqr/android-debug.apk?dl=0


In order to compile the Android version of the project you will first need to download the assets folder from one of the following links: -

https://drive.google.com/open?id=0B7a2PtVOj_8md3VJUjdiOFFoMjg
https://www.dropbox.com/s/tis78te85lu9en7/android.zip?dl=0

After downloading the Android directory from one of the above links, you will need to drag the assets folder which is inside the Android directory to the path

FinalKanjiQuest_Desktop/android

The result of doing so should be

FinalKanjiQuest_Desktop/android/assets

After following the above steps. You will be able to run the app normally.

In order to create an Android executables file, click build from the top of the screen
and then click build apk
