package LIS.src;

import java.util.ArrayList;

class Node {
	/* the number that this node represents */
	int num;
	/*
	 * count of the LIS number from this node to leaves nodes (decreased after each
	 * use)
	 */
	int count;
	/*
	 * variable to restore the original count in case of access from another parent
	 */
	int restoreCount;
	/* sum of the LIS number from previous nodes + this node */
	int sum;
	/* childs row index (all childs in the same row) */
	int childsRow;
	/*
	 * childs col indexes of this node (ordered one by one while firstChildCol is
	 * the first child)
	 */
	int firstChildCol;
	/* pointer to iterate between the childs */
	int ChildPointerCol;

	/* Constructor */
	public Node(int num) {
		this.num = num;
		restoreCount = 0;
		firstChildCol = 0;
	}

	/* Constructor */
	public Node(int num, int sum, int count) {
		this(num);
		this.sum = sum;
		this.count = count;
	}
}

public class LIS {
	/* Original array */
	private int[] arr;
	/* Original array as list */
	private ArrayList<Node> Arr;
	/* Length of the input array */
	private int len;
	/* Store teta for returning allLis if allLis<teta otherwise return one lis */
	private int teta;
	/* lengthLIS result and boolean to flag if already calculated */
	private boolean lengthLIS;
	private int LisLen;
	/* numOfLIS result and boolean to flag if already calculated */
	private boolean numOfLIS;
	private int numOfStrs;
	/* allLis result and boolean to flag if already calculated */
	private boolean allLIS;
	private int[][] allLis;
	/* Auxiliary variables to calculate numOfLIS and allLis methods results */
	private ArrayList<ArrayList<Node>> lists;
	private Node max;
	private Node min;

	/* Constructor */
	public LIS(int[] arr, int teta) {
		/* initialize class variables */
		this.arr = arr;
		this.teta = teta;
		len = arr.length;
		LisLen = 0;
		numOfStrs = 0;
		numOfLIS = false;
		allLIS = false;
		lengthLIS = false;
	}

