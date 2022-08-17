public class Equipments {

    private int EquipmentID;
    private String Name;

    public Equipments(int equipmentID,String name) {
        EquipmentID = equipmentID;
        Name = name;
    }

    public int getEquipmentID() {
        return EquipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        EquipmentID = equipmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
