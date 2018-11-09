package hus.k61a3.demo.ultis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImp {

    @Autowired
    private ErrorRepository errorRepository;

    public Error getOne(String id){
        return errorRepository.getOne(id);
    }
}
