# Resistor Scanner
**Resistor Scanner** is an Android app that uses OpenCV to scan resistor colour bands and determines their values.

[![Google Play](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=ca.parth.resistordecoder)

## Screenshot
![Screenshot](http://i.imgur.com/aBMGLoL.png)

## Tested devices

Tested on a Nexus 4.
Note that white balance differences with other phone cameras might require tweaking colour ranges in
[ResistorImageProcessor.java](app/src/main/java/ca/parth/resistordecoder/ResistorImageProcessor.java)

## How it works

[ResistorCameraView ](app/src/main/java/ca/parth/resistordecoder/ResistorCameraView.java) extends JavaCameraView
and enables the flash and zooms in fully (I found this was the best way of getting clear images with a somewhat consistent
white balance)

[ResistorImageProcessor](app/src/main/java/ca/parth/resistordecoder/ResistorImageProcessor.java) contains the colour detection logic.
It scans a small area below the red line indicator for the colours defined by COLOUR_BOUNDS, and generates contours
for these regions.
It stores the colour code value vs x-coordinate of the centroids of these contours in a dictionary.

The resistor value is then calculated by iterating through the x-coords of the centroids in ascending order
and using their associated codes. (This requires the resistor tolerance band to be placed on the right side).

Note that this app works best when the resistors are on a light background.

## Demo
[App demo](https://www.youtube.com/watch?v=h_bITwduLPk)
