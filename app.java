import java.io.*;
import java.util.*;
 
// A job has a start time, finish time and profit.
class Activity
{
  int start, finish;
 
  // Constructor
  public Activity(int start, int finish)
  {
    this.start = start;
    this.finish = finish;
  }
}
 
// class to define user defined comparator
class Compare
{
 
  // A utility function that is used for sorting
  // activities according to finish time
  static void compare(Activity arr[], int n)
  {
    Arrays.sort(arr, new Comparator<Activity>()
                {
                  @Override
                  public int compare(Activity s1, Activity s2)
                  {
                    return s1.finish - s2.finish;
                  }
                });
  }
}
 
// Driver class
class GFG {
 
  // Returns count of the maximum set of activities that
  // can
  // be done by a single person, one at a time.
  static void printMaxActivities(Activity arr[], int n)
  {
    // Sort jobs according to finish time
    Compare obj = new Compare();
    obj.compare(arr, n);
    System.out.println(
      "Following activities are selected :");
 
    // The first activity always gets selected
    int i = 0;
    System.out.print("(" + arr[i].start + ", "
                     + arr[i].finish + "), ");
 
    // Consider rest of the activities
    for (int j = 1; j < n; j++)
    {
 
      // If this activity has start time greater than
      // or equal to the finish time of previously
      // selected activity, then select it
      if (arr[j].start >= arr[i].finish)
      {
        System.out.print("(" + arr[j].start + ", "
                         + arr[j].finish + "), ");
        i = j;
      }
    }
  }
 
  // Driver code
  public static void main(String[] args)
  {
 
    int n = 12;
    Activity arr[] = new Activity[n];
    arr[0] = new Activity(12, 20);
    arr[1] = new Activity(1, 18);
    arr[2] = new Activity(4, 8);
    arr[3] = new Activity(14, 19);
    arr[4] = new Activity(3, 6);
    arr[5] = new Activity(22, 27);
    arr[6] = new Activity(16, 24);
    arr[7] = new Activity(17, 23);
    arr[8] = new Activity(2, 10);
    arr[9] = new Activity(21, 25);
    arr[10] = new Activity(7, 13);
    arr[11] = new Activity(12, 15);
    printMaxActivities(arr, n);
  }
}