import java.util.TreeSet;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Learning_TreeSet {
	// TreeSet with default ordering
	public static TreeSet<Integer> Normal = new TreeSet<>();

	public static Comparator<Integer> comparator = (a,b) -> b.compareTo(a);
	public static TreeSet<Integer> Comparator = new TreeSet<>(comparator);

	// TreeSet from different sources
	public static TreeSet<Integer> From_Input = new TreeSet<>();
	public static Scanner scanner = new Scanner(System.in);

	public static TreeSet<Integer> Randomized = new TreeSet<>();

	public static TreeSet<Integer> Array = new TreeSet<>();

	public static TreeSet<Integer> From_File = new TreeSet<>();
	
	public static void main(String[] args) {
		Normal.add(5);
		Normal.add(3);
		Normal.add(8);
		Normal.add(1);
		Normal.add(4);

		Comparator.add(5);
		Comparator.add(3);
		Comparator.add(8);
		Comparator.add(1);
		Comparator.add(4);

		System.out.println("TreeSet " + Normal);
		System.out.println("TreeSet with Comparator " + Comparator);
		System.out.println("Number of elements: ");

		// Input from keyboard
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Please input value of the elements # " + (i + 1) + ": ");
			int input = scanner.nextInt();
			From_Input.add(input);
		}
		System.out.println("TreeSet from keyboard input: " + From_Input);

		//Randomized TreeSet
		for(int i = 0; i < n;i++)
		{
			
			int ran = (int)(Math.random() * 100);
			System.out.println("Elements #" + (i+1) +  " randomized: " + ran);
			Randomized.add(ran) ;
		}
		System.out.println("TreeSet from Random: " + Randomized);
		
		//Array TreeSet
		int[] arr = {12,45,23,67,34,89,23,45};
		for (int i = 0; i < arr.length; i++) 
		{
			Array.add(arr[i]);
		}
		System.out.println("TreeSet from Array: " + Array);

		//FILE
		File inputFile = new File("input.txt");	//	input.txt should be in the same directory as the Java file
		if (inputFile.exists()) {
			try {
				Scanner fileScanner = new Scanner(inputFile) ;
				while (fileScanner.hasNextInt()) 
				{
					int fileInput = fileScanner.nextInt();
					From_File.add(fileInput);
				}
				fileScanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("Can't access input.txt: " );
			}
		} else {
			System.out.println("Not found : input.txt");
		}
		System.out.println("TreeSet from file: " + From_File);

		// Search for an element in TreeSet Random
		System.out.println("Search for an element in TreeSet Random: ");
		int Find = scanner.nextInt();
		if (Randomized.contains(Find)) {
			System.out.println("Value : " + Find + " found in TreeSet.");
		} else {
			System.out.println("Value : " + Find + " not found TreeSet.");
		}

		// Delete an element from TreeSet Random
		System.out.println("Input an element to delete from TreeSet Random: ");
		int Remove = scanner.nextInt();
		if (Randomized.remove(Remove)) {
			System.out.println("Value : " + Remove + " removed from TreeSet.");
		} else {
			System.out.println("Value : " + Remove + " not found in TreeSet, cannot remove.");
		}
		System.out.println("TreeSet : " + Randomized);

		// Perform some statistics on TreeSet Random
		System.out.println("Enter a number for statistics (Using TreeSet Random):");
		int key = scanner.nextInt();
		System.out.println("Number of elements in TreeSet: " + Randomized.size());
		System.out.println("Smallest value greater than or equal to " + key + " : " + Randomized.ceiling(key));
		System.out.println("Largest value less than or equal to " + key + " : " + Randomized.floor(key));
		System.out.println("Smallest value greater than " + key + " : " + Randomized.higher(key));
		System.out.println("Largest value less than " + key + " : " + Randomized.lower(key));
		System.out.println("Set of elements smaller than " + key + " : " + Randomized.headSet(key));
		System.out.println("Set of elements greater than or equal to " + key + " : " + Randomized.tailSet(key));
		System.out.println("Set of elements from 0 to " + key + " : " + Randomized.subSet(0, key));
		System.out.println("First element: " + Randomized.first());
		System.out.println("Last element: " + Randomized.last());

		// Convert TreeSet Randomized to an array
		Integer[] a = new Integer[Randomized.size()];
		Randomized.toArray(a);
		System.out.println("Array from TreeSet Randomized: ");
		for (int k = 0; k< a.length; k++) {
			System.out.print(a[k] + " ");
		}


		// Clear all elements from TreeSet Randomized
		Randomized.clear();
		System.out.println("\n Cleared TreeSet (Randomized)" + Randomized);
	}
}
