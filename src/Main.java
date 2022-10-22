import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> list = generateClients();
        Queue<Person> queue = new LinkedList<>();

        for (Person element : list) {
            queue.offer(element);
        }

        while (!queue.isEmpty()) {
            Person visitor = queue.poll();
            visitor.spendTicket();
            System.out.println(visitor.getName() + " " + visitor.getSurname() + " прокатился/-лась на аттракционе. Осталось билетов: " + visitor.getTicket() + " шт.");
            if (visitor.getTicket() > 0) {
                queue.offer(visitor);
            }
        }
    }

    public static List<Person> generateClients() {
        int COUNT = 5;

        Person visitor1 = new Person("Татьяна", "Иванова", 3);
        Person visitor2 = new Person("Ирина", "Бузова", 2);
        Person visitor3 = new Person("Анастасия", "Сахарова", 4);
        Person visitor4 = new Person("Пётр", "Давидов", 1);
        Person visitor5 = new Person("Екатерина", "Шишкова", 2);
        Person visitor6 = new Person("Арман", "Даилян", 5);
        Person visitor7 = new Person("Альберт", "Шерп", 2);
        Person visitor8 = new Person("София", "Соловьева", 1);
        Person visitor9 = new Person("Дарья", "Бирюкова", 3);
        Person visitor10 = new Person("Инакентий", "Доров", 3);

        List<Person> visitorsArray = new ArrayList<>() {
            {
                add(visitor1);
                add(visitor2);
                add(visitor3);
                add(visitor4);
                add(visitor5);
                add(visitor6);
                add(visitor7);
                add(visitor8);
                add(visitor9);
                add(visitor10);
            }
        };

        List<Person> visitorsRandom = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < COUNT; i++) {
            int randomInt = random.nextInt(visitorsArray.size());
            Person element = visitorsArray.get(randomInt);
            visitorsRandom.add(element);
            visitorsArray.remove(element);
        }

        return visitorsRandom;
    }
}