import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {
  private static List<Robot> robots = getList();

    public static void main(String[] args) {
        System.out.println("Selection of assistants");
        filterRobot(robots);
        System.out.println("\nSorting by strength");
        sortRobot(robots);
        System.out.println("\nChecking for strength > 100");
        allMatch(robots);
        System.out.println("\nChecking for speed < 2");
        anyMatch(robots);
        System.out.println("\nChecking for the absence dancer");
        noneMatch(robots);
        System.out.println("\nStrongest");
        max(robots);
        System.out.println("\nWeakest");
        min(robots);
        System.out.println("\nGroup");
        groupRobot(robots);
        System.out.println("\nallMethods");
        allMethods(robots);
    }

    private static void filterRobot(List<Robot> robots){
        robots.stream().filter(robot -> robot.getClassification().equals(Classification.ASSISTANT))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void sortRobot(List<Robot> robots){
        robots.stream().sorted(Comparator.comparing(Robot::getStrength))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void allMatch(List<Robot> robots){
        boolean all = robots.stream().allMatch(robot -> robot.getStrength() > 100);
        System.out.println(all);
    }

    private static void anyMatch(List<Robot> robots){
        boolean any = robots.stream().anyMatch(robot -> robot.getSpeed() < 2);
        System.out.println(any);
    }

    private static void noneMatch(List<Robot> robots){
        boolean none = robots.stream().noneMatch(robot -> robot.getClassification().equals(Classification.DANCER));
        System.out.println(none);
    }

    private static void max(List<Robot> robots){
        robots.stream().max(Comparator.comparing(Robot::getStrength)).ifPresent(System.out::println);
    }

    private static void min(List<Robot> robots){
        robots.stream().min(Comparator.comparing(Robot::getStrength)).ifPresent(System.out::println);
    }

    private static void groupRobot(List<Robot> robots){
        Map<Classification, List<Robot>> groupR = robots.stream()
                .collect(Collectors.groupingBy(Robot::getClassification));

        groupR.forEach((classification, robots1) -> {
            System.out.println(classification);
            robots1.forEach(System.out::println);
            System.out.println();
        });
    }

    private static void allMethods(List<Robot> robots){
        Optional<String> all = robots.stream().filter(robot -> robot.getClassification().equals(Classification.FIGHTER))
                .max(Comparator.comparing(Robot::getStrength)).map(Robot::getName);

        all.ifPresent(System.out::println);
    }

    private static List<Robot> getList(){

        return List.of(
          new Robot("Nikola", 20, 8, Classification.FIGHTER),
          new Robot("Albert", 4, 3, Classification.ASSISTANT),
          new Robot("Storm", 23, 9, Classification.FIGHTER),
          new Robot("Milty", 15, 12, Classification.MULTIPURPOSE),
          new Robot("Geny", 5, 3, Classification.ASSISTANT),
          new Robot("Proksy", 16, 7, Classification.MULTIPURPOSE),
          new Robot("bigBerta", 30, 6, Classification.FIGHTER),
          new Robot("Asti", 1, 6, Classification.ASSISTANT),
          new Robot("Pon", 6, 1, Classification.ASSISTANT),
          new Robot("Mika", 2, 5, Classification.ASSISTANT),
          new Robot("Ken", 5, 5, Classification.ASSISTANT)
        );
    }
}
