/**
 * Given a CSV file, we will read the data from the CSV file and parses each
 * line of the file. See the operations that are performed after reading the
 * file.
 * 
 * @author Siva Sankar
 * @author Nemnous
 */

import java.util.Arrays;

public class CSVReader {
    String[] dataFrame;

    /**
     * This function is used to read the given csv File This uses functions from the
     * ReadCSVFile class
     * 
     * @param fileName - name of the given csv file
     */
    public void readCSV(String fileName) {
        dataFrame = ReadCSVFile.readFile(fileName);
    }

    /**
     * The number of rows in the given data frame. Note: This shouldn't include 
     * the coloumn labels.
     * 
     * @return -1 if the Data set is empty
     */
    public int rowCount() {
        // TODO
        // Your code goes here....
        int numberOfRows = dataFrame.length - 1;
        return numberOfRows;
    }

    /**
     * This method returns the count of coloumns in a data Frame.
     * @return the count of columns in the dataset and -1 otherwise.
     */
    public int fieldCount() {
        // TODO
        // Your code goes here....
        int numberOfRows = rowCount();
        if (numberOfRows != -1) {
            String[] fields = dataFrame[0].split(",");
            int count = fields.length;
            return count;
        }

        return -1;
    }

    /**
     * This method returns the name of the column based on the index 
     * passed as a parameter
     * 
     * @param index index of the coloumn starting from 1.
     * @return the column name based on the index and null otherwise.
     */
    public String getFieldName(int index) {
        // TODO
        // Your code goes here....
        int numberOfRows = rowCount();
        if (numberOfRows != -1) {
            String[] fields = dataFrame[0].split(",");
            if (index >= 1 && index <=fields.length) {
                String fieldName = fields[index - 1];
                return fieldName;
            }
        } 

        return null;
    }


    /**
     * This method returns the row (array of values) based on the parameter 
     * passed to the method.
     * 
     * @param rowNumber given the Row of the row indexing from 1. Exclude the column
     * header row
     * 
     * @return the string array containing the contents of the entire row.
     */
    public String[] getRow(int rowNumber) {
        // TODO
        // Your code goes here....
        int numberOfRows = rowCount();
        if(numberOfRows != -1 && rowNumber <= numberOfRows && rowNumber >0) {
            String[] row  = dataFrame[rowNumber].split(",");
            return row;
        }

        return null;
    }

    /**
     * This method returns the rows (String array) based on fromIndex and toIndex.
     * The fromIndex and toIndex should be in the range of the dataset lengths.
     * 
     * @param fromIndex given from index
     * @param toIndex   given to index
     * @return String array containing the rows starting from the fromindex to the
     *         toindex. Append the entire row to the string array comma separated.
     */
    public String[] getRows(int fromIndex, int toIndex) {
        // TODO
        // Your code goes here....
        int numberOfRows = rowCount();
        int rowSize = toIndex - fromIndex;
        int j = 0;
        String[] rows = new String[rowSize];
        if (numberOfRows == -1) {
            return null;
        }
        if(fromIndex < 0 || fromIndex > numberOfRows || fromIndex == toIndex) {
            return null;
        }
        if(toIndex < 0 || toIndex > numberOfRows  || fromIndex > toIndex ) {
            return null;
        }
        for(int i = fromIndex; i < toIndex ; i++) {
            rows[j] = dataFrame[i];
            j++;
        }
        return rows;

    }

    /**
     * This method returns the column values based on particular column index.
     * 
     * @param index index of the column
     * @return all the values of the column as a string array
     */
    public String[] getColumnValues(final int index) {
        // TODO
        // Your code goes here....
        int numberOfRows = rowCount();
        if (numberOfRows != -1) {
            String[] s = new String[numberOfRows];
            for(int i = 1; i < numberOfRows + 1; i++) {
                String[] data = dataFrame[i].split(",");
                s[i-1] = data[index];
            }
            return s;
        }      
        return null;
    }
    public String[] getDataFrame() {
        return dataFrame;
    }
    public void setDataFrame(final String[] dataFrame1) {
        this.dataFrame = dataFrame1;
    }
}