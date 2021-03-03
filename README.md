# check

<b>Animated Example of getting the number of LIS (with pseudo code):</b>  
By dynamic programming it is possible to calculate the length and number of strings of the LIS in the complexity of nlogn.  
After performing the pseudo code attached below we will conclude:  
LIS length = number of rows.  
LIS number = the 'sum' variable in the last element (the last element in the last row).  
<b>Note!</b> Only the variable 'sum' is needed but no 'count' and 'child index' variables are needed.  
The 'count' and 'child index' variables are used only for the output of all LIS as we will see below.  

```diff
 pseudo code:
• perform binary search on last
   elements on each row.
• add the new element to the row.
• perform binary search on previous row
   first child index =
  (+) founded index + 1.
• new element sum =
  (+) sum of the last element on previous row
  (-) sum of the element left to first child 
  (+) sum of the element left to the new element.
• new elemnt count =
  (+) new element sum
  (-) sum of the element left to the new element.
```

<table align="center">
<tr><td> 
<p align="center"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-NUM-M.gif"/></p>
</td></tr>
</table>

<b>Animated Example of getting the output of all LIS (with pseudo code):</b>
<table align="center">
<tr><td> 
<p align="center"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-STRS-M.gif"/></p>
</td></tr>
</table>
