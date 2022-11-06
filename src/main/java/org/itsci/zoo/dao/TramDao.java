package org.itsci.zoo.dao;
import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;
import java.util.List;
public interface TramDao {
    List<Tram> getTram();
    void saveTram(Tram trams);
    Tram getTram(int id);
    void deleteTram(int id);
    List<Animal> getAnimalDoesNotHaveTram(int id);
}
