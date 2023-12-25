import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldSearchTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Запланировать обед");
        String[] subtasks = {"Молоко", "Картофель", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выпуск приложения", "Проект XYZ", "Среда после полудня");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Проект");
        Assertions.assertArrayEquals(expected, actual);
    }

    public void shouldAddSimpleTaskToTodos() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(1, "Покупки");

        todos.add(simpleTask);

        Task[] result = todos.findAll();
        Task[] expected = {simpleTask};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldAddMeetingToTodos() {
        Todos todos = new Todos();
        Meeting meeting = new Meeting(555, "Обсуждение проекта", "Проект ABC", "2023-01-01");

        todos.add(meeting);

        Task[] result = todos.findAll();
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldAddEpicToTodos() {
        Todos todos = new Todos();
        String[] subtasks = {"Задача 1", "Задача 2"};
        Epic epic = new Epic(123, subtasks);

        todos.add(epic);

        Task[] result = todos.findAll();
        Task[] expected = {epic};
        Assertions.assertArrayEquals(expected, result);
    }
}