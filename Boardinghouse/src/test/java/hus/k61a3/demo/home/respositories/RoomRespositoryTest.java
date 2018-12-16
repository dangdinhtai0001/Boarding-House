package hus.k61a3.demo.home.respositories;

import hus.k61a3.demo.home.repositories.RoomRepositoriy;
import org.junit.Assert;
import org.junit.Test;
import hus.k61a3.demo.home.domains.Room;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class RoomRespositoryTest {
    RoomRepositoriy roomRepositoriy = null;
    @Test(expected = NullPointerException.class)
    public void search_NoRoomEntriesFound_ShouldReturnEmptyList(){
        List<Room> rooms = roomRepositoriy.findRandomRoom(0);
        Assert.assertThat(rooms.size(), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void search_OneRoomEntryFound_ShouldReturnAListOfOneEntry(){
        List<Room> rooms = roomRepositoriy.findRandomRoom(1);
        Assert.assertThat(rooms.size(), is(1));
        Assert.assertThat(rooms.get(0), allOf(
                hasProperty("id", is(1L)),
                hasProperty("name", is("R001")),
                hasProperty("is_saled", is("1")),
                hasProperty("recommend", is(2)),
                hasProperty("floor", is(3)),
                hasProperty("price", is(1500000)),
                hasProperty("square", is(15)),
                hasProperty("closed", is(1)),
                hasProperty("bathroom", is(1)),
                hasProperty("window", is(1)),
                hasProperty("image", is("/images/bg-img/feature1.jpg")),
                hasProperty("description", is("Phong sach se, thoang mat"))));
    }

    @Test(expected = NullPointerException.class)
    public void search_TwoRoomEntriesFound_shouldReturnAListOfTwoEntry(){
        List<Room> rooms = roomRepositoriy.findRandomRoom(2);
        Assert.assertThat(rooms.size(), is(2));
        Assert.assertThat(rooms, contains(
                allOf(
                hasProperty("id", is(1L)),
                hasProperty("name", is("R002")),
                hasProperty("is_saled", is("0")),
                hasProperty("recommend", is(2)),
                hasProperty("floor", is(3)),
                hasProperty("price", is(1700000)),
                hasProperty("square", is(13)),
                hasProperty("closed", is(1)),
                hasProperty("bathroom", is(1)),
                hasProperty("window", is(1)),
                hasProperty("image", is("/images/bg-img/feature2.jpg")),
                hasProperty("description", is("Phong sach se, thoang mat"))),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("name", is("R002")),
                        hasProperty("is_saled", is("0")),
                        hasProperty("recommend", is(2)),
                        hasProperty("floor", is(3)),
                        hasProperty("price", is(1700000)),
                        hasProperty("square", is(13)),
                        hasProperty("closed", is(1)),
                        hasProperty("bathroom", is(1)),
                        hasProperty("window", is(1)),
                        hasProperty("image", is("/images/bg-img/feature3.jpg")),
                        hasProperty("description", is("Phong sach se, thoang mat")))
        ));
    }
}
