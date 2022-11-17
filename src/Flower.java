public class Flower {
    private String title;
    private String country;
    private float cost;
    private int lifeSpan;

    public Flower(String title, String country,float cost,int lifeSpan){
        setTitle(title);
        setCountry(country);
        setCost(cost);
        setLifeSpan(lifeSpan);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = validOrDefault(title, "Rose");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = validOrDefault(country,"Russia");
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = Math.max(cost, 1);
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan > 0 ? lifeSpan : 3;
    }

    public static String validOrDefault(String value, String defaultValue){
        return value == null || value.isBlank() ? defaultValue : value;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", cost=" + cost +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
