# check

🏆 Competitive assignment 🏆
I wrote the algorithms for a competitive assignment at my university.  
I have written the algorithms I have attached here a little more clearly for understanding,  
but it is certainly possible to optimize the runtimes of the algorithms.

-----

<h2>Calculate the number (and length) of LIS</h2>
<b>Complexity: nlog(n).</b>

-----

By dynamic programming it is possible to calculate the length and number of LIS in the complexity of nlog(n).  
After performing the pseudo code attached below we will conclude:  
LIS length = number of rows.  
LIS number = the 'sum' variable in the last element (the last element in the last row).

<b>Note!</b> Only 'sum' variable is needed for this implementation!  
'count' and 'child index' variables are used only for the output of all LIS as shown below.  

<b>Sum</b>  - represents the sum of LIS till this node.  
<b>Count</b>  - represents the number of LIS such that this node is the last number.  
<b>Child index</b>  - represents the index of the first child of this node.  

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
<b>Animated Example of getting the number of LIS (with pseudo code):</b>
<table align="center">
<tr><td> 
<p align="left"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-NUM-M.gif"/></p>
</td></tr>
</table>

Therefore, the last element sum is the number of LIS (as marked in red in the image below).  
& the number of rows is the length of the LIS.  
<b>Final result:</b>  

<table align="center" width="500">
<tr align="left" width="500"><td align="left" width="500"> 
<p align="left" width="400"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-NUM.jpg" width="400"/></p>
</td></tr>
</table>

-----

<h2>Output all the LIS (to two-dimensional array)</h2>
<b>Total Complexity: nlog(n) + sumOfLIS * lengthOfLIS.</b>

<b>Complexity after running the above algorithm: sumOfLIS * lengthOfLIS.</b>

-----

```diff
pseudo code:
 perform iteration on last row while element count > 0
 & iterate between each path by childs index

    while element count > 0:
         • add num to arr[row][col].
         • col = col - 1.
         • pointer = pointer child.
         • if pointer count = 0:
                restore pointer child index variable.
         • pointer count = pointer count - 1.
         • if pointer count == 0 & parent count > 0:
                parent child index = parent child index + 1.
         • if col == 0:
                add num to arr[row][col].
                col = cols size.
                row = row - 1.
                pointer = head.
                pointer count = pointer count - 1.
    end while
```

<b>Animated Example of getting the output of all LIS (with pseudo code):</b>
<table align="center">
<tr><td> 
<p align="center"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-STRS-M.gif"/></p>
</td></tr>
</table>

<b>Final result:</b>  

<table align="center" width="500">
<tr align="left" width="500"><td align="left" width="500"> 
<p align="left" width="400"><img src="https://github.com/AlmogJakov/check/raw/main/LIS-STRS.jpg" width="400"/></p>
</td></tr>
</table>
