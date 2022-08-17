public class ExcercisePlans {

    private int PlanID;
    private int Duration;
    private int TrainerID;
    private int EquipmentID;

    public ExcercisePlans(int planID, int duration, int trainerID, int equipmentID) {
        PlanID = planID;
        Duration = duration;
        TrainerID = trainerID;
        EquipmentID = equipmentID;
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
}
