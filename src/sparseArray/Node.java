package sparseArray;

/**
 * Interface implemented by the node of a sparse array.
 * See project description for details.
 */
public interface Node {
    int rowIndex();
    int columnIndex();
    Object value();
    Node rowNext();
    Node colNext();
    void setValue(Object value);
    void setRowNext(Node node);
    void setColNext(Node node);
}
