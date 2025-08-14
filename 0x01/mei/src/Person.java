import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(){}

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer, float salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
        this.salary = salary;
    }

    public String fullName() {
        return name + " " + surname;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    // Calcula idade através da birthDate
    public int calculateAge() {
        // converte birthDate para LocalDate
        LocalDate dataNascimento = this.birthDate.toInstant()
                .atZone(ZoneId.systemDefault()) // csa fuso horário do sistema
                .toLocalDate();

        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int age = periodo.getYears();

        return age;
    }

    public boolean isMEI() {
        int age = calculateAge();
        return (calculateYearlySalary() < 130000)
                && age > 18
                && !anotherCompanyOwner
                && !pensioner
                && !publicServer;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAnotherCompanyOwner() {
        return anotherCompanyOwner;
    }

    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) {
        this.anotherCompanyOwner = anotherCompanyOwner;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    public boolean isPublicServer() {
        return publicServer;
    }

    public void setPublicServer(boolean publicServer) {
        this.publicServer = publicServer;
    }
}
