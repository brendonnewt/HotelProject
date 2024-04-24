package edu.baylor.GroupFive.database.daos;
import edu.baylor.GroupFive.database.DbSetup;

import edu.baylor.GroupFive.models.Room;
import edu.baylor.GroupFive.models.enums.Theme;
import edu.baylor.GroupFive.models.enums.BedType;
import edu.baylor.GroupFive.models.enums.Quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoomDAOTest {

    @BeforeEach
    void init(){
        DbSetup db = new DbSetup();
    }

    @Test
    void addARoom(){
        DbSetup db = new DbSetup();
        Room newRoom = new Room(995, Quality.ECONOMY, Theme.UrbanElegance, true, 5, BedType.KING, 12.34);
        RoomDAO conn = new RoomDAO();
        Integer added = conn.save(newRoom);
        assert(added.equals(1));
    }

    @Test
    void addAndGetRoom(){
        DbSetup db = new DbSetup();
        Room newRoom = new Room(995, Quality.COMFORT, Theme.NatureRetreat, true, 5, BedType.KING, 12.34);
        RoomDAO conn = new RoomDAO();
        Integer added = conn.save(newRoom);
        Room pulledRoom = conn.get(995);
        System.out.println(pulledRoom.getDailyPrice());
        assert(pulledRoom.equals(newRoom));
    }

    @Test
    void getSetupRoom(){
        DbSetup db = new DbSetup();
        RoomDAO conn = new RoomDAO();
        Room pulledRoom = conn.get(109);
        assert(pulledRoom != null);
    }

    @Test
    void getNonexistingRoom(){
        DbSetup db = new DbSetup();
        RoomDAO conn = new RoomDAO();
        Room pulledRoom = conn.get(1709);
        assert(pulledRoom == null);
    }


    @Test
    void modifyRoom(){
        DbSetup db = new DbSetup();
        Room myRoom = new Room(99, Quality.EXECUTIVE, Theme.VintageCharm,true, 11, BedType.KING, 90D);
        RoomDAO conn = new RoomDAO();

        Integer added = conn.save(myRoom);
        if(added != 1){
            System.out.println("Initial add failed");
            assert false;
        }

        myRoom.setNumBeds(6);

        Integer isModified = conn.update(myRoom);
        if(isModified != 1){
            System.out.println("Initial modify failed");
            assert false;
        }

        Room modifiedRoom = conn.get(99);
        assert(modifiedRoom.getNumBeds().equals(6));
    }

}
