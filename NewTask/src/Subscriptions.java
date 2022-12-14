import java.util.Date;

public class Subscriptions {

    private int SubscriptionID;
    private String  dateTime;
    private int CustomerID;
    private int TrainerID;
    private int ExerciseID;


    public Subscriptions(int subscriptionID, String dateTime, int customerID, int trainerID, int exerciseID) {
        SubscriptionID = subscriptionID;
        this.dateTime = dateTime;
        CustomerID = customerID;
        TrainerID = trainerID;
        ExerciseID = exerciseID;
    }


    public int getSubscriptionID() {
        return SubscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        SubscriptionID = subscriptionID;
    }

    public String  getDateTime() {
        return dateTime;
    }

    public void setDateTime(String  dateTime) {
        this.dateTime = dateTime;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public int getExerciseID() {
        return ExerciseID;
    }

    public void setExerciseID(int exerciseID) {
        ExerciseID = exerciseID;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "SubscriptionID=" + SubscriptionID +
                ", dateTime='" + dateTime + '\'' +
                ", CustomerID=" + CustomerID +
                ", TrainerID=" + TrainerID +
                ", ExerciseID=" + ExerciseID +
                '}';
    }
}
