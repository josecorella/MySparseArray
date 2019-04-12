package sparseArray;

/**
 * sparseArray Interface. Stores a sparse matrix in linked lists of linked lists.
 * See project description for details.
 * Needs to be implemented by class MySparseArray
 */
public interface SparseArray  {
    Object getDefaultValue();
    Object elementAt(int row, int col);
    void setValue(int row, int col, Object value);
    void readFromFile(String filename) throws Exception;
    void printToFile(String filename);
}