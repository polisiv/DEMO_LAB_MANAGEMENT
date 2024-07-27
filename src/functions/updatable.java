package src.functions;

import src.types.Experiment;

import java.util.ArrayList;

public interface updatable {
     void update(String name,String updatedSection, String updatedInfo);
     void add(ArrayList<Experiment> list);
}
