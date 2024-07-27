package src.types;
import src.functions.removable;
import src.functions.trackable;
import src.functions.updatable;

public class Short_term extends Experiment{
    private Integer id = 0;
    private static Integer nextId = 1;
    private String[] chemicals;

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public Short_term(String name, String description, String materials) {
        super(name,description, materials);
        id = nextId;
        nextId++;
        chemicals = materials.split(",");
    }

    @Override
    public void displayInfo() {
        System.out.printf("""
                    SHORT TERM EXPERIMENT
                Id: %d
                Name: %s
                Materials: %s
                Description: %s
                ===============================
                """.formatted(getId(),getName(),getMaterials(),getDescription())
        );
    }

    public String toString(){
        return "SHORT TERM EXPERIMENT: %s (ID: %d)".formatted(getName().toUpperCase(),getId());
    }

}
