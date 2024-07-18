package br.dev.hygino.datas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.dev.hygino.model.Employee;

public class CollectionAula1 {
    public CollectionAula1() {
        test();
    }

    private void test() {
        final var employees = createEmployees();

        for (var emp : employees) {
            if (emp.department().equals("Faturamento")) {
                System.out.println(emp);
            }
        }

        System.out.println("\nUsando programação funcional");
        employees.stream()
                .filter(emp -> emp.department().equals("Faturamento"))
                .forEach(System.out::println);

        final var total = employees.stream()
                .filter(emp -> emp.department().equals("Faturamento"))
                .count();
        System.out.printf("Funcionarios no Faturamento: %d\n", total).println();

        final var somaSalarios = employees.stream()
                .filter(emp -> emp.department().equals("RH"))// filtra pelo departamento de RH
                .map(Employee::salary)// mapeia o salário
                .reduce(BigDecimal.ZERO, BigDecimal::add);// realiza a soma

        System.out.printf("Soma dos salarios do RH %.2f\n", somaSalarios);

        // verifica se existe algum funcionário do departamento de Vendas
        final var contaisFromVendas = employees.stream()
                .anyMatch(emp -> emp.department().equals("Vendas"));

        System.out.printf("\nExiste alguém do departamento de vendas: %s\n\n", contaisFromVendas);

        // filtra os empregados do faturamento limitando a 2
        final var employeesFromFaturamento = employees.stream()
                .filter(emp -> emp.department().equals("Faturamento"))
                .limit(2)
                .toList();

        System.out.println("Empregados do faturamento limitando a 2");
        employeesFromFaturamento.forEach(System.out::println);

        final var justOneDilma = employees.stream()
                .filter(emp -> emp.name().equals("Dilma Silva"))// filtra fucnionarios pelo nome informado
                .distinct()// pega um único
                .count();

        System.out.println(justOneDilma);

        System.out.println("Ordena a lista a partir de um comparador de salário em ordem decrescente");
        employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .forEach(System.out::println);

        // podemos ordenar a lista usando o método sorted
        employees.sort(Comparator.comparing(Employee::salary).reversed());

        System.out.println("\n\nFuncionários do Faturamento");
        final var totalSalaryFaturamento = employees.stream()
                .filter(emp -> emp.department().equals("Faturamento"))
                .peek(System.out::println)// exibe os elementos filtrados
                .map(Employee::salary)// mapeia o salário
                .reduce(BigDecimal.ZERO, BigDecimal::add);// realiza a soma

        System.out.println("Salario do departamento de faturamento: " + totalSalaryFaturamento);
        System.out.println("\n\n-------------------------------");
        employees.stream().findFirst().ifPresent(System.out::println);
    }

    private List<Employee> createEmployees() {
        final List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jupira Mendes", LocalDate.of(1987, 10, 5), new BigDecimal(1700), "Faturamento"));
        employees.add(new Employee("Carlos Silva", LocalDate.of(1990, 1, 15), new BigDecimal(2500), "RH"));
        employees.add(new Employee("Ana Souza", LocalDate.of(1985, 3, 22), new BigDecimal(3200), "Marketing"));
        employees.add(new Employee("Roberto Lima", LocalDate.of(1978, 5, 10), new BigDecimal(2900), "RH"));
        employees.add(new Employee("Fernanda Costa", LocalDate.of(1992, 7, 30), new BigDecimal(3100), "Financeiro"));
        employees.add(new Employee("José Pereira", LocalDate.of(1980, 9, 18), new BigDecimal(2000), "Logística"));
        employees.add(new Employee("Mariana Rocha", LocalDate.of(1983, 11, 25), new BigDecimal(2700), "Vendas"));
        employees.add(new Employee("Pedro Almeida", LocalDate.of(1975, 12, 12), new BigDecimal(2300), "RH"));
        employees.add(new Employee("Julia Ferreira", LocalDate.of(1995, 2, 14), new BigDecimal(2600), "Vendas"));
        employees.add(new Employee("Luiz Gonzaga", LocalDate.of(1989, 6, 6), new BigDecimal(2400), "RH"));
        employees.add(new Employee("Sandra Oliveira", LocalDate.of(1984, 4, 3), new BigDecimal(2800), "Faturamento"));
        employees.add(new Employee("Dilma Silva", LocalDate.of(1994, 9, 10), new BigDecimal(2100), "Logística"));

        return employees;
    }

    public static void main(String[] args) {
        new CollectionAula1();
    }
}
