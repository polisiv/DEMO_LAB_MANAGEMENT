package src.types;

import src.database.Database;
import src.functions.removable;
import src.functions.timable;
import src.functions.trackable;
import src.functions.updatable;

public class Long_term extends Experiment implements timable {

    private Integer id = 0;
    private static Integer nextId = 1;

    private String[] chemicals;
    private static long startTime;

    public void setId(Integer id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public Long_term(String name, String description, String materials) {
        super(name,description, materials);
        id = nextId;
        nextId++;
        chemicals = materials.split(",");
        startTime = System.currentTimeMillis();
    }

    @Override
    public double getDuration() {
        long currentTime = System.currentTimeMillis();
        long duration = (currentTime - startTime);
        return (double) duration/3_600_0000;
    }

    @Override
    public void displayInfo() {
        System.out.printf("""
                    LONG TERM EXPERIMENT
                Id: %d
                Name: %s
                Materials: %s
                Description: %s
                Experiment duration: %f (hours)
                ===============================
                """.formatted(getId(),getName(),getMaterials(),getDescription(),getDuration())
        );
    }

    public String toString(){
        return "LONG TERM EXPERIMENT: %s (ID: %d)".formatted(getName().toUpperCase(),getId());
    }
}
