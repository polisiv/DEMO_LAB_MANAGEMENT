package src.types;

public class Experiment {

    private static Integer id = 0;
    private String name;
    private String description;
    private String materials;
    private String[] chemicals;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getChemicals() {
        return chemicals;
    }

    public Experiment(String name, String description, String materials) {
        this.name = name;
        this.description = description;
        this.materials = materials;
        chemicals = materials.split(",");
        id++;
    }

    public void displayInfo(){
        System.out.printf("""
                Id: %d
                Name: %s
                Materials: %s
                Description: %s
                """.formatted(id,name,materials,description));
    }

    public String toString(){
        return "This is a %s experiment called %s".formatted(getClass().getSimpleName(),getName());
    }
}
