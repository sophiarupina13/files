import java.util.Objects;
import java.util.stream.Stream;

public enum Action {
    CREATE(1, true),
    UPDATE(2, true),
    SEARCH(3, true),
    EXIT(4, false),
    ERROR(-1, false);

    private Integer code;
    private boolean requireAdditionalData;

    Action(Integer code, boolean requireAdditionalData) {
        this.code = code;
        this.requireAdditionalData = requireAdditionalData;
    }

    public Integer getCode() {
        return code;
    }

    public boolean isRequireAdditionalData() {
        return requireAdditionalData;
    }

    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия " + code);
                    return Action.ERROR;
                });
    }
}
