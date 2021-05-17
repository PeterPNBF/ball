package ball;

public class Ball {
    public int color;
    public int no;
    public int count8;
    public int count10;
    public int count12;
    public int count20;
    public int count30;
    public int count50;
    public int count100;
    public int count;
    public float percent8;
    public float percent10;
    public float percent12;
    public float percent20;
    public float percent30;
    public float percent50;
    public float percent100;
    public float percent;

    public int hashCode() {
        return no;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Ball) {
            return no == ((Ball)obj).no;
        }
        return false;
    }
}
