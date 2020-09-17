import java.util.*;

public class TwoSum {
	
	private int[] indexVals = new int[2];
	private int[] num;

	public TwoSum() {}

	public void fillArray() { //takes a specified number of elements from user, sorts them into an array, and gives the array to the user
		Scanner in = new Scanner(System.in);

		System.out.print("How many numbers are you going to search through: ");
		int[] temp = new int[in.nextInt()];

		System.out.print("Please enter the list of numbers: ");
		for (int i = 0; i < temp.length; i++) {
			temp[i] = in.nextInt();
		}

		sort(temp);
		num = temp;
		
		System.out.print("Your sorted list: ");
		printList(num);
	}
	
	public int[] twoSum(int[] num, int sum) { //goes through specified array and returns the indeces of the values whose sum is equal to the specified sum
		int left = 0;
		int right = num.length-1;
		boolean found = false;
		while (!found && left < num.length && right >= 0) {
			if (num[left] + num[right] == sum && num[left] != num[right]) {
				indexVals[0] = left;
				indexVals[1] = right;
				found = true;
			} else if (num[left] + num[right] < sum) {
				left++;
			} else {
				right--;
			}
		}

		if (!found) {
			indexVals[0] = -1; //if the sum doesn't exits, the first value is set to -1
		}
		 
		return indexVals;
	}

	public void printList(int[] arr) { //prints the array
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int findSmallest(int[] arr, int indexVals) { //finds the smallest value in the array after a specified index
		int smallest = indexVals;
		for (int i = indexVals + 1; i < arr.length; i++) {
			if (arr[i] < arr[smallest]) {
				smallest = i;
			}
		}
		return smallest;
	}

	public void swap (int[] arr, int i, int j) { //swaps two elements at specified indeces
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sort(int[] arr) { // sorts array in ascending order
		for (int i = 0; i < arr.length; i++) {
			swap(arr, i, findSmallest(arr, i));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TwoSum twosum = new TwoSum();
		int[] indexVals = new int[2];

		twosum.fillArray();
		
		System.out.print("Please enter the sum you would like to search for: ");
		indexVals = twosum.twoSum(twosum.num, in.nextInt());

		if(indexVals[0] != -1) {
			System.out.println("[" + indexVals[0] + ", " + indexVals[1] + "]");
		} else {
			System.out.println("-1");
		}
	}
}






















