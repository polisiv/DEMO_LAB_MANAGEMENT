package src.functions;

import src.types.Experiment;

public interface removable {
    <T> void remove(T info);
    void updateId(Integer position);
}
