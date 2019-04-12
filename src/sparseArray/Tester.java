package sparseArray;

public class Tester {

    public static void main(String[] args)
    {
        SparseArray testArray = new MySparseArray(0);
        testArray.setValue(0,0,1);
        testArray.setValue(0,1,2);
        testArray.setValue(0,2,3);
        testArray.setValue(1,0,4);
        testArray.setValue(1,2,5);
        testArray.setValue(2,1,6);
        testArray.elementAt(0,0);



    }
}
