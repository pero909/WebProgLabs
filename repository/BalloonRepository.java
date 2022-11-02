import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    public List<Balloon> findAllBallons(){
        return DataHolder.balloonList;
    }
    public Optional<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream().filter(balloon ->
                balloon.getName().equals(text)
                        || balloon.getDescription().equals(text))
                .findFirst();
    }
}
