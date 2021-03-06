package pl.edu.pw.ee.grapher.utils;

import java.util.Objects;

import static pl.edu.pw.ee.grapher.utils.Constants.NO_MODE;

public class EntryData {
    private int mode;
    private int rows;
    private int columns;
    private float rangeStart;
    private float rangeEnd;
    private int startPoint;
    private int endPoint;
    private int printMode;

    public EntryData(int rows, int columns){
        this.printMode = NO_MODE;
        this.mode = NO_MODE;
        this.rows = rows;
        this.columns = columns;
        this.rangeEnd = 0;
        this.rangeStart = 0;
    }

    public EntryData(){
        this.printMode = NO_MODE;
        this.mode = NO_MODE;
        this.rows = 0;
        this.columns = 0;
        this.rangeEnd = 0;
        this.rangeStart = 0;
        this.startPoint = 0;
        this.endPoint = 0;
    }

    public int getPrintMode() {
        return printMode;
    }

    public void setPrintMode(int printMode) {
        this.printMode = printMode;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public float getRangeEnd() {
        return rangeEnd;
    }

    public float getRangeStart() {
        return rangeStart;
    }

    public int getMode() {
        return mode;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setRangeEnd(float rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public void setRangeStart(float rangeStart) {
        this.rangeStart = rangeStart;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public void setColumns(int columns){
        this.columns = columns;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        var entryData = (EntryData) object;
        return mode == entryData.mode && rows == entryData.rows && columns == entryData.columns && Float.compare(entryData.rangeStart, rangeStart) == 0 && Float.compare(entryData.rangeEnd, rangeEnd) == 0 && startPoint == entryData.startPoint && endPoint == entryData.endPoint && printMode == entryData.printMode;
    }

    @Override
    public int hashCode() {
        return 37 * Objects.hash(mode, rows, columns, rangeStart, rangeEnd, startPoint, endPoint, printMode);
    }

    @Override
    public String toString() {
        return "EntryData{" +
                "\nMode=" + mode +
                "\n rows=" + rows +
                "\n columns=" + columns +
                "\n rangeStart=" + rangeStart +
                "\n rangeEnd=" + rangeEnd +
                "\n startPoint=" + startPoint +
                "\n endPoint=" + endPoint +
                "\n printMode=" + printMode +
                "}\n";
    }
}
