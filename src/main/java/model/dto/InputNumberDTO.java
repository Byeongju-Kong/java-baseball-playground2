package model.dto;

import java.util.Arrays;

public class InputNumberDTO {
    private static final String BASEBALL_NUMBER_REGEX = "^[0-9]*$";
    private final String[] inputTokens;

    public InputNumberDTO(final String inputString) {
        inputTokens = inputString.split("");
        if(hasCharacter()) {
            throw new IllegalArgumentException("음수 혹은 특수문자가 입력되었습니다.");
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