package IstaPay;

public interface  Bill extends Transfer {
    //public float calcAmount(float usage);
    public double calcAmount(double usage);
}
