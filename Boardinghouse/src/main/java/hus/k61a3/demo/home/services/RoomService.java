package hus.k61a3.demo.home.services;

import hus.k61a3.demo.home.repositories.RoomRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepositoriy roomRepositoriy;
}
