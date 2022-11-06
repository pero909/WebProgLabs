
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.service.BaloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BallonServiceImp implements BaloonService {
    private final BalloonRepository balloonRepository;

    public BallonServiceImp(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBallons();
    }

    public Optional<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> searchByNameAndDescription(String name, String desc) {
        return balloonRepository.findAllByNameAndDescription(name,desc);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public Optional<Balloon> save(String name,Long id, String description, Manufacturer manufacturer) {
        return balloonRepository.save(name,id,description,manufacturer);
    }

    @Override
    public void deleteById(Long id) {
       this.balloonRepository.deleteById(id);
    }
}
