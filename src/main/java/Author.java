import java.time.LocalDate;

public class Author {
    private final int ID;
    private final String name;
    private String bio;
    private final String gender;
    private final LocalDate birthDate;
    private LocalDate deathDate;

    public Author(int ID, String name, String bio, String gender, LocalDate birthDate, LocalDate deathDate) {
        if (name == null || birthDate == null) {
            throw new IllegalArgumentException("Author name and birth date are required");
        }
        this.ID = ID;
        this.name = name;
        this.bio = bio;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;

    }
    // SETTERS
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    // GETTERS
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getBio() {
        return bio;
    }
    public String getGender() {
        return gender;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // PRINT
    @Override
    public String toString() {
        return "Author: " + this.name;
    }
}
