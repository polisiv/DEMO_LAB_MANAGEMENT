package src.functions;

import src.types.Experiment;

import java.util.List;

public interface trackable {
    <T> List<Experiment> search(T info);
    void getDetail(String name);
}
