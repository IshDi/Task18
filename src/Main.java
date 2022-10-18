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
            System.out.println(visitor.getName() + " " + visitor.getSurname() + " прокатился/-лась на аттракционе. Осталось билетов" + visitor.getTicket() + " шт.");
            if (visitor.getTicket() > 0) {
                queue.offer(visitor);
            }
        }

    }

    public static <Pesron> List<Person> generateClients() {
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

        List<Pesron> visitorsArray = new ArrayList<>() {
            {
                add((Pesron) visitor1);
                add((Pesron) visitor2);
                add((Pesron) visitor3);
                add((Pesron) visitor4);
                add((Pesron) visitor5);
                add((Pesron) visitor6);
                add((Pesron) visitor7);
                add((Pesron) visitor8);
                add((Pesron) visitor9);
                add((Pesron) visitor10);
            }
        };

        List<Pesron> visitors = new LinkedList<>();

        Random random = new Random();
        int i = 0;
        while(i < COUNT) {
            int randomInt = random.nextInt(visitorsArray.size());
            Person element = (Person) visitorsArray.get(randomInt);
            ((LinkedList<Pesron>) visitors).add((Pesron) element);
            visitorsArray.remove(element);
            i++;
        }

        return (List<Person>) visitors;
    }
}



 //      Далее, в main, создайте очередь на аттракцион и заполните её людьми из списка,
 //      который вам вернёт метод generateClients().
 //      Теперь заведите бесконечный цикл, который делает итерации пока очередь не пуста.
 //      На каждой итерации вытаскивается из очереди следующий клиент,
 //      выводится на экран сообщения вида Алексей Нетоложко прокатился на аттракционе.
 //     При этом у клиента уменьшается количество билетов на 1 и, если оно не стало нулевым,
    //     он вставляется обратно в очередь в её конец.