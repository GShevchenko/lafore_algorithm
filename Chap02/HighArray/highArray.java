// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    private long maxValue;

    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;      // no items yet
        maxValue = Long.MIN_VALUE; // no items yet
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {                              // find specified value
        int j;
        for (j = 0; j < nElems; j++)            // for each element,
            if (a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if (j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        if (value > maxValue) {
            maxValue = value;
        }
        a[nElems] = value;             // insert it}
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        boolean result;

        for (j = 0; j < nElems; j++)        // look for it
            if (value == a[j])
                break;
        if (j == nElems)                  // can't find it
            result = false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--;                   // decrement size
            result = true;
        }
        if (value == maxValue) {
            maxValue = Long.MIN_VALUE;
            for (int i = 0; i < nElems; i++) {
                if (a[i] > maxValue) maxValue = a[i];
            }
        }
        return result;
    }  // end delete()

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------

    public long getMax() {
        return nElems == 0 ? -1 : maxValue;
    }
}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array
        System.out.println("Max value after init array (must be -1): " + arr.getMax());
        arr.insert(77);               // insert 10 items
        arr.insert(66);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        System.out.println("Max must be 77: " + arr.getMax());

        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(99);
        arr.insert(33);
        System.out.println("Max must be 99: " + arr.getMax());

        arr.display();                // display items

        int searchKey = 35;           // search for item
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(99);
        System.out.println("Max must be 88: " + arr.getMax());

        arr.display();                // display items again
    }  // end main()
}  // end class HighArrayApp
