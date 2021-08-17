package model.dto;

import java.util.Arrays;

public class InputNumberDTO {
    private final String[] inputTokens;
    private static final String BASEBALL_NUMBER_REGEX = "^[0-9]*$";

    public InputNumberDTO(String inputString) {
        inputTokens = inputString.split("");
        if(hasCharacter()) {
            throw new IllegalArgumentException("숫자가 아닌 입력이 있습니다.");
        }
    }

    private boolean hasCharacter() {
        return Arrays.stream(inputTokens)
                .anyMatch(token -> !token.matches(BASEBALL_NUMBER_REGEX));
    }

    public int[] getValidatedInput() {
        return Arrays.stream(inputTokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
