public class FileCommandHandler {

    public void processCommand(Command command) {
        Action action = command.getAction();
        System.out.println("Обработка команды. Действие: "
                + command.getAction().name()
                + ", данные: " + command.getData());
        switch (action) {
            case CREATE -> processCreateCommand(command);

            case UPDATE -> processUpdateCommand(command);

            case SEARCH -> processSearchCommand(command);

            default -> System.out.println("Действие " + action + " не поддерживается");
        }
    }

    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(", ");
        try {
            Filee file = new Filee();
            file.setName(dataArray[0]);
            file.setDirectory(dataArray[1]);
            file.setText(dataArray[2]);
            file.create();
        } catch (Exception e) {
            errorMessage();
        }
    }

    private void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(", ");
        try {
            Filee file = new Filee();
            file.setName(dataArray[0]);
            file.setDirectory(dataArray[1]);
            file.setText(dataArray[2]);
            file.update();
        } catch (Exception e) {
            errorMessage();
        }
    }

    private void processSearchCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(", ");

        try {
            Filee file = new Filee();
            file.setName(dataArray[0]);
            file.setDirectory(dataArray[1]);
            file.search();
        } catch (Exception e) {
            errorMessage();
        }
    }

    private void errorMessage() {
        System.out.println("Неподдерживаемый формат, попробуйте заново");
    }
}
