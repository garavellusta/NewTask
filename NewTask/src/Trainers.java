public class Trainers {

    private int TrainerID;
    private String Name;

    public Trainers(int trainerID,String name) {
        TrainerID = trainerID;
        Name = name;

    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
