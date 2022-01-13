package inside.test.task.service;

import inside.test.task.entity.MessageEntity;
import inside.test.task.entity.UserEntity;
import inside.test.task.repository.MessageEntityRepository;
import inside.test.task.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private MessageEntityRepository messageEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    public void SaveMessage (MessageEntity inputMessage) {
        messageEntityRepository.save(inputMessage);
    }

    public String getHistory () {
        StringBuilder str = new StringBuilder();
        List<MessageEntity> messages = messageEntityRepository.findAll();

        for (MessageEntity message : messages) {
            str
                    .append(message.getMessage())
                    .append("\n");
        }

        return str.toString();
    }


}
