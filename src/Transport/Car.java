package Transport;

import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    public float engineVolume;
    public String color;
    private final int year;
    private final String country;


    private String gearBox;
    private final String bodyType;
    private String regNumber;
    private final int placesCount;
    private boolean winterTires;

    private final Key key;
    private static Insurance insurance;


        public Car(String brand,
                   String model,
                   float engineVolume,
                   String color,
                   int year,
                   String country,
                   String gearBox,
                   String bodyType,
                   String regNumber,
                   int placesCount,
                   boolean winterTires, Key key, Insurance insurance) {
            this.brand = validOrDefault(brand, "Default");
            this.model = validOrDefault(model, "default");
            this.year = year >= 0 ? year : 2000;
            this.country = validOrDefault(country, "default");
            this.bodyType = validOrDefault(bodyType,"default");
            this.placesCount = Math.max(placesCount, 1);
            this.key = key;
//            this.key = getKey();
            this.insurance = insurance;
            setEngineVolume(engineVolume);
            setColor(color);
            setGearBox(gearBox);
            setRegNumber(regNumber);
            setWinterTires(winterTires);
        }

    public void setSeasonTires() {
        int currentMonth = LocalDate.now().getMonthValue();
        this.winterTires = currentMonth <= 4 || currentMonth >=11;
    }

    public boolean isRegNumberValid(){
            if (this.regNumber.length() !=9){
                return false;
            }
        char[] regNumberChars = this.regNumber.toCharArray();
            return isNumberLetter(regNumberChars[0])
            && isNumber(regNumberChars[1])
            && isNumber(regNumberChars[2])
            && isNumber(regNumberChars[3])
            && isNumberLetter(regNumberChars[4])
            && isNumberLetter(regNumberChars[5])
            && isNumber(regNumberChars[6])
            && isNumber(regNumberChars[7])
            && isNumber(regNumberChars[8]);
    }

    private boolean isNumber (char symbol){
            return Character.isDigit(symbol);
    }

    private boolean isNumberLetter (char symbol){
            String allowedSymbols = "АВЕКМНОРСТУХ";
            return allowedSymbols.contains("" + symbol);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume > 0.0f ? engineVolume : 1.5f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validOrDefault(color, "White");
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = validOrDefault(gearBox,"default");
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = validOrDefault(regNumber, "default");
    }

    public int getPlacesCount() {
        return placesCount;
    }


    public boolean isWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    public static class Key {
           private final boolean remoteEngineStart;
           private final boolean keylessAccess;

           public Key(boolean remoteEngineStart, boolean keylessAccess){
               this.remoteEngineStart = remoteEngineStart;
               this.keylessAccess = keylessAccess;
           }

           public boolean isRemoteEngineStart(){
               return remoteEngineStart;
           }
           public boolean isKeylessAccess(){
               return keylessAccess;
           }
    }

    public static class Insurance{
            private final LocalDate validUntil;
            private final float cost;
            private final String number;

            public Insurance(LocalDate validUntil, float cost, String number){
                this.validUntil = validUntil != null ? validUntil : LocalDate.now().plusDays(10);
                this.cost = Math.max(cost, 1f);
                this.number = validOrDefault(number, "Default");
            }

            public boolean isNumberValid(){
                return number.length() == 9;
            }

            public boolean isInsuranceValid(){
                return LocalDate.now().isBefore(this.validUntil);
            }

    }

    public Key getKey() {
        return key;
    }

    public static Insurance getInsurance() {
        return insurance;
    }

    public static String validOrDefault(String value, String defaultValue){
            return value == null || value.isBlank() ? defaultValue : value;
        }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", gearBox='" + gearBox + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", placesCount=" + placesCount +
                ", winterTires=" + winterTires +
                ", key=" + key +
                ", insurance=" + insurance +
                '}';
    }
}