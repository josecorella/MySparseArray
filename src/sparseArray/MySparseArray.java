package sparseArray;

import java.io.*;

/** Implementation of the sparseArray Interface.  */
public class MySparseArray implements SparseArray {
    // Stores default value
    private Object defaultValue;
    // Stores two heads (of type MyNode): rowHead and columnHead
    private MyNode rowHead, columnHead;
    // FILL IN CODE

    /**
     * Sets the default value for the sparse array
     * @param defaultValue default value
     */
    public MySparseArray(Object defaultValue) {
        // FILL IN CODE
        this.defaultValue = defaultValue;
        this.rowHead = new MyNode(-1,-1, null);
        this.columnHead = new MyNode(-1,-1, null);
    }

    /**
     * Getter for the default value
     * @return Returns the default value
     */
    @Override
    public Object getDefaultValue() {
        // FILL IN CODE
        return this.defaultValue; // change
    }

    /**
     * Gets element at the given row and column
     * if the node does not exist return default value
     * @param row row
     * @param col column
     * @return
     */
    @Override
    public Object elementAt(int row, int col) {
        return getDefaultValue();
    }

    /**
     * Modifies the value at a given row, column,
     * or inserts the node for this row, column in the sparse array
     * if it did not exist before.
     * If value is the default value, then the node should be deleted from
     * the sparse array
     * @param row row
     * @param col column
     * @param value value of the element
     */
    @Override
    public void setValue(int row, int col, Object value) {
        int dummyRowIndex = -1;
        int dummyColindex = -1;

        Node previousRow = rowHead;
        Node currentRow = previousRow;
        Node previousColumn = columnHead;
        Node currentColumn = previousColumn;

        if(value != getDefaultValue()){
            while (previousRow.rowNext() != null && previousRow.rowNext().rowIndex() <= row){
                previousRow = previousRow.rowNext();
            }
            //if statement to see if we need to make a dummy node
            if (previousRow.rowNext() == null && previousRow.rowIndex() != row){ // make dummy node
                MyNode dummyRow = new MyNode(row, dummyColindex, null);
                previousRow.setRowNext(dummyRow);
                currentRow = previousRow.rowNext();
            }
            //if we need to make a dummy node before the end of the linked list
            //if statement if we need to make a dummy node after previous amd fix accordingly
            else if(previousRow.rowIndex() < row ){
                MyNode dummyRow = new MyNode(row, dummyColindex, null);
                dummyRow.setRowNext(previousRow.rowNext());
                previousRow.setRowNext(dummyRow);
                currentRow = previousRow.rowNext();
            }
            else{
                currentRow = previousRow;
            }

            while (previousColumn.colNext() != null && previousColumn.colNext().columnIndex() <= col){
                previousColumn = previousColumn.colNext();
            }

            //if statement to see if we need to make a dummy node
            if (previousColumn.colNext() == null && previousColumn.columnIndex() != col){ // make dummy node
                MyNode dummyCol = new MyNode(dummyRowIndex, col, null);
                previousColumn.setColNext(dummyCol);
                currentColumn = previousColumn.colNext();
            }
            else if(previousColumn.columnIndex() < col ){
                MyNode dummyCol = new MyNode(dummyRowIndex, col, null);
                dummyCol.setColNext(previousColumn.colNext());
                previousColumn.setColNext(dummyCol);
                currentColumn = previousColumn.colNext();
            }
            else{
                currentColumn = previousColumn;
            }
            MyNode insertElem = new MyNode(row, col, value);

            while(currentRow.colNext() != null && currentRow.colNext().columnIndex() <= col){
                currentRow = currentRow.colNext();
            }
            if(currentRow.colNext() == null){
                if (currentRow.columnIndex() == col && currentRow.rowIndex() == row){
                    currentRow.setValue(value);
                }
                else {
                    currentRow.setColNext(insertElem);
                }
            }
            else if (currentRow.colNext().columnIndex() >= col){
                if (currentRow.columnIndex() == col && currentRow.rowIndex() == row){
                    currentRow.setValue(value);
                }
                else{
                    insertElem.setColNext(currentRow.colNext());
                    currentRow.setColNext(insertElem);
                }
            }

            while(currentColumn.rowNext() != null && currentColumn.rowNext().rowIndex() <= row){
                currentColumn = currentColumn.rowNext();
            }
            if(currentColumn.rowNext() == null){
                if (currentColumn.columnIndex() == col && currentColumn.rowIndex() == row){
                    currentRow.setValue(value);
                }
                else{

                    currentColumn.setRowNext(insertElem);
                }
            }
            else if (currentColumn.rowNext().rowIndex() >= col){
                if (currentColumn.columnIndex() == col && currentColumn.rowIndex() == row){
                    currentRow.setValue(value);
                }
                else{
                    insertElem.setRowNext(currentColumn.rowNext());
                    currentColumn.setRowNext(insertElem);
                }
            }

        }

        //by this point we have either found a column and row where we have to insert
        //or make a row or column if it is missing
        //make both row and column if they didnt exist

        else{
            while(currentRow.rowNext() != null && currentRow.rowNext().rowIndex() <= row){
                    currentRow = currentRow.rowNext();
            }
            if (currentRow.rowIndex() == row){
                while(previousRow.rowIndex() != currentRow.rowIndex()){
                    previousRow = previousRow.rowNext();
                }
                while(currentRow.colNext() != null && currentRow.colNext().columnIndex() <= col){
                    currentRow = currentRow.colNext();
                }
                while(previousRow.colNext().columnIndex() < currentRow.columnIndex()){
                    previousRow = previousRow.colNext();
                }
                if(currentRow.columnIndex() == col){
                    previousRow.setColNext(currentRow.colNext());
                    currentRow.setValue(null);
                    currentRow.setColNext(null);
                }

                previousRow = rowHead;
                while (previousRow.rowNext() != null && previousRow.rowNext().rowIndex() < row){
                    previousRow = previousRow.rowNext();
                }
                if(previousRow.rowNext().colNext() == null){
                    previousRow.setRowNext(previousRow.rowNext().rowNext());
                }
            }
            while(currentColumn.colNext() != null && currentColumn.colNext().columnIndex() <= col){
                currentColumn = currentColumn.colNext();
            }
            if (currentColumn.columnIndex() == col) {
                while(previousColumn.columnIndex() != currentColumn.columnIndex()){
                    previousColumn = previousColumn.colNext();
                }
                while(currentColumn.rowNext() != null && currentColumn.rowNext().rowIndex() <= row){
                    currentColumn = currentColumn.rowNext();
                }
                while(previousColumn.rowNext().rowIndex() < currentColumn.rowIndex()){
                    previousColumn = previousColumn.rowNext();
                }
                if(currentColumn.rowIndex() == row){
                    previousColumn.setRowNext(currentColumn.rowNext());
                    currentColumn.setValue(null);
                    currentColumn.setRowNext(null);
                }

                previousColumn = columnHead;
                while (previousColumn.colNext() != null && previousColumn.colNext().columnIndex() < col){
                    previousColumn = previousColumn.colNext();
                }
                if (previousColumn.colNext().rowNext() == null){
                    previousColumn.setColNext(previousColumn.colNext().colNext());
                }
            }
        }
    }


    /** Read the sparse array from the file with the given filename
     *
     * @param filename name of the input file
     */
    @Override
    public void readFromFile(String filename) throws Exception{
        File file = new File(filename);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null){
                int row;
                int column;
                Object value;
                //row = new Integer(line.split(","));


            }
        }
        catch (FileNotFoundException e) {
        System.out.println("Could not open file: " + e);
        return;
        } catch (IOException e) {
        System.out.println("Could not read from file: " + e);
        return;
        }


    }


    /**
     * Outputs the sparse array to the file with the given filename.
     * Prints only row, col on each line.
     *
     */
    @Override
    public void printToFile(String filename) {
        // FILL IN CODE

    }


    // Add other methods as needed - like the method that counts neighbors of the cell etc.
}