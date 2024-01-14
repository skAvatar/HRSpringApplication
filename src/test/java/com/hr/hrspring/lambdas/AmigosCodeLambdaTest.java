package com.hr.hrspring.lambdas;

import com.hr.hrspring.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.hr.hrspring.dto.MockData.*;
import static com.hr.hrspring.enums.Gender.FEMALE;

@SpringBootTest
public class AmigosCodeLambdaTest {

    @Test
    void filterFemale() {
        // Imperative
        List<GenericPerson> females = new ArrayList<>();
        for (GenericPerson peopleActual : genericPeople) {
            if (FEMALE.equals(peopleActual.getGender())) {
                females.add(peopleActual);
            }
        }
        Assertions.assertEquals(3, females.size());

        // Declarative
        genericPeople.stream()
                .filter(genericPerson -> FEMALE.equals(genericPerson.getGender()))
                .toList()
                .forEach(System.out::println);
    }

    @Test
    public void lecture1() {
        people().stream()
                .filter(person -> person.getAge() <= 18)// <- Intermediate
                .limit(10)
                .toList()
                .forEach(System.out::println);// <- Terminal
    }

    @Test
    public void lecture2() {
        List<Person> people = people();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    Person person = people.get(index);
                    System.out.println(person);
                });
    }

    @Test
    public void lecture3() {
        Integer min = numbers.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("min > " + min);

        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("max > " + max);
    }

    @Test
    public void lecture4() {

        MockData.numbersDup.stream()
                .distinct()
                .toList()
                .forEach(System.out::print);

        // with SET
        new HashSet<>(MockData.numbersDup)
                .forEach(System.out::print);

    }

    @Test
    public void lecture5() {

        Predicate<UCar> uCarPredicate = uCar -> uCar.getPrice() < 20000;
        List<UCar> uCarsPrices = uCars().stream()
                .filter(uCarPredicate)
                .toList();

        System.out.println(uCarsPrices.size());

        // Mapping

        /*  Functional Interface
                Function<Person, PersonDTO> personPersonDTOFunction =
                person -> new PersonDTO(person.getId(), person.getName(), person.getAge());*/
        List<PersonDTO> peopleDTO = people().stream()
                .map(PersonDTO::map)
                .toList();

        Assertions.assertEquals(peopleDTO.size(), MockData.people().size());

        // AVG
        OptionalDouble average = uCars().stream()
                .mapToDouble(UCar::getPrice)
                .average();

        System.out.println("avg >> " + average.orElse(0));
    }

    @Test
    public void lecture6() {

        // non deterministic
        Predicate<Integer> integerPredicate = n -> n > 5 && n < 10;
        Integer any = numbers.stream()
                .filter(integerPredicate)
                .findAny().orElse(0);

        System.out.println("any >> " + any);

        // deterministic -> for stabled result
        Integer first = MockData.numbers.stream()
                .filter(integerPredicate)
                .findFirst().orElse(0);

        System.out.println("first >> " + first);
    }

    @Test
    public void lecture7() {
        Predicate<Person> booleanPredicate = person -> person.getGender().equalsIgnoreCase("female");
        long count = MockData.people().stream()
                .filter(booleanPredicate)
                .count();

        System.out.println("count >> " + count);

        double minYellow = uCars().stream()
                .filter(uCar -> uCar.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(UCar::getPrice)
                .min().orElse(0);

        System.out.println("minYellow >> " + minYellow);

        double maxYellow = uCars().stream()
                .filter(uCar -> uCar.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(UCar::getPrice)
                .max().orElse(0);

        System.out.println("maxYellow >> " + maxYellow);

        double avg = uCars().stream()
                .mapToDouble(UCar::getPrice)
                .average().orElse(0);

        System.out.println("avg >> " + avg);

        double sum = uCars().stream()
                .mapToDouble(UCar::getPrice)
                .sum();

        System.out.println("sum >> " + BigDecimal.valueOf(sum));
        DoubleSummaryStatistics statistics = uCars().stream()
                .mapToDouble(UCar::getPrice)
                .summaryStatistics();

        System.out.println("statistics >> " + statistics);
        System.out.println("statistics.avg >> " + statistics.getAverage());

    }

    @Test
    public void lecture8() {
        Map<String, List<UCar>> grouping = uCars().stream()
                .collect(Collectors.groupingBy(UCar::getMake));

        grouping.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });

        Map<GenericPerson, Long> counting = genericPeopleDub.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counting.forEach((name, count) ->
                System.out.println(name + " >> " + count));

    }

    @Test
    public void lecture9() {
        // basic
        Integer reduce = MockData.numbers.stream()
                .reduce(Integer::sum).orElse(0);

        System.out.println("reduce >> " + reduce);

        // Using sum
        Integer sum = MockData.numbers.stream()
                .reduce(Integer::sum).orElse(0);

        System.out.println("sum >> " + sum);

    }

    @Test
    public void lecture10() {

        // FlatMap
        List<String> names = MockData.matrixNames.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("names > " + names);

    }

    @Test
    public void lecture11() {

        /*
        <U> U reduce(U identity,
        BiFunction<U, ? super T, U> accumulator,
        BinaryOperator<U> combiner);
        */

        String reducedString = genericPeople.stream()
                .reduce("",
                        (names, genericPerson) -> names + genericPerson.getName() + ", "
                        , (a, b) -> a + b);

        System.out.println("reducedString >> " + reducedString.substring(0, reducedString.length() - 2));

        List<String> names = genericPeople.stream()
                .map(GenericPerson::getName)
                .toList();
        System.out.println("names >> " + names);

    }

    @Test
    public void lecture12() {
        List<String> emails = people().stream()
                .map(Person::getEmail)
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        emails.forEach(System.out::println);
    }

    @Test
    public void lecture13() {

        // Pipeline -> Are sequencing
        System.out.println(
                MockData.uCars().stream()
                    .filter(uCar -> {
                        System.out.println("filter Car " + uCar);
                        return uCar.getPrice() < 10000;
                    })
                    .map(uCar -> {
                        System.out.println("mapping Car " + uCar);
                        return uCar.getPrice();
                    })
                    .map(price -> {
                        System.out.println("mapping Car " + price);
                        return price + (price * .14);
                    }).toList()
        );
    }

}


