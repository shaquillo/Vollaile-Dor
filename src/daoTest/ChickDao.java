package daoTest;

import model.ChickClass;

import java.util.List;

public interface ChickDao {
    public List<ChickClass> chickList();
    public void addChick(ChickClass chick);
}
