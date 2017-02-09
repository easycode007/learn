package patterns.composite;

/**
 * Created by Razvan on 29.01.2017.
 */
interface Employee {
    void add(Employee employee);
    void remove(Employee employee);
    Employee getChild(int i);
    String getName();
    double getSalary();
    void print();
}
