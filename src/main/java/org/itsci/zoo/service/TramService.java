package org.itsci.zoo.service;
import org.itsci.zoo.model.Animal;
import org.itsci.zoo.model.Tram;

import java.util.List;

public interface TramService {

    List<Tram> getTrams();
    List<Animal> getAnimalDoesNotHaveTram(int id);
    public void saveTram(Tram tram);

    Tram getTram(int TramId);
    void deleteTram(int TramId);
    void updateTram(Tram TramEntity, Tram tram);
    void addAnimalToTram( int tramId,int animalId);

    void removeAnimalFromTram(int animalId,int tramId );

}
