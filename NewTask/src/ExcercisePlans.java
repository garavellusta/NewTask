public class ExcercisePlans {

    private int PlanID;
    private int TrainerID;
    private int EquipmentID;
    private int Duration;

    public ExcercisePlans(int planID,  int trainerID, int equipmentID,int duration) {
        PlanID = planID;
        TrainerID = trainerID;
        EquipmentID = equipmentID;
        Duration = duration;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int planID) {
        PlanID = planID;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public int getEquipmentID() {
        return EquipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        EquipmentID = equipmentID;
    }

    @Override
    public String toString() {
        return "ExcercisePlans{" +
                "PlanID=" + PlanID +
                ", TrainerID=" + TrainerID +
                ", EquipmentID=" + EquipmentID +
                ", Duration=" + Duration +
                '}';
    }
}
