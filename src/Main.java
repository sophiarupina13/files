import java.util.Scanner;

public class Main {

    private static FileCommandHandler fileCommandHandler = new FileCommandHandler();

    public static void main(String[] args) {

        while (true) {
            printInfo();
            Command command = readCommand();
            if (command.getAction() == Action.EXIT) {
                return;
            } else if (command.getAction() == Action.ERROR) {
                continue;
            } else {
                fileCommandHandler.processCommand(command);
            }
        }

    }

    private static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if (action.isRequireAdditionalData()) {
                printCommandMessage(actionCode);
                String data = scanner.nextLine();
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        } catch (Exception e) {
            System.out.println("Проблема обработки ввода. " + e.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void printInfo() {
        System.out.println("Выберите команду:\n" +
                "1. Записать файл\n" +
                "2. Перезаписать файл\n" +
                "3. Найти файл\n" +
                "4. Выход");
    }

    private static void printCommandMessage(Integer actionCode) {
        switch (actionCode) {
            case 1 ->
                    System.out.println("Введите данные в формате: имя файла, директория\\поддиректория(и), текст на сохранение");
            case 2 ->
                    System.out.println("Введите данные в формате: имя файла, директория\\поддиректория(и), новый текст");
            case 3 ->
                    System.out.println("Введите данные в формате: имя файла, директория\\поддиректория(и)");
        }
    }
}