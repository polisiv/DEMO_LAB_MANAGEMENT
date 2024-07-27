package src.database;
import src.functions.removable;
import src.functions.trackable;
import src.functions.updatable;
import src.types.Experiment;
import src.types.Long_term;
import src.types.Short_term;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database implements trackable, removable, updatable {


    private ArrayList<Experiment> experimentArrayList = new ArrayList<>();

    public Database(ArrayList<Experiment> list) {
        experimentArrayList = list;
    }

    @Override
    public <T> void remove(T info) {
        List<Experiment> matchingExperiments = search(info);
        if (!matchingExperiments.isEmpty()) {
            for (Experiment exp : matchingExperiments) {
                updateId(exp.getId());
                experimentArrayList.remove(exp);
            }
            System.out.println("Successfully removed");
            System.out.println("IDs have been updated.");
        } else {
            System.out.println("No experiments matched the provided information.");
        }
    }

    @Override
    public void updateId(Integer position) {
        for (Experiment exp : experimentArrayList) {
            if (exp.getId() > position) {
                exp.setId(exp.getId() - 1);
            }

        }
    }

    @Override
    public <T> List<Experiment> search(T info) {
        List<Experiment> matchingExperiments = new ArrayList<>();
        for (Experiment exp : experimentArrayList) {
            if (info instanceof Integer) {
                if (exp.getId() == (Integer) info) {
                    matchingExperiments.add(exp);
                }
            }
            if (info instanceof String) {
                if (exp.getName().equalsIgnoreCase((String) info)) {
                    matchingExperiments.add(exp);
                }
                for (String element : exp.getChemicals()) {
                    if (element.equalsIgnoreCase((String) info)) {
                        matchingExperiments.add(exp);
                        break;
                    }
                }
            }
        }
        return matchingExperiments;
    }

    @Override
    public void update(String name, String updatedSection, String updatedInfo) {
        if(!search(name).isEmpty()){
            List<Experiment> data = search(name);
            for(var i: data) {
                switch (updatedSection) {
                    case "description": {
                        i.setDescription(updatedInfo);
                        break;
                    }
                    case "materials": {
                        i.setMaterials(updatedInfo);
                        break;
                    }
                    default:
                        System.out.println("invalid updated section");
                }
                System.out.println("Information updated successfully");
            }
        }
        else{
            System.out.println("Information is not found");
        }

    }

    @Override
    public void add(ArrayList<Experiment> list) {
        experimentArrayList = list;
    }

    public void getExperimentList() {
        getLongTerm();
        getShortTerm();
    }

    public void getLongTerm() {
        System.out.println("LONG TERM EXPERIMENT");
        for (Experiment experiment : experimentArrayList) {
            if (experiment instanceof Long_term) {
                System.out.printf("""
                        Id: %d
                        Name: %s
                        Description: %s
                        ---------------------------
                        """.formatted(experiment.getId(), experiment.getName(),experiment.getDescription()));
            }
        }
    }

    public void getShortTerm() {
        System.out.println("SHORT TERM EXPERIMENT");
        for (Experiment experiment : experimentArrayList) {
            if (experiment instanceof Short_term) {
                System.out.printf("""
                        Id: %d
                        Name: %s
                        ---------------------------
                        """.formatted(experiment.getId(), experiment.getName()));
            }
        }
    }

    public void getDetail(String name) {
        if (!search(name).isEmpty()) {
            for (var i : experimentArrayList) {
                if (i.getName().equalsIgnoreCase(name)) {
                    i.displayInfo();
                }
            }
        } else {
            System.out.println("Data not found");
        }
    }

}
