package model;

public class Range {
    double left;
    double right;

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public boolean setRight(double right) {
        if(left<=right){
            this.right=right;
            return true;
        }
        return false;
    }
}
