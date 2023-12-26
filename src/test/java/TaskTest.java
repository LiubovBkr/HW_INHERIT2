import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testSimpleTaskWhenMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("родителям");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskWhenNotMatches() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        boolean actual = simpleTask.matches("Родителям");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchQueryForEpic() {
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertTrue(epic.matches("Task 2"));
        Assertions.assertFalse(epic.matches("Task 4"));
    }

    @Test
    public void shouldNotMatchEpicByQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("не совпадает");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldNotMatchEpicBySubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean result = epic.matches("не совпадает");
        Assertions.assertFalse(result);
    }


    @Test
    public void shouldMatchQueryForMeeting() {
        Meeting meeting = new Meeting(2, "Обсуждение проекта", "Проект X", "2023-01-01 14:00");
        Assertions.assertTrue(meeting.matches("Проект X"));
        Assertions.assertFalse(meeting.matches("Проект Y"));
    }

    @Test
    public void shouldMatchEpicBySubtask() {
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("Task 2"));
    }

    @Test
    public void shouldMatchMeetingByTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение СберБанка", "Во вторник после обеда");

        boolean result = meeting.matches("версии");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotMatchMeetingByTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение СберБанка", "Во вторник после обеда");

        boolean result = meeting.matches("не совпадает");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldNotMatchSimpleTaskByTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить подруге");

        boolean result = simpleTask.matches("не совпадает");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldMatchEpicBySubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean result = epic.matches("Молоко");
        Assertions.assertTrue(result);
    }


    @Test
    public void shouldMatchEpicByQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean result = epic.matches("Молоко");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldMatchMeetingByQuery() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");

        boolean result = meeting.matches("версии");
        Assertions.assertTrue(result);
    }



    @Test
    public void shouldNotMatchMeetingByQuery() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения",
                "Приложение НетоБанка", "Во вторник после обеда");

        boolean result = meeting.matches("не совпадает");
        Assertions.assertFalse(result);
    }
}