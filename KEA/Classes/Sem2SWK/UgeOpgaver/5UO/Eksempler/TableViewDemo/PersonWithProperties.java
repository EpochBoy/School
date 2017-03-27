import javafx.beans.property.SimpleStringProperty;

/**
 * Created by signeborch on 07/03/16.
 */
public class PersonWithProperties
{

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty job;

    public PersonWithProperties(String firstName, String lastName, String job){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.job = new SimpleStringProperty(job);


    }

    public String getFirstName()
    {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }

    public String getLastName()
    {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }

    public String getJob()
    {
        return job.get();
    }

    public SimpleStringProperty jobProperty()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job.set(job);
    }
}
