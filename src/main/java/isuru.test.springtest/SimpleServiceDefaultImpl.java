package isuru.test.springtest;

import org.springframework.stereotype.Service;

@Service
public class SimpleServiceDefaultImpl implements SimpleService {
    public String performOperation(String input1, String input2) {
        return input1 + input2;
    }
}
