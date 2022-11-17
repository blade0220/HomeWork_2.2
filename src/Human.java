import java.time.LocalDate;

public class Human {
    private static final String DEFAULT_STRING_VALUE = "Информация не указана";
    private String name;
    private String town;
    private int yearOfBirth;
    private String jobTitle;

    public Human(String name, String town, int yearOfBirth, String jobTitle) {
        setName(name);
        setTown(town);
        setYearOfBirth(yearOfBirth);
        setJobTitle(jobTitle);
    }

    public String getName(){
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = validOrDefault(name,DEFAULT_STRING_VALUE);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = validOrDefault(town,DEFAULT_STRING_VALUE);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = Math.max(yearOfBirth, 0);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = validOrDefault(jobTitle,DEFAULT_STRING_VALUE);
    }

    private String validOrDefault(String value, String defaultValue){
        if (value == null || value.isBlank()) {
            return defaultValue;
        }else {
            return value;
        }
    }

    private int getAgeInYears() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - this.yearOfBirth;
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ". Я из города "  + town + ". Мне " + getAgeInYears() +
                " лет. Я работаю на должности " + jobTitle + ". Будем знакомы!";
    }

}