	////////////////////////////////////////////////////////////////////////////
	////////////////////////// Return lengthLIS ////////////////////////////////
	//////////////////// Auxiliary methods: binarySearch ///////////////////////
	////////////////////////// Complexity: nlogn ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	public int lengthLIS() {
		if (len == 0)
			lengthLIS = true;
		if (lengthLIS)
			return LisLen;
		int newarr[] = new int[len];
		int pointer = 0, size = 0;
		newarr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pointer = binarySearch(newarr, size, arr[i]);
			if (pointer > size)
				size++;
			newarr[pointer] = arr[i];
		}
		size++;
		LisLen = size;
		lengthLIS = true;
		return LisLen;
	}

	private static int binarySearch(int[] arr, int last, int n) {
		/* Returns the index of the number or the following-number index */
		int start = 0, end = last, middle = last / 2;
		while (start <= end) {
			if (arr[middle] < n)
				start = middle + 1;
			else
				end = middle - 1;
			middle = (end + start + 1) / 2;
		}
		return middle;
	}

	////////////////////////////////////////////////////////////////////////////
	/////////////////////////// Return numOfLIS ////////////////////////////////
	/// Auxiliary methods: numLdsBSearch, numLisBSearch, createNewList, init ///
	////////////////////////// Complexity: nlogn ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	/* binary search lds by num */
	private int numLdsBSearch(ArrayList<Node> arr, int n) {
		/* Returns the index of the number or the following-number index */
		int start = 0, end = arr.size() - 1, middle = (arr.size() - 1) / 2;
		while (start <= end) {
			if (arr.get(middle).num > n)
				start = middle + 1;
			else
				end = middle - 1;
			middle = (end + start + 1) / 2;
		}
		return middle;
	}

	/* binary search lis by last node num */
	private int numLisBSearch(int n) {
		/* Returns the index of the number or the following-number index */
		int start = 0, end = lists.size() - 1, middle = (lists.size() - 1) / 2;
		ArrayList<Node> mid;
		while (start <= end) {
			mid = lists.get(middle);
			if (mid.get(mid.size() - 1).num < n)
				start = middle + 1;
			else
				end = middle - 1;
			middle = (end + start + 1) / 2;
		}
		return middle;
	}

	private void createNewList() {
		ArrayList<Node> newList = new ArrayList<Node>();
		newList.add(max);
		lists.add(newList);
	}

	private void init() {
		/* make a list from the input array */
		Arr = new ArrayList<Node>();
		for (int i = 0; i < len; i++)
			Arr.add(new Node(arr[i]));
		/* initialize 'lists' variables */
		lists = new ArrayList<ArrayList<Node>>();
		this.max = new Node(Integer.MAX_VALUE, 0, 1);
		this.min = new Node(Integer.MIN_VALUE, 1, 1);
		ArrayList<Node> firstArr = new ArrayList<Node>();
		firstArr.add(max);
		firstArr.add(min);
		lists.add(firstArr);
	}

	public int numOfLIS() {
		if (numOfLIS)
			return numOfStrs;
		if (len == 0) {
			numOfStrs = 0;
			numOfLIS = true;
			return numOfStrs;
		}
		init();
		ArrayList<Node> prevRowList;
		ArrayList<Node> currRowList;
		int currNodeRow;
		int largestChild;
		Node curr;
		for (int i = 0; i < len; i++) {
			curr = Arr.get(i);
			currNodeRow = numLisBSearch(curr.num);
			if (currNodeRow > lists.size() - 1)
				createNewList();
			// /* The following code snippet is for inputs of an array in which duplicates
			// of numbers appear */
			// /* in case there is duplicated numbers - merge the Nodes! */
			// else if
			// (lists.get(currNodeRow).get(lists.get(currNodeRow).size()-1).num==curr.num) {
			// currRowList = lists.get(currNodeRow);
			// prevRowList = lists.get(currNodeRow - 1);
			// largestChild = numLdsBSearch(prevRowList, curr.num);
			// if (curr.num != prevRowList.get(largestChild).num) largestChild--;
			// int lastRowSum = prevRowList.get(prevRowList.size()-1).sum -
			// prevRowList.get(largestChild).sum;
			// /* merge by adding lastRowSum to current sum */
			// currRowList.get(currRowList.size()-1).sum += lastRowSum;
			// /* merge by adding lastRowSum to current count */
			// currRowList.get(currRowList.size()-1).count += lastRowSum;
			// printListsC();
			// continue;
			// }
			// /* end duplicated numbers code */
			currRowList = lists.get(currNodeRow);
			prevRowList = lists.get(currNodeRow - 1);
			largestChild = numLdsBSearch(prevRowList, curr.num);
			if (curr.num != prevRowList.get(largestChild).num)
				largestChild--;
			int lastRowSum = prevRowList.get(prevRowList.size() - 1).sum - prevRowList.get(largestChild).sum;
			curr.ChildPointerCol = largestChild + 1;
			curr.childsRow = currNodeRow - 1;
			curr.sum = lastRowSum + currRowList.get(currRowList.size() - 1).sum;
			currRowList.add(curr);
			curr.count += curr.sum - currRowList.get(currRowList.size() - 2).sum;
			curr.restoreCount = curr.count;
		}
		ArrayList<Node> lastRow = lists.get(lists.size() - 1);
		numOfStrs = lastRow.get(lastRow.size() - 1).sum;
		LisLen = lists.size() - 1;
		lengthLIS = true;
		numOfLIS = true;
		return numOfStrs;
	}

	////////////////////////////////////////////////////////////////////////////
	//////////////////////////// Return allLIS /////////////////////////////////
	/////////////////////// Auxiliary methods: oneLIS //////////////////////////
	///////////// Total Complexity: nlogn + numOfLIS*LengthOfLIS ///////////////
	///// Complexity after running numOfLIS method: numOfLIS*LengthOfLIS ///////
	////////////////////////////////////////////////////////////////////////////

	private int[][] oneLIS() {
		int[][] result = new int[1][LisLen];
		int col = LisLen - 1;
		ArrayList<Node> last = lists.get(lists.size() - 1);
		if (last.size() < 2)
			return result;
		Node child = last.get(1);
		while (col > 0) {
			result[0][col--] = child.num;
			child = lists.get(child.childsRow).get(child.ChildPointerCol);
		}
		result[0][col] = child.num;
		return result;
	}

	public int[][] allLIS() {
		if (!numOfLIS)
			numOfLIS();
		if (LisLen == 0) {
			allLIS = true;
			allLis = new int[0][0];
			return allLis;
		}
		if (numOfStrs > teta)
			return oneLIS();
		if (allLIS)
			return allLis;
		allLis = new int[numOfStrs][LisLen];
		int row = numOfStrs - 1;
		int col = LisLen - 1;
		ArrayList<Node> last = lists.get(lists.size() - 1);
		Node head;
		Node parent;
		Node child;
		for (int i = 1; i < last.size(); i++) {
			head = last.get(i);
			parent = head;
			child = head;
			while (head.count > 0) {
				allLis[row][col--] = child.num;
				parent = child;
				child = lists.get(child.childsRow).get(child.ChildPointerCol);
				if (child.count == 0) {
					child.count = child.restoreCount;
					child.ChildPointerCol -= child.firstChildCol;
					child.firstChildCol = 0;
				}
				child.count--;
				// /* The following code snippet is for inputs of an array in which duplicates
				// of numbers appear */
				// if (child.count == 0 && parent.count > 0 &&
				// lists.get(parent.childsRow).size()>parent.ChildPointerCol+1) {
				// /* end duplicated numbers code */
				if (child.count == 0 && parent.count > 0) {
					parent.ChildPointerCol++;
					parent.firstChildCol++;
				}
				if (col <= 0) {
					if (col == 0)
						allLis[row][col] = child.num;
					col = LisLen - 1;
					row--;
					child = head;
					parent = head;
					head.count--;
				}
			}
		}
		allLIS = true;
		return allLis;
	}

	public int getTeta() {
		return teta;
	}
}