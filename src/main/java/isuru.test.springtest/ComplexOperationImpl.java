package isuru.test.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ComplexOperationImpl implements ComplexOperation {

    @Autowired
    protected  SimpleService simpleService;

    @Value("${string.threashold}")
    private Integer stringThreashold;

    public String performComplexOperation(String[] input) {
        String result = "";

        if(input != null) {
            for (int i = 0; i < Math.min(stringThreashold, input.length); i++) {
                result = simpleService.performOperation(result, input[i]);
            }
        }
        return result;
    }
}
