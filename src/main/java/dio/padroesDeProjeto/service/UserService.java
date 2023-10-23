package dio.padroesDeProjeto.service;

import dio.padroesDeProjeto.model.User;
import dio.padroesDeProjeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User saveUser(User user) {
        ofNullable(user).orElseThrow(() -> new RuntimeException("Cliente não pode ser nulo."));
        ofNullable(user.getAccount()).orElseThrow(() -> new RuntimeException("Conta não pode ser nulo."));
        ofNullable(user.getCard()).orElseThrow(() -> new RuntimeException("Cartão não pode ser nulo."));

        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new RuntimeException("Conta ja existe.");
        }

        if (userRepository.existsByCardNumber(user.getCard().getNumber())) {
            throw new RuntimeException("Cartão ja existe");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User model) {
        User user = getUserById(id);

        if (!user.getId().equals(id))
            throw new RuntimeException("ID's must be the same");

        user.setName(model.getName());
        user.setCard(model.getCard());
        user.setNews(model.getNews());
        user.setFeatures(model.getFeatures());
        user.setAccount(model.getAccount());

        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

}
