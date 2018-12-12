package hus.k61a3.demo.listings;
import hus.k61a3.demo.home.repositories.HomeRepository;
import hus.k61a3.demo.home.repositories.RoomRepositoriy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ListingsServiceTest {
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private RoomRepositoriy roomRepositoriy;

    @Test
    public void testDisplayListings(){

    }
}
