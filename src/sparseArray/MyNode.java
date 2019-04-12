package sparseArray;

/** The node of the sparse array -- implements Node interface. */
public class MyNode implements Node {
    // Add instance variables:
    // index of the row, index of the column, and value
    private int row;
    private int column;
    private Object node_Value;
    // pointer to the next node in the row and
    private Node nextRow;
    // pointer to the next node in the column
    private Node nextColumn;
    // FILL IN CODE

    /**
     * MatrixNode constructor
     * @param rowIndex row
     * @param columnIndex column
     * @param value value
     */
    public MyNode(int rowIndex, int columnIndex, Object value) {
        // FILL IN CODE
        this.row = rowIndex;
        this.column = columnIndex;
        this.node_Value = value;

    }

    /**
     * RowNext setter.
     * @param node
     */
    public void setRowNext(Node node){
        /* FILL IN CODE */
        this.nextRow = node;
    }

    /**
     * ColNext setter.
     * @param node
     */
    public void setColNext(Node node){
        // FILL IN CODE
        this.nextColumn = node;
    }

    /**
     * Value setter.
     * @param value
     */
    public void setValue(Object value){
        // FILL IN CODE
        this.node_Value = value;
    }

    /**
     * RowNext getter.
     * @return
     */
    public Node rowNext(){
        // FILL IN CODE
        return this.nextRow; // change it
    }

    /**
     * ColNext getter.
     * @return
     */
    public Node colNext() {
        // FILL IN CODE
        return this.nextColumn; // change it
    }

    /**
     * Return row Index.
     * @return
     */
    @Override
    public int rowIndex(){
        // FILL IN CODE

        return this.row; // change
    }

    /**
     * Return column index.
     * @return
     */
    @Override
    public int columnIndex(){
        // FILL IN CODE
        return this.column; // change
    }

    /**
     * Return node value.
     * @return
     */
    @Override
    public Object value(){
        // FILL IN CODE
        return this.node_Value; // change
    }
}