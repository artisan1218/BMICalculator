# Java GUI Apps
This repo contains three Java GUI applications:
  1. BMI Calculator
  2. Statistical Calculator
  3. Natural Number Calculator

Note: all of them requires a valid JRE to run

### 1. BMI Calculator
Read input(height and weight as integers) from user, then perform BMI(Body-Mass index) calculation and display the result to user interface.
BMI is weight in kilograms divided by height in meters squared

Application window:

<img width="460" alt="image" src="https://user-images.githubusercontent.com/25105806/115973948-b5e87380-a50d-11eb-8975-2fb47fb85359.png">

Result display:

<img width="460" alt="image" src="https://user-images.githubusercontent.com/25105806/115973965-fa740f00-a50d-11eb-9128-b02acb294900.png">


### 2. Statistical Calculator
Read from user input: a list of numbers and display the statistical measurement of these numbers including:
  1. Mean value
  2. Median value
  3. Mode: the number that appears the most
  4. Range: difference between the max and min value
  5. Mid-Range: mid-way between the least value and the greatest value of the data set
  6. Population Standard Deviation: the formula is shown below
 <img src="https://user-images.githubusercontent.com/25105806/115974067-e977cd80-a50e-11eb-845f-de6f27fc075a.png" width="20%" height="20%">

where the parameters are:

<img width="243" alt="image" src="https://user-images.githubusercontent.com/25105806/115974083-10360400-a50f-11eb-979e-8033eb135277.png">

The input list can be any positive numbers separated by any delimiters, such as comma, white space, etc.

Application window:

<img width="659" alt="image" src="https://user-images.githubusercontent.com/25105806/115974104-41aecf80-a50f-11eb-9041-f38673eedec4.png">

Result display 1, numbers separated by ,:

<img width="659" alt="image" src="https://user-images.githubusercontent.com/25105806/115974110-50958200-a50f-11eb-9824-de1e0b5e5d8c.png">

Result display 2, numbers separated by white space:

<img width="659" alt="image" src="https://user-images.githubusercontent.com/25105806/115974161-aff39200-a50f-11eb-9daa-19df4afd77f1.png">


### 3. Natural Number Calculator
NN calculator works just like any other calculator but it can calculate any large number without the overflow issue because it's implemented not using Java Int but a customized NaturalNumber class.

How to use:
Enter a number in the number pad, click enter to save it to top window, then enter another number in the number pad, then choose the operation you want to perform, such as +, -, *, /, pow, or root.

swap button can switch the top/bottom value. Clear is used to clear the window. 

Application window:

<img width="527" alt="image" src="https://user-images.githubusercontent.com/25105806/115974201-f943e180-a50f-11eb-9e8e-6d4f5f1667f8.png">

Result display, calculation of 123456789+987654321:
Enter 123456789 in the number pad, click enter, enter 987654321 in the number pad, click +:

<img width="527" alt="image" src="https://user-images.githubusercontent.com/25105806/115974313-8c7d1700-a510-11eb-8921-f55f03e6fd13.png">

Result display, calculation of 123 to the power of 6:
Enter 123 in the number pad, click enter, then enter 6, click pow:

<img width="527" alt="image" src="https://user-images.githubusercontent.com/25105806/115974369-10cf9a00-a511-11eb-99d5-36a157a4f124.png">

