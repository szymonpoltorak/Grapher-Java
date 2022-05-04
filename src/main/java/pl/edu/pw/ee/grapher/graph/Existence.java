package pl.edu.pw.ee.grapher.graph;

import java.util.Objects;

public class Existence {
    private boolean existUp;
    private boolean existDown;
    private boolean existLeft;
    private boolean existRight;

    public Existence(){
        this.existDown = false;
        this.existLeft = false;
        this.existUp = false;
        this.existRight = false;
    }

    public boolean isExistDown() {
        return existDown;
    }

    public boolean isExistLeft() {
        return existLeft;
    }

    public boolean isExistUp() {
        return existUp;
    }

    public boolean isExistRight() {
        return existRight;
    }

    public void setExistDown(boolean existDown) {
        this.existDown = existDown;
    }

    public void setExistLeft(boolean existLeft) {
        this.existLeft = existLeft;
    }

    public void setExistRight(boolean existRight) {
        this.existRight = existRight;
    }

    public void setExistUp(boolean existUp) {
        this.existUp = existUp;
    }

    @Override
    public String toString(){
        return "UpExist: " + existUp + " DownExist: " + existDown +" RightExist: " + existRight + " LeftExist: "
                + existLeft + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }

        if (object == null || getClass() != object.getClass()){
            return false;
        }

        Existence existence = (Existence) object;

        return existUp == existence.existUp && existDown == existence.existDown && existLeft == existence.existLeft
                && existRight == existence.existRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(existUp, existDown, existLeft, existRight);
    }
}
