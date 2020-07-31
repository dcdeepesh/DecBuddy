@ECHO OFF
REM temporary batch-based build file

rmdir /Q /S build
rmdir /Q /S dist

javac --source-path src src\dec\app\buddy\DecBuddy.java -d build\classes

mkdir dist
jar cfe dist\DecBuddy.jar dec.app.buddy.DecBuddy -C build\classes\ . res
